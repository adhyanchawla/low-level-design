package com.example.BookMyShow.repositories;

import com.example.BookMyShow.models.Screen;
import com.example.BookMyShow.models.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScreenRepo extends JpaRepository<Screen, Integer> {
    List<Screen> findByTheatre(Theatre theatre);
}
