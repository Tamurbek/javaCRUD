package com.example.crudapp.service;

import com.example.crudapp.dto.ApiResponse;
import com.example.crudapp.dto.UserDto;

import java.io.IOException;

public interface UserService {
    ApiResponse createUser(UserDto userDto) throws IOException;
    ApiResponse updateUser(Long id,UserDto userDto) throws IOException;
    ApiResponse getIdUser(Long id);
    ApiResponse getUsers();
    ApiResponse deleteIdUser(Long id);
    ApiResponse deleteAllUsers();
}
