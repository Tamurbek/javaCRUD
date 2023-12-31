package com.example.crudapp.controller;

import com.example.crudapp.dto.ApiResponse;
import com.example.crudapp.dto.UserDto;
import com.example.crudapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @PostMapping("/createUser")
    public HttpEntity<?> createUser(@Validated @ModelAttribute UserDto userDto) throws IOException {
        ApiResponse apiResponse=userService.createUser(userDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/updateUser/{id}")
    public HttpEntity<?> updateUser(@Validated @PathVariable Long id,@Validated @ModelAttribute UserDto userDto) throws IOException {
        ApiResponse apiResponse=userService.updateUser(id,userDto);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/deleteIdUser/{id}")
    public HttpEntity<?> deleteUser(@Validated @PathVariable Long id) throws IOException {
        ApiResponse apiResponse=userService.deleteIdUser(id);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/deleteAllUser/")
    public HttpEntity<?> deleteAllUser(){
        ApiResponse apiResponse=userService.deleteAllUsers();
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/getIdUser/{id}")
    public HttpEntity<?> getIdUser(@Validated @PathVariable Long id){
        ApiResponse apiResponse=userService.getIdUser(id);
        return ResponseEntity.ok(apiResponse);
    }


    @GetMapping("/getAllUser/")
    public HttpEntity<?> getAllUser(){
        ApiResponse apiResponse=userService.getUsers();
        return ResponseEntity.ok(apiResponse);
    }

}
