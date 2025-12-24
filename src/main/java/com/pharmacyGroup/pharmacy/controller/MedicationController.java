package com.pharmacyGroup.pharmacy.controller;

import com.pharmacyGroup.pharmacy.model.Category;
import com.pharmacyGroup.pharmacy.model.Medication;
import com.pharmacyGroup.pharmacy.service.CategoryService;
import com.pharmacyGroup.pharmacy.service.MedicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // Replace with your frontend URL
@RequestMapping("/api/medications")
public class MedicationController {

    private final MedicationService medicationService;

    @Autowired
    public MedicationController(MedicationService medicationService) {

        this.medicationService = medicationService;
    }

    // Create a new medication
    @PostMapping("/add")
    public Medication createMedication(@RequestBody Medication medication) {
        return medicationService.createMedication(medication);
    }

    @PostMapping("/add_multi")
    public List<Medication> createMedications(@RequestBody List<Medication> medications) {
        return medicationService.createMedications(medications);
    }

    // Get all medications
    @GetMapping("/all")
    public List<Medication> getAllMedications() {
        return medicationService.getAllMedications();
    }

    // Get a medication by ID
    @GetMapping("/{id}")
    public ResponseEntity<Medication> getMedicationById(@PathVariable Long id) {
        return medicationService.getMedicationById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Update a medication
    @PutMapping("/{id}")
    public Medication updateMedication(@PathVariable Long id, @RequestBody Medication medicationDetails) {
        return medicationService.updateMedication(id, medicationDetails);
    }

    // Delete a medication
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMedication(@PathVariable Long id) {
        medicationService.deleteMedication(id);
        return ResponseEntity.noContent().build();
    }

    //Other Methods:
    @GetMapping("/name/{name}")
    public List<Medication> getMedicationsByName(@PathVariable String name) {
        return medicationService.getMedicationsByName(name);
    }

    @GetMapping("/dosage/{dosage}")
    public List<Medication> getMedicationsByDosage(@PathVariable Double dosage) {
        return medicationService.getMedicationsByDosage(dosage);
    }

    @GetMapping("/expired")
    public List<Medication> getExpiredMedications() {
        return medicationService.getExpiredMedications();
    }

    @GetMapping("/expensive_than/{price}")
    public List<Medication> getMedicationsMoreThan(@PathVariable Double price) {
        return medicationService.getMedicationsMoreThan(price);
    }

    @PutMapping("/update_expensive_than/{price}/{newPrice}")
    public List<Medication> updateMedicationsAbovePrice(@PathVariable Double price, @PathVariable Double newPrice) {
        return medicationService.updateMedicationsAbovePrice(price,newPrice);
    }

    @GetMapping("get_category_name/{id}")
    public String getCategoryNameByMedicationId(@PathVariable Long id){
        return medicationService.getCategoryNameByMedicationId(id);
    }

}