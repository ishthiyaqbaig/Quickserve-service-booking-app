package com.example.quickserve.service;

import com.example.quickserve.dto.ListingCreateRequest;
import com.example.quickserve.dto.ListingUpdateRequest;
import com.example.quickserve.model.Listing;
import com.example.quickserve.repository.ListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListingService {

    private final ListingRepository listingRepository;

    public Listing createListingForProvider(Long providerId, ListingCreateRequest req) {
        Listing listing = new Listing();
        listing.setProviderId(providerId);
        listing.setServiceName(req.getServiceName());
        listing.setDescription(req.getDescription());
        listing.setPrice(req.getPrice());
        listing.setAvailability(req.getAvailability());
        listing.setCategory(req.getCategory());
        listing.setCity(req.getCity());
        return listingRepository.save(listing);
    }

    public List<Listing> getListingsForProvider(Long providerId) {
        return listingRepository.findByProviderId(providerId);
    }

    public Listing updateListingForProvider(Long providerId, Long listingId, ListingUpdateRequest req) {
        Listing listing = listingRepository.findByIdAndProviderId(listingId, providerId)
                .orElseThrow(() -> new RuntimeException("Listing not found for this provider"));

        if (req.getServiceName() != null) listing.setServiceName(req.getServiceName());
        if (req.getDescription() != null) listing.setDescription(req.getDescription());
        if (req.getPrice() != null) listing.setPrice(req.getPrice());
        if (req.getAvailability() != null) listing.setAvailability(req.getAvailability());
        if (req.getCategory() != null) listing.setCategory(req.getCategory());
        if (req.getCity() != null) listing.setCity(req.getCity());

        return listingRepository.save(listing);
    }

    public void deleteListingForProvider(Long providerId, Long listingId) {
        Listing listing = listingRepository.findByIdAndProviderId(listingId, providerId)
                .orElseThrow(() -> new RuntimeException("Listing not found for this provider"));

        listingRepository.delete(listing);
    }
}