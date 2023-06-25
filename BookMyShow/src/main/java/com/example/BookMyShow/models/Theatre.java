package com.example.BookMyShow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "theatre")
@Getter
@Setter
public class Theatre extends BaseModel {
    private String name;
    @ManyToOne
    private City city;
    @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
    private List<Screen> screens = new ArrayList<>();
}
