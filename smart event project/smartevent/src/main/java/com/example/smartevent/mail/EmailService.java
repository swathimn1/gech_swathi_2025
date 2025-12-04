//package com.example.smartevent.mail;
//
//import jakarta.mail.MessagingException;
//import jakarta.mail.internet.MimeMessage;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Service;
//import org.springframework.scheduling.annotation.Async;
//
//@Service
//@RequiredArgsConstructor
//public class EmailService {
//
//  private final JavaMailSender mailSender;
////  
//
//  public EmailService(JavaMailSender mailSender, String defaultFrom) {
//	super();
//	this.mailSender = mailSender;
//	this.defaultFrom = defaultFrom;
//}
//
//@Value("${spring.mail.from}")
//  private String defaultFrom;
//
//  @Async
//  public void sendHtml(String to, String subject, String htmlBody) {
//    try {
//      MimeMessage mimeMessage = mailSender.createMimeMessage();
//      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");
//      helper.setFrom(defaultFrom);
//      helper.setTo(to);
//      helper.setSubject(subject);
//      helper.setText(htmlBody, true);
//      mailSender.send(mimeMessage);
//    } catch (MessagingException e) {
//      // Log and swallow to avoid blocking business flow
//      System.err.println("Email send failed: " + e.getMessage());
//    }
//  }
//}