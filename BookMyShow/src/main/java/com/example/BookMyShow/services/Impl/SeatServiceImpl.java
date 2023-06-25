package com.example.BookMyShow.services.Impl;

import com.example.BookMyShow.exceptions.ResourceNotFoundException;
import com.example.BookMyShow.models.Screen;
import com.example.BookMyShow.models.ScreenSeat;
import com.example.BookMyShow.models.Show;
import com.example.BookMyShow.models.ShowSeat;
import com.example.BookMyShow.payloads.ScreenSeatDto;
import com.example.BookMyShow.payloads.ShowSeatDto;
import com.example.BookMyShow.repositories.ScreenRepo;
import com.example.BookMyShow.repositories.ScreenSeatsRepo;
import com.example.BookMyShow.repositories.ShowRepo;
import com.example.BookMyShow.repositories.ShowSeatRepo;
import com.example.BookMyShow.services.SeatService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private ScreenSeatsRepo screenSeatsRepo;
    @Autowired
    private ScreenRepo screenRepo;
    @Autowired
    private ShowRepo showRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ShowSeatRepo showSeatRepo;
    @Override
    public ScreenSeatDto createSeat(ScreenSeatDto screenSeatDto, Integer screenId) {
        Screen screen = this.screenRepo.findById(screenId)
                        .orElseThrow(()-> new ResourceNotFoundException("Screen", "Screen Id", screenId));
        ScreenSeat screenSeat = this.modelMapper.map(screenSeatDto, ScreenSeat.class);
        screenSeat.setScreen(screen);
        ScreenSeat savedSeat = this.screenSeatsRepo.save(screenSeat);
        return this.modelMapper.map(savedSeat, ScreenSeatDto.class);
    }

    @Override
    public ShowSeatDto createShowSeat(ShowSeatDto showSeatDto, Integer showId, Integer seatId) {
        Show show = this.showRepo.findById(showId)
                .orElseThrow(()-> new ResourceNotFoundException("Show", "Show Id", showId));
        ScreenSeat screenSeat = this.screenSeatsRepo.findById(seatId)
                .orElseThrow(()-> new ResourceNotFoundException("Seat", "Seat Id", seatId));
        ShowSeat showSeat = this.modelMapper.map(showSeatDto, ShowSeat.class);
        if(showSeat.getIsOccupied()) {
            System.out.println("Seat with seat col-row " + screenSeat.getColNo() + " "
                    + screenSeat.getRowNo() + " already booked for show "
                    + show.getStartTime() + " movie"  + show.getMovie());
            return showSeatDto;
        }
        showSeat.setIsOccupied(false);
        showSeat.setShow(show);
        showSeat.setScreenSeat(screenSeat);
        ShowSeat saveShowSeat = this.showSeatRepo.save(showSeat);
        return this.modelMapper.map(saveShowSeat, ShowSeatDto.class);
    }

    @Override
    public List<ShowSeatDto> getAvailableSeats(Integer showId) {
        Show show = this.showRepo.findById(showId)
                .orElseThrow(()->new ResourceNotFoundException("Show", "ShowId", showId));
        List<ShowSeat> showSeats = show.getSeats();
        List<ShowSeat> availableSeats = new ArrayList<>();
        for(ShowSeat showSeat: showSeats) {
            if(!showSeat.getIsOccupied()) {
                availableSeats.add(showSeat);
            }
        }
        
        return availableSeats.stream()
                .map(showSeat -> this.modelMapper.map(showSeat, ShowSeatDto.class))
                .collect(Collectors.toList());
    }
}
