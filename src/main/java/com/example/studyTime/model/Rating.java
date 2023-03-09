package com.example.studyTime.model;

import com.example.studyTime.model.enums.RatingEnum;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JsonBackReference
    Course course;
    @Enumerated(EnumType.ORDINAL)
    RatingEnum ratingEnum;
    String comment;
    @OneToOne
    User user;

    public Rating(RatingEnum ratingEnum, String comment, Course course, User user) {
        this.ratingEnum = ratingEnum;
        this.comment = comment;
        this.course = course;
        this.user = user;
    }


}
