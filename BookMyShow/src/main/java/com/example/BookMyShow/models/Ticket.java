package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ticket")
@Getter
@Setter
public class Ticket extends BaseModel {
    private TicketStatus ticketStatus;
    @ManyToOne
    private Show show;
    @OneToMany(mappedBy = "ticket")
    private List<ShowSeat> showSeatsBooked = new ArrayList<>();
    @ManyToOne
    private User user;
    @OneToOne
    private Payment payment;
}
