// package com.tazmaniandevils.soccer_club_backend.service;

// import com.tazmaniandevils.soccer_club_backend.model.ContactSubmission;
// import com.tazmaniandevils.soccer_club_backend.repository.ContactSubmissionRepository;
// import jakarta.mail.MessagingException;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.time.LocalDateTime;
// import java.time.format.DateTimeFormatter;
// import java.util.List;
// import java.util.Optional;

// @Service
// public class ContactService {
    
//     private final ContactSubmissionRepository contactSubmissionRepository;
//     private final EmailService emailService;
    
//     @Autowired
//     public ContactService(ContactSubmissionRepository contactSubmissionRepository, EmailService emailService) {
//         this.contactSubmissionRepository = contactSubmissionRepository;
//         this.emailService = emailService;
//     }
    
//     @Transactional
//     public ContactSubmission submitContactForm(ContactSubmission submission) {
//         // Save the submission to the database
//         ContactSubmission savedSubmission = contactSubmissionRepository.save(submission);
        
//         try {
//             // Send confirmation email to the user
//             String userHtmlContent = String.format(
//                 "<html><body>" +
//                 "<h1>Thank You for Contacting Tazmanian Devils Soccer Club</h1>" +
//                 "<p>Dear %s,</p>" +
//                 "<p>Thank you for your interest in the Tazmanian Devils Soccer Club for %s.</p>" +
//                 "<p>We have received your inquiry about: <strong>%s</strong></p>" +
//                 "<p>A member of our team will be in contact with you shortly.</p>" +
//                 "<p>Best regards,<br/>Tazmanian Devils Soccer Club</p>" +
//                 "</body></html>",
//                 submission.getParentName(), submission.getPlayerName(), submission.getInterest()
//             );
            
//             emailService.sendHtmlEmail(
//                 submission.getEmail(), 
//                 "Thank You for Contacting Tazmanian Devils Soccer Club", 
//                 userHtmlContent
//             );
            
//             // Send notification email to admin
//             String adminHtmlContent = String.format(
//                 "<html><body>" +
//                 "<h1>New Contact Form Submission</h1>" +
//                 "<p><strong>Player Name:</strong> %s</p>" +
//                 "<p><strong>Parent Name:</strong> %s</p>" +
//                 "<p><strong>Email:</strong> %s</p>" +
//                 "<p><strong>Player DOB:</strong> %s</p>" +
//                 "<p><strong>Town:</strong> %s</p>" +
//                 "<p><strong>Interest:</strong> %s</p>" +
//                 "<p><strong>Message:</strong> %s</p>" +
//                 "</body></html>",
//                 submission.getPlayerName(),
//                 submission.getParentName(),
//                 submission.getEmail(),
//                 submission.getPlayerDOB().format(DateTimeFormatter.ISO_LOCAL_DATE),
//                 submission.getTown(),
//                 submission.getInterest(),
//                 submission.getMessage() != null ? submission.getMessage() : "No message provided"
//             );
            
//             emailService.sendHtmlEmail(
//                 "admin@tazmaniandevils.com", 
//                 "New Contact Form Submission", 
//                 adminHtmlContent
//             );
            
//         } catch (MessagingException e) {
//             // Log the error but don't fail the submission
//             System.err.println("Error sending emails: " + e.getMessage());
//         }
        
//         return savedSubmission;
//     }
    
//     public List<ContactSubmission> getAllSubmissions() {
//         return contactSubmissionRepository.findAll();
//     }
    
//     public List<ContactSubmission> getUnprocessedSubmissions() {
//         return contactSubmissionRepository.findByProcessed(false);
//     }
    
//     public Optional<ContactSubmission> getSubmissionById(Long id) {
//         return contactSubmissionRepository.findById(id);
//     }
    
//     @Transactional
//     public Optional<ContactSubmission> markAsProcessed(Long id) {
//         return contactSubmissionRepository.findById(id)
//                 .map(submission -> {
//                     submission.setProcessed(true);
//                     return contactSubmissionRepository.save(submission);
//                 });
//     }
    
//     public List<ContactSubmission> getSubmissionsByDateRange(LocalDateTime start, LocalDateTime end) {
//         return contactSubmissionRepository.findBySubmissionTimeBetween(start, end);
//     }
// }