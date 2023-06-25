package com.example.BookMyShow.payloads;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScreenSeatDto {
    private Integer rowNo;
    private Integer colNo;
    private String seatType;
}
