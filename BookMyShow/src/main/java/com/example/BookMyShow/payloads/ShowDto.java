package com.example.BookMyShow.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowDto {
    private Integer showId;
    private Date startTime;
    private MovieDto movie;
}
