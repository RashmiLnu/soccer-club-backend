package com.tazmaniandevils.soccer_club_backend.config;

import com.tazmaniandevils.soccer_club_backend.model.Coach;
import com.tazmaniandevils.soccer_club_backend.model.PlayerReview;
import com.tazmaniandevils.soccer_club_backend.model.Service;
import com.tazmaniandevils.soccer_club_backend.repository.CoachRepository;
import com.tazmaniandevils.soccer_club_backend.repository.PlayerReviewRepository;
import com.tazmaniandevils.soccer_club_backend.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    
    @Autowired
    private ServiceRepository serviceRepository;
    
    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private PlayerReviewRepository playerReviewRepository;
    
    @Bean
    public CommandLineRunner initData() {
        return args -> {
            // Services initialization (your existing code)
            if (serviceRepository.count() == 0) {
                Service training = new Service(
                        "Training",
                        "Professional from backend soccer training sessions for players of all levels",
                        "soccer-ball-icon"
                );
                
                Service coaching = new Service(
                        "Coaching",
                        "Expert coaches with personalized feedback and development plans",
                        "coaching-icon"
                );
                
                Service events = new Service(
                        "Events",
                        "Tournaments and special soccer events throughout the year",
                        "events-icon"
                );
                
                serviceRepository.save(training);
                serviceRepository.save(coaching);
                serviceRepository.save(events);
                
                System.out.println("Initial services data loaded!");
            }
            
            // Coach initialization
            if (coachRepository.count() == 0) {
                Coach coach1 = new Coach(
                    "John Smith",
                    "Head Coach",
                    "Coach John has been with the Tazmanian Devils for over 15 years. A former professional player, he brings extensive experience and tactical knowledge to our team.",
                    "/images/coach-john.jpg"
                );
                
                Coach coach2 = new Coach(
                    "Mike Johnson",
                    "Assistant Coach",
                    "Coach Mike specializes in offensive strategy and player development. With 10 years of coaching experience and a background in sports psychology.",
                    "/images/coach-mike.jpg"
                );
                
                Coach coach3 = new Coach(
                    "Sarah Williams",
                    "Fitness Coach",
                    "Coach Sarah is a certified athletic trainer with expertise in sports medicine and nutrition. She designs custom fitness programs for each player.",
                    "/images/coach-sarah.jpg"
                );
                
                coachRepository.save(coach1);
                coachRepository.save(coach2);
                coachRepository.save(coach3);
                
                System.out.println("Initial coach data loaded!");
            }

            if (playerReviewRepository.count() == 0) {
            playerReviewRepository.save(new PlayerReview(
                "Marcus Johnson",
                "New York, NY",
                "The coaching at Tazmanian Devils has transformed my game. I've improved tremendously since joining.",
                "/images/player1.jpg"
            ));
            
            playerReviewRepository.save(new PlayerReview(
                "Sophia Rodriguez",
                "Brooklyn, NY",
                "The team atmosphere is amazing. Coaches make every practice challenging and fun at the same time.",
                "/images/player2.jpg"
            ));
            
            playerReviewRepository.save(new PlayerReview(
                "Tyler Williams",
                "Queens, NY",
                "I've learned so much about discipline and teamwork. This club develops players both on and off the field.",
                "/images/player3.jpg"
            ));
            
            playerReviewRepository.save(new PlayerReview(
                "Emma Chen",
                "Manhattan, NY",
                "The personalized training has helped me overcome my weaknesses. Best soccer experience I've had.",
                "/images/player4.jpg"
            ));
            
            playerReviewRepository.save(new PlayerReview(
                "Jamal Washington",
                "Bronx, NY",
                "From basic skills to advanced tactics, the coaches here know how to bring out the best in every player.",
                "/images/player5.jpg"
            ));
            
            System.out.println("Initial player review data loaded!");
        }
        };
    }
}