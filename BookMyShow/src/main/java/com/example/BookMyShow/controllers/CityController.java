package com.example.BookMyShow.controllers;

import com.example.BookMyShow.payloads.CityDto;
import com.example.BookMyShow.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/")
    public ResponseEntity<CityDto> createCity(@RequestBody CityDto cityDto) {
        System.out.println("we are city controller");
        CityDto cityDto1 = this.cityService.createCity(cityDto);
        return new ResponseEntity<>(cityDto1, HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CityDto>> getAllCities() {
        List<CityDto> cityDtos = this.cityService.getAllCities();
        return new ResponseEntity<>(cityDtos, HttpStatus.OK);
    }
}
