package com.example.studyTime.service.impl;

import com.example.studyTime.model.Category;
import com.example.studyTime.model.Course;
import com.example.studyTime.model.dto.CategoryDto;
import com.example.studyTime.model.dto.CourseDto;
import com.example.studyTime.repository.CourseRepository;
import com.example.studyTime.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public List<Course> getAllCoursesByCategory(Long categoryId) {
        return courseRepository.findAllByCategory(categoryId);
    }

    @Override
    public Optional<Course> getCourse(Long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Course saveCourse(CourseDto courseDto) {
        Course course = new Course();
        setDataToCourse(course, courseDto);
        return courseRepository.save(course);
    }

    @Override
    public Course updateCourse(CourseDto courseDto, Long id) {
        Optional<Course> optionalCourse = getCourse(id);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            setDataToCourse(course,courseDto);
            return courseRepository.save(course);
        }
        return null;
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    private void setDataToCourse(Course course, CourseDto courseDto) {
        course.setName(courseDto.getName());
        course.setDescription(courseDto.getDescription());
    }
}
