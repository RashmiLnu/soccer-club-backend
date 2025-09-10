package com.tazmaniandevils.soccer_club_backend.repository;

import com.tazmaniandevils.soccer_club_backend.model.Coach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Long> {
    // Custom query methods can be added here if needed
}