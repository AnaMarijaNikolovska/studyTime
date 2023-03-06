package com.example.studyTime.service;

import com.example.studyTime.model.User;
import com.example.studyTime.model.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    List<User> getAllAccounts();
    Optional<User> getAccountByUsername(String username);
    User saveAccount(UserDto userDto, MultipartFile picture) throws IOException;
    User editAccount(UserDto userDto,String username,MultipartFile picture) throws IOException;
    void deleteAccount(String username);
}
