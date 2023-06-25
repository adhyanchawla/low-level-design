package com.example.BookMyShow.controllers;

import com.example.BookMyShow.payloads.ShowDto;
import com.example.BookMyShow.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class ShowController {
    @Autowired
    private ShowService showService;

    @PostMapping("/movie/{movieId}/screen/{screenId}/show")
    public ResponseEntity<ShowDto> createShow(@RequestBody ShowDto showDto,
                                              @PathVariable Integer screenId,
                                              @PathVariable Integer movieId) {
        ShowDto showDto1 = this.showService.createShow(showDto, screenId, movieId);
        return new ResponseEntity<>(showDto1, HttpStatus.CREATED);
    }
}
