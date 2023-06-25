package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "SHOW_SEATS")
@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class ShowSeat extends BaseModel {
    @ManyToOne
    private ScreenSeat screenSeat;
    @ManyToOne
    private Show show;
    private Boolean isOccupied = false;
    @ManyToOne(cascade = CascadeType.ALL)
    private Ticket ticket;
}
