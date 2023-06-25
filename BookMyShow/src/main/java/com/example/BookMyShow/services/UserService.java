package com.example.BookMyShow.services;

import com.example.BookMyShow.payloads.UserDto;

import java.util.List;

public interface UserService {
    //select seats
    //book seats
    UserDto createUser(UserDto userDto);
    List<UserDto> getAllUSers();
}
