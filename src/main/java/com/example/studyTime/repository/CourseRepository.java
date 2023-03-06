package com.example.studyTime.repository;

import com.example.studyTime.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    //getAllCoursesByCategory
    @Transactional
    List<Course> findAllByCategory(Long catgeoryId);
}
