package com.tazmaniandevils.soccer_club_backend.service;

import com.tazmaniandevils.soccer_club_backend.model.PlayerReview;
import com.tazmaniandevils.soccer_club_backend.repository.PlayerReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerReviewService {
    
    private final PlayerReviewRepository playerReviewRepository;
    
    @Autowired
    public PlayerReviewService(PlayerReviewRepository playerReviewRepository) {
        this.playerReviewRepository = playerReviewRepository;
    }
    
    public List<PlayerReview> getAllPlayerReviews() {
        return playerReviewRepository.findAll();
    }
    
    public Optional<PlayerReview> getPlayerReviewById(Long id) {
        return playerReviewRepository.findById(id);
    }
    
    public PlayerReview createPlayerReview(PlayerReview playerReview) {
        return playerReviewRepository.save(playerReview);
    }
    
    public Optional<PlayerReview> updatePlayerReview(Long id, PlayerReview playerReviewDetails) {
        return playerReviewRepository.findById(id)
                .map(existingReview -> {
                    existingReview.setPlayerName(playerReviewDetails.getPlayerName());
                    existingReview.setLocation(playerReviewDetails.getLocation());
                    existingReview.setReview(playerReviewDetails.getReview());
                    existingReview.setImageUrl(playerReviewDetails.getImageUrl());
                    return playerReviewRepository.save(existingReview);
                });
    }
    
    public void deletePlayerReview(Long id) {
        playerReviewRepository.deleteById(id);
    }
}