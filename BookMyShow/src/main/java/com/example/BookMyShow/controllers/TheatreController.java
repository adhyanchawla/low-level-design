package com.example.BookMyShow.controllers;

import com.example.BookMyShow.payloads.TheatreDto;
import com.example.BookMyShow.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class TheatreController {
    @Autowired
    private TheatreService theatreService;

    @PostMapping("/city/{cityId}/theatre/")
    public ResponseEntity<TheatreDto> createTheatre(@RequestBody TheatreDto theatreDto,@PathVariable Integer cityId) {
        TheatreDto newTheatre = this.theatreService.createTheatre(theatreDto, cityId);
        return new ResponseEntity<>(newTheatre, HttpStatus.CREATED);
    }

    @GetMapping("/theatres/")
    public ResponseEntity<List<TheatreDto>> getAllTheatres() {
        List<TheatreDto> theatreDtoList = this.theatreService.getAllTheatres();
        return new ResponseEntity<>(theatreDtoList, HttpStatus.OK);
    }

    @GetMapping("/city/{cityId}/theatres")
    public ResponseEntity<List<TheatreDto>> getAllTheatresByCity(@PathVariable Integer cityId) {
        List<TheatreDto> theatreDtoList = this.theatreService.getAllTheatresByCity(cityId);
        return new ResponseEntity<>(theatreDtoList, HttpStatus.OK);
    }
}
