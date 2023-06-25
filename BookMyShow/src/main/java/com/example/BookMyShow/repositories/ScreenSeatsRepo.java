package com.example.BookMyShow.repositories;

import com.example.BookMyShow.models.ScreenSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenSeatsRepo extends JpaRepository<ScreenSeat, Integer> {
}
