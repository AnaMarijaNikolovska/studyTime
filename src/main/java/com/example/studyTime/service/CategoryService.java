package com.example.studyTime.service;

import com.example.studyTime.model.Category;
import com.example.studyTime.model.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> getAllCategories();
    Optional<Category> getCategory(Long categoryId);
    Category saveCategory(CategoryDto categoryDto);
    Category updateCategory(CategoryDto categoryDto,Long id);
    void deleteCategory(Long categoryId);
}
