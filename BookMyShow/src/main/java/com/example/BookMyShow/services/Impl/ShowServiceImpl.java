package com.example.BookMyShow.services.Impl;

import com.example.BookMyShow.exceptions.ResourceNotFoundException;
import com.example.BookMyShow.models.Movie;
import com.example.BookMyShow.models.Screen;
import com.example.BookMyShow.models.Show;
import com.example.BookMyShow.payloads.ShowDto;
import com.example.BookMyShow.repositories.MovieRepo;
import com.example.BookMyShow.repositories.ScreenRepo;
import com.example.BookMyShow.repositories.ShowRepo;
import com.example.BookMyShow.services.ShowService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ShowServiceImpl implements ShowService {
    @Autowired
    private MovieRepo movieRepo;
    @Autowired
    private ShowRepo showRepo;
    @Autowired
    private ScreenRepo screenRepo;
    @Autowired
    private ModelMapper modelMapper;

    public ShowDto createShow(ShowDto showDto, Integer screenId, Integer movieId) {
        Movie movie = this.movieRepo.findById(movieId)
                .orElseThrow(()->new ResourceNotFoundException("Movie", "MovieId", movieId));
        Screen screen = this.screenRepo.findById(screenId)
                .orElseThrow(()->new ResourceNotFoundException("Screen", "Screen", screenId));
        Show show = this.modelMapper.map(showDto, Show.class);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartTime(new Date());
//        this.screenRepo.save(screen);
        Show savedShow = this.showRepo.save(show);
        return this.modelMapper.map(savedShow, ShowDto.class);
    }
}
