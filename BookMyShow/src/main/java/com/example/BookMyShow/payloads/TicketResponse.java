package com.example.BookMyShow.payloads;

import com.example.BookMyShow.models.TicketStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
    private TicketStatus ticketStatus;
    private ShowDto show;
    private Integer userId;
    private List<ShowSeatDto> showSeatsBooked = new ArrayList<>();
}
