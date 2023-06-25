package com.example.BookMyShow.services.Impl;

import com.example.BookMyShow.exceptions.ResourceNotFoundException;
import com.example.BookMyShow.models.City;
import com.example.BookMyShow.models.Theatre;
import com.example.BookMyShow.payloads.TheatreDto;
import com.example.BookMyShow.repositories.CityRepo;
import com.example.BookMyShow.repositories.TheatreRepo;
import com.example.BookMyShow.services.TheatreService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TheatreServiceImpl implements TheatreService {
    @Autowired
    private TheatreRepo theatreRepo;

    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TheatreDto createTheatre(TheatreDto theatreDto, Integer cityId) {
        City city = this.cityRepo.findById(cityId)
                .orElseThrow(()->new ResourceNotFoundException("City", " City Id", cityId));

        Theatre theatre = this.modelMapper.map(theatreDto, Theatre.class);
        theatre.setCity(city);
        Theatre savedTheatre = this.theatreRepo.save(theatre);
        return this.modelMapper.map(savedTheatre, TheatreDto.class);
    }

    @Override
    public List<TheatreDto> getAllTheatres() {
        List<Theatre> theatres = this.theatreRepo.findAll();
        return theatres.stream()
                .map(theatre -> this.modelMapper.map(theatre, TheatreDto.class))
                .collect(Collectors.toList());
    }

    public List<TheatreDto> getAllTheatresByCity(Integer cityId) {
        City city = this.cityRepo.findById(cityId)
                .orElseThrow(()->new ResourceNotFoundException("City", " City Id", cityId));
        List<Theatre> theatres = this.theatreRepo.findByCity(city);
        return theatres
                .stream()
                .map(theatre -> this.modelMapper.map(theatre, TheatreDto.class))
                .collect(Collectors.toList());
    }
}
