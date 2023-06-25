package com.example.BookMyShow.repositories;

import com.example.BookMyShow.models.City;
import com.example.BookMyShow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepo extends JpaRepository<Theatre, Integer> {
    List<Theatre> findByCity(City city);
}
