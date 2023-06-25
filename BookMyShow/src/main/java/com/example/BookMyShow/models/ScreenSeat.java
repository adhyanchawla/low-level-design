package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "SCREEN_SEATS")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class ScreenSeat extends BaseModel {
    private Integer rowNo;
    private Integer colNo;
    private String seatType;
    @OneToMany(mappedBy = "screenSeat", cascade = CascadeType.ALL)
    private List<ShowSeat> showSeats = new ArrayList<>();
    @ManyToOne
    private Screen screen;
}

