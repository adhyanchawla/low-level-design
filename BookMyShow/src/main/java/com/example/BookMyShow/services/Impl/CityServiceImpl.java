package com.example.BookMyShow.services.Impl;

import com.example.BookMyShow.models.City;
import com.example.BookMyShow.models.Theatre;
import com.example.BookMyShow.payloads.CityDto;
import com.example.BookMyShow.payloads.TheatreDto;
import com.example.BookMyShow.repositories.CityRepo;
import com.example.BookMyShow.repositories.TheatreRepo;
import com.example.BookMyShow.services.CityService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepo cityRepo;

    @Autowired
    private TheatreRepo theatreRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CityDto createCity(CityDto cityDto) {
        System.out.println("we are city service");
        City city = this.modelMapper.map(cityDto, City.class);
        City savedCity = this.cityRepo.save(city);
        return this.modelMapper.map(savedCity, CityDto.class);
    }

    @Override
    public List<CityDto> getAllCities() {
        List<City> cities = this.cityRepo.findAll();
        return cities.stream().map(city -> this.modelMapper.map(city, CityDto.class)).collect(Collectors.toList());
    }
}
