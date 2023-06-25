package com.example.BookMyShow.payloads;

import com.example.BookMyShow.models.Show;
import com.example.BookMyShow.models.ShowSeat;
import com.example.BookMyShow.models.TicketStatus;
import com.example.BookMyShow.models.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class TicketDto {
    private TicketStatus ticketStatus;
    private ShowDto show;
    private List<ShowSeatDto> showSeatsBooked = new ArrayList<>();
    private Integer userId;
}
