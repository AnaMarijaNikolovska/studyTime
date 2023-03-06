package com.example.studyTime.model.dto;

import com.example.studyTime.model.Category;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class CourseDto {
    String name;
    String description;
}
