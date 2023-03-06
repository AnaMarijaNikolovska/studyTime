package com.example.studyTime.service;

import com.example.studyTime.model.Course;
import com.example.studyTime.model.dto.CourseDto;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    List<Course> getAllCourses();
    List<Course> getAllCoursesByCategory(Long categoryId);
    Optional<Course> getCourse(Long courseId);
    Course saveCourse(CourseDto courseDto);
    Course updateCourse(CourseDto courseDto,Long id);
    void deleteCourse(Long courseId);

//TODO
    //mozebi treba RatingService, pa da se premesti tamu
//    Integer getAverageRatingForCourse(Long courseId);

//    maybe
//    List<Courses> getAllCoursesByTeacher(String teacherUsername);
//    Courses addCourseToMyList(Long id);
//    List<Courses> getAllCoursesInMyList(Long courseId);
}
