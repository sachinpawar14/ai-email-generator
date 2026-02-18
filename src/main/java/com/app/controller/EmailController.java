package com.app.controller;

import com.app.dto.EmailRequest;
import com.app.service.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/email")
@CrossOrigin("*")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/generate")
    public Map<String, Object> generateEmail(@RequestBody EmailRequest request) {

        long start = System.currentTimeMillis();

        String emailText = emailService.generateEmail(
                request.getPurpose(),
                request.getRecipient_name(),
                request.getTone()
        );

        long end = System.currentTimeMillis();

        Map<String, Object> response = new HashMap<>();
        response.put("email", emailText);
        response.put("responseTimeMs", (end - start));

        return response;
    }
}
