package com.tazmaniandevils.soccer_club_backend.repository;

import com.tazmaniandevils.soccer_club_backend.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    // JpaRepository provides basic CRUD operations
    // You can add custom query methods here if needed
}
