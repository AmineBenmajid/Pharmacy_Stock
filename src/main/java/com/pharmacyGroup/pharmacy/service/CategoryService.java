package com.pharmacyGroup.pharmacy.service;

import com.pharmacyGroup.pharmacy.model.Category;
import com.pharmacyGroup.pharmacy.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo){
        this.categoryRepo = categoryRepo;
    }

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category createCategory(Category  category){
        return categoryRepo.save(category);
    }


}
