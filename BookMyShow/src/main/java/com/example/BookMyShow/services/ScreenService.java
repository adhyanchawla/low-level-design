package com.example.BookMyShow.services;

import com.example.BookMyShow.payloads.ScreenDto;

import java.util.List;

public interface ScreenService {
    ScreenDto createScreen(ScreenDto screenDto, Integer theatreId);

    List<ScreenDto> getAllScreensByTheatre(Integer theatreId);
}
