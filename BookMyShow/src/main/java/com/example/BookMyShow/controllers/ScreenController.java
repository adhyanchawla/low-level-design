package com.example.BookMyShow.controllers;

import com.example.BookMyShow.payloads.ScreenDto;
import com.example.BookMyShow.services.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class ScreenController {
    @Autowired
    private ScreenService screenService;

    @PostMapping("/theatre/{theatreId}/screen")
    public ResponseEntity<ScreenDto> createScreen(@RequestBody ScreenDto screenDto, @PathVariable Integer theatreId) {
        ScreenDto screenDto1 = this.screenService.createScreen(screenDto, theatreId);
        return new ResponseEntity<>(screenDto1, HttpStatus.CREATED);
    }

    @GetMapping("/theatre/{theatreId}/screens")
    public ResponseEntity<List<ScreenDto>> getAllScreens(@PathVariable Integer theatreId) {
        List<ScreenDto> screenDtos = this.screenService.getAllScreensByTheatre(theatreId);
        return new ResponseEntity(screenDtos, HttpStatus.OK);
    }
}
