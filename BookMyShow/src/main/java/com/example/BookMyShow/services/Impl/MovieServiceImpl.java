package com.example.BookMyShow.services.Impl;

import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.payloads.MovieDto;
import com.example.BookMyShow.repositories.MovieRepo;
import com.example.BookMyShow.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public MovieDto createMovie(MovieDto movieDto) {
        Movie movie = this.modelMapper.map(movieDto, Movie.class);
        Movie savedMovie = this.movieRepo.save(movie);
        return this.modelMapper.map(savedMovie, MovieDto.class);
    }
}
