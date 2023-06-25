package com.example.BookMyShow.controllers;

import com.example.BookMyShow.payloads.MovieDto;
import com.example.BookMyShow.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @PostMapping("/")
    ResponseEntity<MovieDto> createMovie(@RequestBody MovieDto movieDto) {
        MovieDto movieDto1 = this.movieService.createMovie(movieDto);
        return new ResponseEntity<>(movieDto1, HttpStatus.CREATED);
    }
}
