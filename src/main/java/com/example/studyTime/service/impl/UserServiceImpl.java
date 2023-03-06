package com.example.studyTime.service.impl;

import com.example.studyTime.model.Course;
import com.example.studyTime.model.User;
import com.example.studyTime.model.dto.CourseDto;
import com.example.studyTime.model.dto.UserDto;
import com.example.studyTime.repository.UserRepository;
import com.example.studyTime.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllAccounts() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getAccountByUsername(String username) {
        return userRepository.findById(username);
    }

    @Override
    public User saveAccount(UserDto userDto, MultipartFile picture) throws IOException {
        User user = new User();
        if (picture != null) {
            user.setPhoto(user.getPhoto());
        }
        user.setUsername(user.getUsername());
        setDataToUser(user,userDto);
        return userRepository.save(user);
    }

    @Override
    public User editAccount(UserDto userDto, String username, MultipartFile picture) throws IOException {
        Optional<User> optionalUser = getAccountByUsername(username);
        if (optionalUser.isPresent()){
            User user =optionalUser.get();
            if (picture != null) {
                user.setPhoto(user.getPhoto());
            }
            setDataToUser(user,userDto);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteAccount(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("username not found"));
    }

    private void setDataToUser(User user, UserDto userDto) {
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setEmail(userDto.getEmail());
        user.setCourseList(userDto.getCourseList());
        user.setPassword(userDto.getPassword());
    }
}
