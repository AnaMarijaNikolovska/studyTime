package com.example.studyTime.service.impl;

import com.example.studyTime.model.Course;
import com.example.studyTime.model.Rating;
import com.example.studyTime.model.User;
import com.example.studyTime.model.dto.RatingDto;
import com.example.studyTime.model.enums.RatingEnum;
import com.example.studyTime.repository.RatingRepository;
import com.example.studyTime.service.CourseService;
import com.example.studyTime.service.RatingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements RatingService {
    private final RatingRepository ratingRepository;
    private final CourseService courseService;

    public RatingServiceImpl(RatingRepository ratingRepository, CourseService courseService) {
        this.ratingRepository = ratingRepository;
        this.courseService = courseService;
    }

    @Override
    public List<Rating> getAllCourseRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public Optional<Rating> getCourseRating(Long ratingId) {
        return ratingRepository.findById(ratingId);
    }

    @Override
    public Rating saveRating(RatingDto ratingDto, User user, Long courseId) {
        Optional<Course> optionalCourse = courseService.getCourse(courseId);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            RatingEnum ratingEnum = RatingEnum.fromInteger(ratingDto.getRating());

            Rating rating = new Rating(ratingEnum, ratingDto.getComment(), course,user);
             return ratingRepository.save(rating);

        }
        return null;
    }

    @Override
    public Rating updateRating(RatingDto ratingDto, Long ratingId) {
        Optional<Rating> existingRating = getCourseRating(ratingDto.getId());

        if (existingRating.isPresent()) {
            Rating courseRating = existingRating.get();
            RatingEnum ratingEnum = RatingEnum.fromInteger(ratingDto.getRating());
            courseRating.setRatingEnum(ratingEnum);
            courseRating.setComment(courseRating.getComment());
            return ratingRepository.save(courseRating);
        }
        return null;
    }

    @Override
    public void deleteRating(Long ratingId) {
        ratingRepository.deleteById(ratingId);
    }

}
