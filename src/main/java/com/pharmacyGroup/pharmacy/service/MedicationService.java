package com.pharmacyGroup.pharmacy.service;


import com.pharmacyGroup.pharmacy.model.Category;
import com.pharmacyGroup.pharmacy.model.Medication;
import com.pharmacyGroup.pharmacy.repository.MedicationRepo;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MedicationService {

    private final MedicationRepo medicationRepo;

    @Autowired
    public MedicationService(MedicationRepo medicationRepo) {
        this.medicationRepo = medicationRepo;
    }

    // Create a new medication
    public Medication createMedication(Medication medication) {

        return medicationRepo.save(medication);
    }

    public List<Medication> createMedications(List<Medication> medications) {
        return medications.stream()
                .map(medicationRepo::save)
                .collect(Collectors.toList());
    }
    // Get all medications
    public List<Medication> getAllMedications() {
        return medicationRepo.findAll();
    }

    // Get medication by ID
    public Optional<Medication> getMedicationById(Long id) {
        return medicationRepo.findById(id);
    }
/*
    // Update medication 1
    public Medication updateMedication(Long id, Medication medicationDetails) {
        Medication medication = medicationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Medication not found with id " + id));

        medication.setName(medicationDetails.getName());
        medication.setDosage(medicationDetails.getDosage());
        medication.setQuantity(medicationDetails.getQuantity());
        medication.setExpirationDate(medicationDetails.getExpirationDate());
        medication.setPrice(medicationDetails.getPrice());

        return medicationRepo.save(medication);
    }
*/
    // Update medication 2
    public Medication updateMedication(Long id, Medication medicationDetails) {
        Medication medication = medicationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Medication not found with id " + id));

        BeanUtils.copyProperties(medicationDetails, medication, "id"); // Exclude ID to prevent overwriting

        return medicationRepo.save(medication);
    }

    // Delete medication
    public void deleteMedication(Long id) {
        medicationRepo.deleteById(id);
    }

    //Other Methods:
    public List<Medication> getMedicationsByName(String name) {
        return medicationRepo.findByName(name); // You'd need to define this in your repo
    }

    public List<Medication> getMedicationsByDosage(Double dosage) {
        return medicationRepo.findByDosage(dosage); // You'd need to define this in your repo
    }

    public List<Medication> getExpiredMedications() {
        LocalDate today = LocalDate.now();
        return medicationRepo.findByExpirationDateBefore(today); // Define in repo
    }

    public List<Medication> getMedicationsMoreThan(Double price){
        return medicationRepo.findByPriceGreaterThan(price);
    }

    public List<Medication> updateMedicationsAbovePrice(Double price, Double newPrice) {
        List<Medication> medications = medicationRepo.findByPriceGreaterThan(price);

        for (Medication medication : medications) {
            medication.setPrice(newPrice); // Update the price
            medicationRepo.save(medication); // Save the updated medication
        }

        return medications; // Return the updated list
    }

    public String getCategoryNameByMedicationId(Long id){
        Medication medication = medicationRepo.findById(id).orElseThrow(()-> new EntityNotFoundException("Medication not found with id " + id));
        Category category =medication.getCategory();
        return category != null ? category.getName() : null;
    }
}