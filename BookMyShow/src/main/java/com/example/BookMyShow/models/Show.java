package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "show")
@Getter
@Setter
public class Show extends BaseModel {
    private Date startTime;
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeat> seats = new ArrayList<>();
    @ManyToOne
    private Screen screen;
    @ManyToOne
    private Movie movie;
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<Ticket> tickets = new ArrayList<>();
}
