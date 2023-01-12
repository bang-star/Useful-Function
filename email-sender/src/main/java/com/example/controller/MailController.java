package com.example.controller;

import com.example.dto.CertificationDto;
import com.example.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@Controller
public class MailController {

    private final MailService mailService;

    @PostMapping({"/user/mail"})
    public void sendMail(@RequestBody CertificationDto dto) {
        mailService.sendEmail(dto.getEmail());
    }
}

