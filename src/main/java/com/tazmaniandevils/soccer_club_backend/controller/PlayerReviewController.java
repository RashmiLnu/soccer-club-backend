package com.tazmaniandevils.soccer_club_backend.controller;

import com.tazmaniandevils.soccer_club_backend.model.PlayerReview;
import com.tazmaniandevils.soccer_club_backend.service.PlayerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player-reviews")
@CrossOrigin(origins = "http://localhost:5173") // Your React app's URL
public class PlayerReviewController {
    
    private final PlayerReviewService playerReviewService;
    
    @Autowired
    public PlayerReviewController(PlayerReviewService playerReviewService) {
        this.playerReviewService = playerReviewService;
    }
    
    @GetMapping
    public List<PlayerReview> getAllPlayerReviews() {
        return playerReviewService.getAllPlayerReviews();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<PlayerReview> getPlayerReviewById(@PathVariable Long id) {
        return playerReviewService.getPlayerReviewById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PlayerReview createPlayerReview(@RequestBody PlayerReview playerReview) {
        return playerReviewService.createPlayerReview(playerReview);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<PlayerReview> updatePlayerReview(@PathVariable Long id, @RequestBody PlayerReview playerReview) {
        return playerReviewService.updatePlayerReview(id, playerReview)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayerReview(@PathVariable Long id) {
        playerReviewService.deletePlayerReview(id);
        return ResponseEntity.noContent().build();
    }
}