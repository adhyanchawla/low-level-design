package com.example.BookMyShow.services.Impl;

import com.example.BookMyShow.models.User;
import com.example.BookMyShow.payloads.UserDto;
import com.example.BookMyShow.repositories.UserRepo;
import com.example.BookMyShow.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto, User.class);
        User savedUser = this.userRepo.save(user);
        return this.modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUSers() {
        List<User> users = this.userRepo.findAll();
        return users.stream().map(user -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }
}
