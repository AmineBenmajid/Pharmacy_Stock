package com.pharmacyGroup.pharmacy.service;

import com.pharmacyGroup.pharmacy.model.Medication;
import com.pharmacyGroup.pharmacy.model.Pharmacist;
import com.pharmacyGroup.pharmacy.repository.MedicationRepo;
import com.pharmacyGroup.pharmacy.repository.PharmacistRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacistService {
    @Autowired
    private PharmacistRepo pharmacistRepo;

    @Autowired
    private MedicationRepo medicationRepo;

    public Pharmacist addMedicationToPharmacist(Long idPharm, Long idMed) {
        Pharmacist pharmacist = pharmacistRepo.findById(idPharm).orElseThrow(()-> new RuntimeException("Pharmacist not found"));
        Medication medication = medicationRepo.findById(idMed).orElseThrow(()-> new RuntimeException("Medication not found"));

        pharmacist.getMedications().add(medication);
        return pharmacistRepo.save(pharmacist);
    }
}
