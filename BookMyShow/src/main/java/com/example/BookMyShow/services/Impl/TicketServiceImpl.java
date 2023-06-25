package com.example.BookMyShow.services.Impl;

import com.example.BookMyShow.exceptions.ResourceNotFoundException;
import com.example.BookMyShow.models.*;
import com.example.BookMyShow.payloads.ShowSeatDto;
import com.example.BookMyShow.payloads.TicketDto;
import com.example.BookMyShow.payloads.TicketResponse;
import com.example.BookMyShow.repositories.ShowRepo;
import com.example.BookMyShow.repositories.ShowSeatRepo;
import com.example.BookMyShow.repositories.TicketRepo;
import com.example.BookMyShow.repositories.UserRepo;
import com.example.BookMyShow.services.SeatService;
import com.example.BookMyShow.services.TicketService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepo ticketRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ShowRepo showRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ShowSeatRepo showSeatRepo;
    @Autowired
    private SeatService seatService;
    @Override
    @Transactional
    public TicketResponse createTicket(TicketDto ticketDto, Integer userId, Integer showId) {
        User user = this.userRepo.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("User", "UserId", userId));
        Show show = this.showRepo.findById(showId).
                orElseThrow(()->new ResourceNotFoundException("Show", "ShowId", showId));
        Ticket ticket = this.modelMapper.map(ticketDto, Ticket.class);
        List<ShowSeatDto> showSeatListBooked = ticketDto.getShowSeatsBooked();
        List<ShowSeat> showSeatsToBook = new ArrayList<>();
        System.out.println(showSeatListBooked);
        if(checkIfSeatsOccupied(showSeatListBooked)) {
            throw new RuntimeException("Seats are already occupied");
        } else {
            List<ShowSeat> showSeatsInShow = show.getSeats();
            for(ShowSeat showSeat: showSeatsInShow) {
                for(ShowSeatDto showSeatBooked: showSeatListBooked) {
                    if(showSeatIsInvalid(showSeatBooked)) {
                        if(Objects.equals(showSeat.getId(), showSeatBooked.getId())) {
                            showSeat.setIsOccupied(true);
                            showSeat.setTicket(ticket);
                            showSeatsToBook.add(showSeat);
                        }
                    }
                }
            }
        }
        ticket.setShowSeatsBooked(showSeatsToBook);
        ticket.setUser(user);
        ticket.setShow(show);
        ticket.setTicketStatus(TicketStatus.PAYMENT_PENDING);
        Ticket savedTicket = this.ticketRepo.save(ticket);
        return this.modelMapper.map(savedTicket, TicketResponse.class);
    }

    private boolean showSeatIsInvalid(ShowSeatDto showSeatDto) {
        ShowSeat showSeat = this.showSeatRepo.findById(showSeatDto.getId())
                .orElseThrow(()->new ResourceNotFoundException("ShowSeat", "ShowSeatId", showSeatDto.getId()));
        return true;
    }

    private boolean checkIfSeatsOccupied(List<ShowSeatDto> showSeatsBooked) {
        for(ShowSeatDto showSeatDto: showSeatsBooked) {
            ShowSeat showSeat = this.showSeatRepo.
                    findById(showSeatDto.getId()).orElseThrow(()-> new ResourceNotFoundException("ShowSeat", "ShowSeatId", showSeatDto.getId()));
            if(showSeat.getIsOccupied()) {
                return true;
            }
        }
        return false;
    }
}
