package com.tazmaniandevils.soccer_club_backend.service;

import com.tazmaniandevils.soccer_club_backend.model.Coach;
import com.tazmaniandevils.soccer_club_backend.model.ContactSubmission;
import com.tazmaniandevils.soccer_club_backend.model.PlayerReview;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class ExcelExportService {
    
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter DATETIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public ByteArrayInputStream exportContactSubmissionsToExcel(List<ContactSubmission> submissions) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); 
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            
            Sheet sheet = workbook.createSheet("Contact Submissions");
            
            // Create header row
            Row headerRow = sheet.createRow(0);
            CellStyle headerStyle = createHeaderStyle(workbook);
            
            String[] headers = {
                "ID", "Player Name", "Parent Name", "Email", "Interest", 
                "Date of Birth", "Town", "Message", "Submission Time", "Processed"
            };
            
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
                sheet.autoSizeColumn(i);
            }
            
            // Fill data rows
            int rowIndex = 1;
            for (ContactSubmission submission : submissions) {
                Row row = sheet.createRow(rowIndex++);
                
                row.createCell(0).setCellValue(submission.getId());
                row.createCell(1).setCellValue(submission.getPlayerName());
                row.createCell(2).setCellValue(submission.getParentName());
                row.createCell(3).setCellValue(submission.getEmail());
                row.createCell(4).setCellValue(submission.getInterest());
                row.createCell(5).setCellValue(submission.getPlayerDOB().format(DATE_FORMATTER));
                row.createCell(6).setCellValue(submission.getTown());
                row.createCell(7).setCellValue(submission.getMessage() != null ? submission.getMessage() : "");
                row.createCell(8).setCellValue(submission.getSubmissionTime().format(DATETIME_FORMATTER));
                row.createCell(9).setCellValue(submission.isProcessed() ? "Yes" : "No");
            }
            
            // Resize columns to fit content
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }
            
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
    
    public ByteArrayInputStream exportCoachesToExcel(List<Coach> coaches) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); 
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            
            Sheet sheet = workbook.createSheet("Coaches");
            
            // Create header row
            Row headerRow = sheet.createRow(0);
            CellStyle headerStyle = createHeaderStyle(workbook);
            
            String[] headers = {"ID", "Name", "Title", "Bio", "Image URL"};
            
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }
            
            // Fill data rows
            int rowIndex = 1;
            for (Coach coach : coaches) {
                Row row = sheet.createRow(rowIndex++);
                
                row.createCell(0).setCellValue(coach.getId());
                row.createCell(1).setCellValue(coach.getName());
                row.createCell(2).setCellValue(coach.getTitle());
                row.createCell(3).setCellValue(coach.getBio());
                row.createCell(4).setCellValue(coach.getImageUrl() != null ? coach.getImageUrl() : "");
            }
            
            // Resize columns to fit content
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }
            
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
    
    public ByteArrayInputStream exportPlayerReviewsToExcel(List<PlayerReview> reviews) throws IOException {
        try (Workbook workbook = new XSSFWorkbook(); 
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            
            Sheet sheet = workbook.createSheet("Player Reviews");
            
            // Create header row
            Row headerRow = sheet.createRow(0);
            CellStyle headerStyle = createHeaderStyle(workbook);
            
            String[] headers = {"ID", "Player Name", "Location", "Review", "Image URL"};
            
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
                cell.setCellStyle(headerStyle);
            }
            
            // Fill data rows
            int rowIndex = 1;
            for (PlayerReview review : reviews) {
                Row row = sheet.createRow(rowIndex++);
                
                row.createCell(0).setCellValue(review.getId());
                row.createCell(1).setCellValue(review.getPlayerName());
                row.createCell(2).setCellValue(review.getLocation());
                row.createCell(3).setCellValue(review.getReview());
                row.createCell(4).setCellValue(review.getImageUrl() != null ? review.getImageUrl() : "");
            }
            
            // Resize columns to fit content
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }
            
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
    
    private CellStyle createHeaderStyle(Workbook workbook) {
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        
        return headerStyle;
    }
}