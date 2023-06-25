package com.example.BookMyShow.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityDto {
    private Integer cityId;
    private String cityName;
    private List<TheatreDto> theatreDtoList = new ArrayList<>();
}
