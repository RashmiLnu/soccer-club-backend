package com.tazmaniandevils.soccer_club_backend.repository;

import com.tazmaniandevils.soccer_club_backend.model.PlayerReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerReviewRepository extends JpaRepository<PlayerReview, Long> {
    // Custom queries if needed
}