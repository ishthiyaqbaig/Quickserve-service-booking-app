package com.example.quickserve.dto;
import lombok.Data;

@Data
public class ListingCreateRequest {
    private String serviceName;
    private String description;
    private Double price;
    private String availability;
    private String category;
    private String city;
}