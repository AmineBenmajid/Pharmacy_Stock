package com.pharmacyGroup.pharmacy.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


@Entity
@Data  // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor  // Generates a no-argument constructor
@AllArgsConstructor
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double dosage;
    private int quantity;
    private String imageUrl;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") // <--- ADD THIS LINE
    private Date expirationDate;
    private double price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = true)

    private Category category;

    @ManyToMany(mappedBy = "medications")
    @JsonBackReference
    private List<Pharmacist> pharmacists;
}