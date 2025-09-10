// package com.tazmaniandevils.soccer_club_backend.controller;

// import com.tazmaniandevils.soccer_club_backend.model.ContactSubmission;
// import com.tazmaniandevils.soccer_club_backend.service.ContactService;
// import jakarta.validation.Valid;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.format.annotation.DateTimeFormat;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import java.time.LocalDateTime;
// import java.util.List;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/contact")
// @CrossOrigin(origins = "http://localhost:5173")
// public class ContactController {
    
//     private final ContactService contactService;
    
//     @Autowired
//     public ContactController(ContactService contactService) {
//         this.contactService = contactService;
//     }
    
//     @PostMapping("/submit")
//     public ResponseEntity<ContactSubmission> submitContactForm(@Valid @RequestBody ContactSubmission submission) {
//         ContactSubmission savedSubmission = contactService.submitContactForm(submission);
//         return ResponseEntity.status(HttpStatus.CREATED).body(savedSubmission);
//     }
    
//     // Admin endpoints - these would typically be secured
//     @GetMapping("/admin/submissions")
//     public ResponseEntity<List<ContactSubmission>> getAllSubmissions() {
//         return ResponseEntity.ok(contactService.getAllSubmissions());
//     }
    
//     @GetMapping("/admin/submissions/unprocessed")
//     public ResponseEntity<List<ContactSubmission>> getUnprocessedSubmissions() {
//         return ResponseEntity.ok(contactService.getUnprocessedSubmissions());
//     }
    
//     @GetMapping("/admin/submissions/{id}")
//     public ResponseEntity<ContactSubmission> getSubmissionById(@PathVariable Long id) {
//         return contactService.getSubmissionById(id)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }
    
//     @PutMapping("/admin/submissions/{id}/process")
//     public ResponseEntity<ContactSubmission> markAsProcessed(@PathVariable Long id) {
//         return contactService.markAsProcessed(id)
//                 .map(ResponseEntity::ok)
//                 .orElse(ResponseEntity.notFound().build());
//     }
    
//     @GetMapping("/admin/submissions/by-date-range")
//     public ResponseEntity<List<ContactSubmission>> getSubmissionsByDateRange(
//             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
//             @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
//         return ResponseEntity.ok(contactService.getSubmissionsByDateRange(start, end));
//     }
    
//     // Status response for health checks
//     @GetMapping("/status")
//     public ResponseEntity<Map<String, String>> getStatus() {
//         return ResponseEntity.ok(Map.of("status", "Contact API is running"));
//     }
// }