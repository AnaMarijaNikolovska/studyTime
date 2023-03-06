package com.example.studyTime.model.dto;

import com.example.studyTime.model.Course;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    String username;
    String name;
    String surname;
    String email;
    String password;
    boolean isTeacher;
    List<Course> courseList;
}
