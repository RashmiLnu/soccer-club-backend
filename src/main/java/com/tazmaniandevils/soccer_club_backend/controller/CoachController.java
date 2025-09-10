package com.tazmaniandevils.soccer_club_backend.controller;

import com.tazmaniandevils.soccer_club_backend.model.Coach;
import com.tazmaniandevils.soccer_club_backend.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coaches")
@CrossOrigin(origins = "http://localhost:5173") // Your React app's URL
public class CoachController {
    
    private final CoachService coachService;
    
    @Autowired
    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }
    
    @GetMapping
    public List<Coach> getAllCoaches() {
        return coachService.getAllCoaches();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Coach> getCoachById(@PathVariable Long id) {
        return coachService.getCoachById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Coach createCoach(@RequestBody Coach coach) {
        return coachService.createCoach(coach);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Coach> updateCoach(@PathVariable Long id, @RequestBody Coach coach) {
        return coachService.updateCoach(id, coach)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return ResponseEntity.noContent().build();
    }
}