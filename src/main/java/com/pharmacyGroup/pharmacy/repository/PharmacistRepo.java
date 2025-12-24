package com.pharmacyGroup.pharmacy.repository;

import com.pharmacyGroup.pharmacy.model.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacistRepo extends JpaRepository<Pharmacist,Long> {
}
