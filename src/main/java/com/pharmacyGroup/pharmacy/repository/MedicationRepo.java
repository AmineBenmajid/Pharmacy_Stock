package com.pharmacyGroup.pharmacy.repository;

import com.pharmacyGroup.pharmacy.model.Category;
import com.pharmacyGroup.pharmacy.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface MedicationRepo extends JpaRepository<Medication, Long> {

    List<Medication> findByName(String name);
    List<Medication> findByDosage(Double dosage);
    List<Medication> findByExpirationDateBefore(LocalDate today);
    List<Medication> findByPriceGreaterThan(double priceIsGreaterThan);




}
