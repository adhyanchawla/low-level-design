package com.example.BookMyShow.services.Impl;

import com.example.BookMyShow.exceptions.ResourceNotFoundException;
import com.example.BookMyShow.models.*;
import com.example.BookMyShow.payloads.PaymentDto;
import com.example.BookMyShow.repositories.PaymentRepo;
import com.example.BookMyShow.repositories.ShowSeatRepo;
import com.example.BookMyShow.repositories.TicketRepo;
import com.example.BookMyShow.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private PaymentRepo paymentRepo;
    @Autowired
    private ShowSeatRepo showSeatRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public PaymentDto updatePayment(PaymentDto paymentDto, Integer ticketId) {
        Ticket ticket = this.ticketRepo.findById(ticketId)
                .orElseThrow(()->new ResourceNotFoundException("Ticket", "TicketId", ticketId));
        Payment payment = this.modelMapper.map(paymentDto, Payment.class);
        List<ShowSeat> showSeats = ticket.getShowSeatsBooked();
        System.out.println("Seats booked in payments " + ticket.getShowSeatsBooked());
        switch (payment.getPaymentStatus()) {
            case PENDING: {
                for(ShowSeat showSeat: showSeats) {
                    showSeat.setIsOccupied(false);
                    showSeat.setTicket(null);
                }
                ticket.setShowSeatsBooked(showSeats);
                ticket.setTicketStatus(TicketStatus.UNCONFIRMED);
                ticket.setShowSeatsBooked(new ArrayList<>());
                ticket.setPayment(payment);
                this.ticketRepo.save(ticket);
                break;
            }
            case CONFIRMED: {
                if(payment.getPaymentRefId() == null)
                    payment.setPaymentRefId(UUID.randomUUID().toString());
                this.ticketRepo.save(ticket);
                ticket.setPayment(payment);
                ticket.setTicketStatus(TicketStatus.BOOKED);
                break;
            }
        }
        payment.setTicket(ticket);
        System.out.println("Seat status in payments " + ticket.getShowSeatsBooked());
        Payment savedPayment = this.paymentRepo.save(payment);
        return this.modelMapper.map(savedPayment, PaymentDto.class);
    }
}
