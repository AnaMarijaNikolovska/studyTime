package com.example.studyTime.controller;

import com.example.studyTime.model.User;
import com.example.studyTime.model.dto.UserDto;
import com.example.studyTime.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    List<User> findAllUsers(){
        return userService.getAllAccounts();
    }

    @GetMapping("/{username}")
    Optional<User> findUser(@PathVariable String username){
        return userService.getAccountByUsername(username);
    }

    @PostMapping
    User addUser(@RequestBody UserDto userDto, @RequestParam MultipartFile picture) throws IOException {
        return userService.saveAccount(userDto,picture);
    }

    @PutMapping("/{username}")
    User editUser(@PathVariable String username, @RequestBody UserDto userDto, @RequestParam MultipartFile picture) throws IOException {
        return userService.editAccount(userDto,username,picture);
    }

    @DeleteMapping("/{username}")
    void deleteUser(@PathVariable String username){
        userService.deleteAccount(username);
    }
}
