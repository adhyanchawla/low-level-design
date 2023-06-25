package com.example.BookMyShow.controllers;


import com.example.BookMyShow.payloads.UserDto;
import com.example.BookMyShow.services.UserService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto userDto1 = this.userService.createUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @GetMapping("/users")
    ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtos = this.userService.getAllUSers();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }
}
