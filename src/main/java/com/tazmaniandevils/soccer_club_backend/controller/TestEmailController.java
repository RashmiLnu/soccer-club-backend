// package com.tazmaniandevils.soccer_club_backend.controller;

// import com.tazmaniandevils.soccer_club_backend.service.EmailService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import jakarta.mail.MessagingException;
// import java.util.HashMap;
// import java.util.Map;

// @RestController
// @RequestMapping("/api/test")
// public class TestEmailController {

//     private final EmailService emailService;

//     @Autowired
//     public TestEmailController(EmailService emailService) {
//         this.emailService = emailService;
//     }

//     @GetMapping("/send-email")
//     public ResponseEntity<Map<String, String>> testEmail(@RequestParam String to) {
//         Map<String, String> response = new HashMap<>();
        
//         try {
//             // Send a simple test email
//             emailService.sendSimpleEmail(
//                 to,
//                 "Test Email from Tazmanian Devils",
//                 "This is a test email to verify the email configuration is working correctly."
//             );
            
//             response.put("status", "success");
//             response.put("message", "Test email sent successfully!");
//             return ResponseEntity.ok(response);
//         } catch (Exception e) {
//             response.put("status", "error");
//             response.put("message", "Failed to send email: " + e.getMessage());
//             e.printStackTrace();
//             return ResponseEntity.internalServerError().body(response);
//         }
//     }
    
//     @GetMapping("/send-html-email")
//     public ResponseEntity<Map<String, String>> testHtmlEmail(@RequestParam String to) {
//         Map<String, String> response = new HashMap<>();
        
//         try {
//             // Send an HTML test email
//             emailService.sendHtmlEmail(
//                 to,
//                 "HTML Test Email from Tazmanian Devils",
//                 "<html><body><h1>Test Email</h1><p>This is a <strong>formatted</strong> test email to verify HTML email configuration.</p></body></html>"
//             );
            
//             response.put("status", "success");
//             response.put("message", "HTML test email sent successfully!");
//             return ResponseEntity.ok(response);
//         } catch (MessagingException e) {
//             response.put("status", "error");
//             response.put("message", "Failed to send HTML email: " + e.getMessage());
//             e.printStackTrace();
//             return ResponseEntity.internalServerError().body(response);
//         }
//     }
// }