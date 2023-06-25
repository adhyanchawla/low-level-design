package com.example.BookMyShow.services;

import com.example.BookMyShow.payloads.TheatreDto;

import java.util.List;

public interface TheatreService {
    TheatreDto createTheatre(TheatreDto theatreDto, Integer cityId);

    List<TheatreDto> getAllTheatres();
    //update, delete
    List<TheatreDto> getAllTheatresByCity(Integer theatreId);
}
