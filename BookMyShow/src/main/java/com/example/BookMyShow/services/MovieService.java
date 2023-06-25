package com.example.BookMyShow.services;

import com.example.BookMyShow.payloads.MovieDto;

public interface MovieService {
    MovieDto createMovie(MovieDto movieDto);
}
