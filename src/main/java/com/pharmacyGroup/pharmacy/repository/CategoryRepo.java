package com.pharmacyGroup.pharmacy.repository;

import com.pharmacyGroup.pharmacy.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
