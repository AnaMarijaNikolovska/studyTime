package com.example.studyTime.service;

import com.example.studyTime.model.Rating;
import com.example.studyTime.model.User;
import com.example.studyTime.model.dto.RatingDto;

import java.util.List;
import java.util.Optional;

public interface RatingService {
    List<Rating> getAllCourseRatings();

    Optional<Rating> getCourseRating(Long ratingId);

    Rating updateRating (RatingDto ratingDto,Long ratingId);

    Rating saveRating(RatingDto ratingDto, User user, Long courseId);

    void deleteRating(Long ratingId);
}
