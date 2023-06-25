package com.example.BookMyShow.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShowSeatDto {
    private Integer id;
    private ShowDto show;
    private Boolean isOccupied = false;
}
