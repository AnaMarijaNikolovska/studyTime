package com.example.studyTime.repository;

import com.example.studyTime.model.Rating;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating,Long> {
    @Transactional
    List<Rating> getAllByCourseId(Long courseId);
}
