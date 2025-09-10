package com.tazmaniandevils.soccer_club_backend.service;

import com.tazmaniandevils.soccer_club_backend.model.Coach;
import com.tazmaniandevils.soccer_club_backend.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoachService {
    
    private final CoachRepository coachRepository;
    
    @Autowired
    public CoachService(CoachRepository coachRepository) {
        this.coachRepository = coachRepository;
    }
    
    public List<Coach> getAllCoaches() {
        return coachRepository.findAll();
    }
    
    public Optional<Coach> getCoachById(Long id) {
        return coachRepository.findById(id);
    }
    
    public Coach createCoach(Coach coach) {
        return coachRepository.save(coach);
    }
    
    public Optional<Coach> updateCoach(Long id, Coach coachDetails) {
        return coachRepository.findById(id)
                .map(existingCoach -> {
                    existingCoach.setName(coachDetails.getName());
                    existingCoach.setTitle(coachDetails.getTitle());
                    existingCoach.setBio(coachDetails.getBio());
                    existingCoach.setImageUrl(coachDetails.getImageUrl());
                    return coachRepository.save(existingCoach);
                });
    }
    
    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }
}