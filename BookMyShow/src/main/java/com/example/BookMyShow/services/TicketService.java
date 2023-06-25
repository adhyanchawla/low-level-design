package com.example.BookMyShow.services;

import com.example.BookMyShow.payloads.TicketDto;
import com.example.BookMyShow.payloads.TicketResponse;

public interface TicketService {
    TicketResponse createTicket(TicketDto ticketDto, Integer userId, Integer showId);
}
