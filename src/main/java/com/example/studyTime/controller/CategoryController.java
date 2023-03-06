package com.example.studyTime.controller;

import com.example.studyTime.model.Category;
import com.example.studyTime.model.dto.CategoryDto;
import com.example.studyTime.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping
    List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    Optional<Category> getCategory(@PathVariable Long id){
        return categoryService.getCategory(id);
    }

    @PostMapping
    Category addCategory(@RequestBody CategoryDto categoryDto){
        return categoryService.saveCategory(categoryDto);
    }

    @PutMapping("/{id}")
    Category editCategory(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
        return categoryService.updateCategory(categoryDto, id);
    }

    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
    }

}
