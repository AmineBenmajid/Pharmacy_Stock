package com.pharmacyGroup.pharmacy.controller;

import com.pharmacyGroup.pharmacy.model.Pharmacist;
import com.pharmacyGroup.pharmacy.service.PharmacistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pharmacists")
public class PharmacistController {
    @Autowired
    private PharmacistService pharmacistService;

    @PostMapping("/add_med_to_pharm/{id_pharm}/{id_med}")
    public Pharmacist addMedicationToPharmacist( @PathVariable Long id_pharm, @PathVariable Long id_med){
        return pharmacistService.addMedicationToPharmacist(id_pharm, id_med);
    }
}
