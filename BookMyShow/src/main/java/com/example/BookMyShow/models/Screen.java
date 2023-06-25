package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "screen")
@Getter
@Setter
public class Screen extends BaseModel {
    private String screenName;
    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<ScreenSeat> screenSeats = new ArrayList<>();
    @ManyToOne
    private Theatre theatre;
    @OneToMany(mappedBy = "screen", cascade = CascadeType.ALL)
    private List<Show> shows = new ArrayList<>();
}
