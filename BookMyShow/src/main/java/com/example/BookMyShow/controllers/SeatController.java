package com.example.BookMyShow.controllers;


import com.example.BookMyShow.models.ShowSeat;
import com.example.BookMyShow.payloads.ScreenSeatDto;
import com.example.BookMyShow.payloads.ShowSeatDto;
import com.example.BookMyShow.services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class SeatController {
    @Autowired
    private SeatService seatService;

    @PostMapping("/screen/{screenId}/seat")
    public ResponseEntity<ScreenSeatDto> createScreenSeat(@RequestBody ScreenSeatDto screenSeatDto, @PathVariable Integer screenId) {
        ScreenSeatDto seatDto = this.seatService.createSeat(screenSeatDto, screenId);
        return new ResponseEntity<>(seatDto, HttpStatus.CREATED);
    }

    @GetMapping("/show/{showId}/available-seats")
    public ResponseEntity<List<ShowSeatDto>> getAvailableSeats(@PathVariable Integer showId) {
        List<ShowSeatDto> showSeatDtos = this.seatService.getAvailableSeats(showId);
        return new ResponseEntity<>(showSeatDtos, HttpStatus.OK);
    }

    @PostMapping("/show/{showId}/seat/{seatId}")
    public ResponseEntity<ShowSeatDto> createShowSeat(@RequestBody ShowSeatDto showSeatDto, @PathVariable Integer showId,
                                                      @PathVariable Integer seatId) {
        ShowSeatDto showSeatDto1 = this.seatService.createShowSeat(showSeatDto, showId, seatId);
        return new ResponseEntity<>(showSeatDto1, HttpStatus.CREATED);
    }
}
