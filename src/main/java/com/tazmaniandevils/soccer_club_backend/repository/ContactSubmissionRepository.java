package com.tazmaniandevils.soccer_club_backend.repository;

import com.tazmaniandevils.soccer_club_backend.model.ContactSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ContactSubmissionRepository extends JpaRepository<ContactSubmission, Long> {
    
    // Find submissions by processed status
    List<ContactSubmission> findByProcessed(boolean processed);
    
    // Find submissions within a date range
    List<ContactSubmission> findBySubmissionTimeBetween(LocalDateTime start, LocalDateTime end);
    
    // Find submissions for a specific interest
    List<ContactSubmission> findByInterest(String interest);
}