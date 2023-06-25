package com.example.BookMyShow.services;

import com.example.BookMyShow.payloads.CityDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CityService {
    CityDto createCity(CityDto cityDto);
    //remove, update, delete
    List<CityDto> getAllCities();
}
