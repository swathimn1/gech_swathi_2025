package com.example.smartevent.controller;

import com.example.smartevent.dto.EmailRequest;
import com.example.smartevent.dto.Placeholder;
import com.example.smartevent.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailTemplateController {

    private final EmailService emailService;
    

    public EmailTemplateController(EmailService emailService) {
		super();
		this.emailService = emailService;
	}

	@GetMapping("/templates")
    public List<Map<String, String>> getTemplates() throws IOException {
        List<Map<String, String>> list = new ArrayList<>();

        String[] files = {
                "welcome-visitor.html",
                "new-query.html",
                "query-response.html",
                "points-earned.html",
                "stall-approved.html"
        };

        for (String file : files) {
            Map<String, String> map = new HashMap<>();
            ClassPathResource resource = new ClassPathResource("email-templates/" + file);
            String html = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
            map.put("name", file.replace(".html", ""));
            map.put("html", html);
            list.add(map);
        }

        return list;
    }

    @PostMapping("/send-test")
    public ResponseEntity<?> sendTestEmail(@RequestBody EmailRequest request) {
        try {
            // Convert List<Placeholder> to String[][]
            String[][] placeholderArray = request.getPlaceholders().stream()
                    .map(p -> new String[]{"{{" + p.getKey() + "}}", p.getValue()})
                    .toArray(String[][]::new);

            emailService.sendEmail(
                    request.getTo(),
                    "Smart Event — Test Email",
                    request.getTemplateName() + ".html",
                    placeholderArray
            );

            return ResponseEntity.ok(Map.of("message", "Email sent successfully"));

        } catch (Exception e) {
            return ResponseEntity.status(500).body(Map.of("message", e.getMessage()));
        }
    }
}
