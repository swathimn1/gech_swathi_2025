package com.example.smartevent.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    // Load HTML template from resources/email-templates/
    private String loadTemplate(String fileName) throws IOException {
        ClassPathResource resource = new ClassPathResource("email-templates/" + fileName);
        return new String(Files.readAllBytes(resource.getFile().toPath()));
    }

    public void sendEmail(String to, String subject, String templateFile, String[][] placeholders)
            throws MessagingException, IOException {

        String html = loadTemplate(templateFile);

        // Replace placeholders
        for (String[] pair : placeholders) {
            html = html.replace(pair[0], pair[1]);
        }

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(html, true);

        // 🔥 ADD THIS LINE — REQUIRED BY GMAIL 🔥
        helper.setFrom("Smart Event <swathimn7672@gmail.com>");

        mailSender.send(message);
    }

}
