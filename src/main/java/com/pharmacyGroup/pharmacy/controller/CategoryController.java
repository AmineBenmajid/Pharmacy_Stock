package com.pharmacyGroup.pharmacy.controller;

import com.pharmacyGroup.pharmacy.model.Category;
import com.pharmacyGroup.pharmacy.model.Medication;
import com.pharmacyGroup.pharmacy.service.CategoryService;
import com.pharmacyGroup.pharmacy.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "http://localhost:4200") // <--- THIS LINE IS MISSING OR NOT WORKING
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping(value = "/add")
    public Category CreateCategory(@RequestBody Category category){
        return categoryService.createCategory(category);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
}
