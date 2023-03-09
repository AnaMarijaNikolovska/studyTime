package com.example.studyTime.controller;

import com.example.studyTime.model.Rating;
import com.example.studyTime.model.User;
import com.example.studyTime.model.dto.RatingDto;
import com.example.studyTime.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rating")
public class RatingController {
    @Autowired
    RatingService ratingService;

    @GetMapping
    List<Rating> getAllRatings() {
        return ratingService.getAllCourseRatings();
    }

    @GetMapping("/{ratingId}")
    Optional<Rating> getCourseRating(@PathVariable Long ratingId) {
        return ratingService.getCourseRating(ratingId);
    }

    @PostMapping
    Rating addRating(@RequestBody RatingDto ratingDto, @RequestParam User user, @RequestParam Long courseId) {
        return ratingService.saveRating(ratingDto, user, courseId);
    }

    @PutMapping("/{ratingId}")
    Rating editRating(@RequestBody RatingDto ratingDto, @PathVariable Long ratingId) {
        return ratingService.updateRating(ratingDto, ratingId);
    }

    @DeleteMapping("/{ratingId}")
    void deleteRating(@PathVariable Long ratingId) {
        ratingService.deleteRating(ratingId);
    }
}
