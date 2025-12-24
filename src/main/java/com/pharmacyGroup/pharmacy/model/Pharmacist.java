package com.pharmacyGroup.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity @Data @AllArgsConstructor @NoArgsConstructor

public class Pharmacist {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Name;
    private String email;

    @ManyToMany
    @JsonBackReference
    @JoinTable(
            name = "pharmacist_medication",
            joinColumns = @JoinColumn(name = "pharmacist_id"),
            inverseJoinColumns = @JoinColumn(name = "medication_id")
    )
    private List<Medication> medications;
}
