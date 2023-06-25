package com.example.BookMyShow.services;

import com.example.BookMyShow.payloads.ShowDto;

public interface ShowService {
    ShowDto createShow(ShowDto showDto, Integer screenId, Integer movieId);
}
