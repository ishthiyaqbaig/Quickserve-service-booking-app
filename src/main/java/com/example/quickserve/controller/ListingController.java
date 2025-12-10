package com.example.quickserve.controller;
import com.example.quickserve.dto.ListingCreateRequest;
import com.example.quickserve.dto.ListingUpdateRequest;
import com.example.quickserve.model.Listing;
import com.example.quickserve.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers/{providerId}/listings")
@RequiredArgsConstructor
public class ListingController {

    private final ListingService listingService;

    @PostMapping
    public ResponseEntity<Listing> createListing(
            @PathVariable Long providerId,
            @RequestBody ListingCreateRequest request) {
        return ResponseEntity.ok(listingService.createListingForProvider(providerId, request));
    }

    @GetMapping
    public ResponseEntity<List<Listing>> getListings(
            @PathVariable Long providerId) {
        return ResponseEntity.ok(listingService.getListingsForProvider(providerId));
    }

    @PutMapping("/{listingId}")
    public ResponseEntity<Listing> updateListing(
            @PathVariable Long providerId,
            @PathVariable Long listingId,
            @RequestBody ListingUpdateRequest request) {
        return ResponseEntity.ok(listingService.updateListingForProvider(providerId, listingId, request));
    }

    @DeleteMapping("/{listingId}")
    public ResponseEntity<Void> deleteListing(
            @PathVariable Long providerId,
            @PathVariable Long listingId) {
        listingService.deleteListingForProvider(providerId, listingId);
        return ResponseEntity.noContent().build();
    }
}