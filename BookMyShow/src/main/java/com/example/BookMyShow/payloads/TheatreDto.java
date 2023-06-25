package com.example.BookMyShow.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TheatreDto {
    private Integer theatreId;
    private String name;
    private CityDto city;
    private List<ScreenDto> screens = new ArrayList<>();
}
