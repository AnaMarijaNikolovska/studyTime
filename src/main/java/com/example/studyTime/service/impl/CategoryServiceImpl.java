package com.example.studyTime.service.impl;

import com.example.studyTime.model.Category;
import com.example.studyTime.model.dto.CategoryDto;
import com.example.studyTime.repository.CategoryRepository;
import com.example.studyTime.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }

    @Override
    public Category saveCategory(CategoryDto categoryDto) {
        Category category = new Category();
        setDataToCategory(category, categoryDto);

        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(CategoryDto categoryDto, Long id) {
        Optional<Category> optionalCategory = getCategory(id);

        if (optionalCategory.isPresent()) {
            Category editCategory = optionalCategory.get();
            setDataToCategory(editCategory, categoryDto);

            return categoryRepository.save(editCategory);
        }
        return null;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    private void setDataToCategory(Category category, CategoryDto categoryDto) {
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
    }
}
