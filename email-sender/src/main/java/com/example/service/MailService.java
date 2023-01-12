package com.example.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class MailService {
    private JavaMailSender mailSender;
    private RandomGeneratorService generatorService;

    public void sendEmail(String email) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("sender");
            message.setTo(email);
            message.setSubject(createTitle());
            message.setText(createText());

            mailSender.send(message);

            log.info("sent Mail to {}", email);
        } catch (Exception e) {
            log.warn(e.getLocalizedMessage());
            log.warn("Mail delivery failed to {}", email);
        }

    }

    private String createTitle() {
        return "인증메일";
    }

    private String createText() {
        StringBuilder sb = new StringBuilder();
        sb.append("본 메일은 서비스의 회원가입을 위한 이메일 인증입니다.").append("\n");
        sb.append("인증번호: ").append(generatorService.generateRandom()).append("\n");
        sb.append("감사합니다.").append("\n").append("서비스 담당자");
        return sb.toString();
    }
}
