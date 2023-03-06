package com.example.studyTime.controller;

import com.example.studyTime.model.Course;
import com.example.studyTime.model.dto.CourseDto;
import com.example.studyTime.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    CourseService courseService;

    @GetMapping
    List<Course> findAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{categoryId}")
    List<Course> findAllCoursesByCategory(@PathVariable Long categoryId){
        return courseService.getAllCoursesByCategory(categoryId);
    }

    @GetMapping("/{id}")
    Optional<Course> findCourse(@PathVariable Long id){
        return courseService.getCourse(id);
    }

    @PostMapping
    Course addCourse(@RequestBody CourseDto courseDto){
        return courseService.saveCourse(courseDto);
    }

    @PutMapping("/{id}")
    Course editCourse(@PathVariable Long id, @RequestBody CourseDto courseDto){
        return courseService.updateCourse(courseDto,id);
    }

    @DeleteMapping("/{id}")
    void deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
    }
}
