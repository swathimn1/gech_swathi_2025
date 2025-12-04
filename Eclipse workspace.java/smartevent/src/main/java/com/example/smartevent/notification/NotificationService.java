//package com.example.smartevent.notification;
//
//import com.example.smartevent.mail.*;
//import com.example.smartevent.mail.EmailTemplateService;
//import com.example.smartevent.models.Stall;
//import com.example.smartevent.models.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//import java.util.Map;
//
//@Service
//@RequiredArgsConstructor
//public class NotificationService {
//
//  private final EmailService emailService;
//  private final EmailTemplateService templateService;
////
//  @Value("${app.admin.email}")
//  private String adminEmail;
//
//  public void notifyAdminStallRegistration(Stall stall) {
//    String html = templateService.render("admin-stall-registered",
//      Map.of("stallName", stall.getName(),
//             "ownerName", stall.getOwner().getName(),
//             "ownerEmail", stall.getOwner().getEmail()));
//    emailService.sendHtml(adminEmail, "New Stall Registration", html);
//  }
//
//  public void notifyOwnerNewQuery(Stall stall, User visitor, String title, String description) {
//    String html = templateService.render("owner-new-query",
//      Map.of("stallName", stall.getName(),
//             "visitorName", visitor.getName(),
//             "visitorEmail", visitor.getEmail(),
//             "title", title,
//             "description", description));
//    emailService.sendHtml(stall.getOwner().getEmail(), "New Query Received", html);
//  }
//
//  public void notifyOwnerNewFeedback(Stall stall, User visitor, int rating, String message) {
//    String html = templateService.render("owner-new-feedback",
//      Map.of("stallName", stall.getName(),
//             "rating", rating,
//             "message", message));
//    emailService.sendHtml(stall.getOwner().getEmail(), "New Feedback Received", html);
//  }
//
//  public void welcomeVisitor(User visitor) {
//    String html = templateService.render("visitor-welcome",
//      Map.of("name", visitor.getName()));
//    emailService.sendHtml(visitor.getEmail(), "Welcome to Smart Event", html);
//  }
//
//  public void notifyVisitorQueryResolved(User visitor, String title, String status, String stallName) {
//    String html = templateService.render("visitor-query-resolved",
//      Map.of("title", title, "status", status, "stallName", stallName));
//    emailService.sendHtml(visitor.getEmail(), "Your Query Was Answered", html);
//  }
//}