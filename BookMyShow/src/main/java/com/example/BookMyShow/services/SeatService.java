package com.example.BookMyShow.services;

import com.example.BookMyShow.models.ScreenSeat;
import com.example.BookMyShow.models.ShowSeat;
import com.example.BookMyShow.payloads.ScreenSeatDto;
import com.example.BookMyShow.payloads.ShowSeatDto;

import java.util.List;

public interface SeatService {
    ScreenSeatDto createSeat(ScreenSeatDto screenSeatDto, Integer screenId);
    ShowSeatDto createShowSeat(ShowSeatDto showSeatDto, Integer showId, Integer seatId);
    List<ShowSeatDto> getAvailableSeats(Integer showId);
}
