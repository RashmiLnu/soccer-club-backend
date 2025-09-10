// package com.tazmaniandevils.soccer_club_backend.service;

// import jakarta.mail.MessagingException;
// import jakarta.mail.internet.MimeMessage;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.mail.javamail.MimeMessageHelper;
// import org.springframework.stereotype.Service;

// @Service
// public class EmailService {
    
//     private final JavaMailSender mailSender;
    
//     @Autowired
//     public EmailService(JavaMailSender mailSender) {
//         this.mailSender = mailSender;
//     }
    
//     public void sendSimpleEmail(String to, String subject, String text) {
//         try {
//             SimpleMailMessage message = new SimpleMailMessage();
//             message.setTo(to);
//             message.setSubject(subject);
//             message.setText(text);
//             message.setFrom("noreply@tazmaniandevils.com");
//             mailSender.send(message);
//         } catch (Exception e) {
//             throw new RuntimeException("Failed to send simple email: " + e.getMessage(), e);
//         }
//     }
    
//     public void sendHtmlEmail(String to, String subject, String htmlContent) throws MessagingException {
//         MimeMessage message = mailSender.createMimeMessage();
//         MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
        
//         helper.setTo(to);
//         helper.setSubject(subject);
//         helper.setText(htmlContent, true); // true indicates HTML content
//         helper.setFrom("noreply@tazmaniandevils.com");
        
//         mailSender.send(message);
//     }
// }