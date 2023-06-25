package com.example.BookMyShow.payloads;

import com.example.BookMyShow.models.Show;
import com.example.BookMyShow.models.Theatre;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
public class ScreenDto {
    private Integer screenId;
    private String screenName;
    private List<ShowDto> shows = new ArrayList<>();
    private String theatreName;
    private List<ScreenSeatDto> seats = new ArrayList<>();
}
