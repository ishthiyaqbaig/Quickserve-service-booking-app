package com.example.quickserve.repository;

import com.example.quickserve.model.Listing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ListingRepository extends JpaRepository<Listing, Long> {

    Optional<Listing> findByIdAndProviderId(Long id, Long providerId);

    void deleteByIdAndProviderId(Long id, Long providerId);

    List<Listing> findByProviderId(Long providerId);
}