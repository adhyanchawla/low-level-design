package com.example.BookMyShow.controllers;

import com.example.BookMyShow.payloads.TicketDto;
import com.example.BookMyShow.payloads.TicketResponse;
import com.example.BookMyShow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @PostMapping("/user/{userId}/show/{showId}/ticket")
    public ResponseEntity<TicketResponse> createTicket(@RequestBody TicketDto ticketDto, @PathVariable Integer userId, @PathVariable Integer showId) {
        TicketResponse ticketResponse = this.ticketService.createTicket(ticketDto, userId, showId);
        return new ResponseEntity<>(ticketResponse, HttpStatus.CREATED);
    }
}
