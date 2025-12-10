package com.example.quickserve.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "listings")
@Data
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String serviceName;
    private String description;
    private Double price;
    private String availability;
    private String category;
    private String city;

    @Column(nullable = false)
    private Long providerId;
}