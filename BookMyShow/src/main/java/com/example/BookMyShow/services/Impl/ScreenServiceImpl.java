package com.example.BookMyShow.services.Impl;

import com.example.BookMyShow.exceptions.ResourceNotFoundException;
import com.example.BookMyShow.models.Screen;
import com.example.BookMyShow.models.Theatre;
import com.example.BookMyShow.payloads.ScreenDto;
import com.example.BookMyShow.repositories.ScreenRepo;
import com.example.BookMyShow.repositories.TheatreRepo;
import com.example.BookMyShow.services.ScreenService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreenServiceImpl implements ScreenService {
    @Autowired
    private TheatreRepo theatreRepo;

    @Autowired
    private ScreenRepo screenRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ScreenDto createScreen(ScreenDto screenDto, Integer theatreId) {
        Theatre theatre = this.theatreRepo.findById(theatreId).orElseThrow(()->new ResourceNotFoundException("Theatre", " Theatre Id ", theatreId));
        Screen screen = this.modelMapper.map(screenDto, Screen.class);
        screen.setTheatre(theatre);
        Screen savedScreen = this.screenRepo.save(screen);
        return this.modelMapper.map(savedScreen, ScreenDto.class);
    }

    @Override
    public List<ScreenDto> getAllScreensByTheatre(Integer theatreId) {
        Theatre theatre = this.theatreRepo.findById(theatreId).orElseThrow(()->new ResourceNotFoundException("Theatre", " Theatre Id ", theatreId));
        List<Screen> screens = this.screenRepo.findByTheatre(theatre);
        return screens.stream().map(screen -> this.modelMapper.map(screen, ScreenDto.class)).collect(Collectors.toList());
    }
}
