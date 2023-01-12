package com.example.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
public class Certification {
    private final String value;
    private final LocalDateTime createdAt;
    private final LocalDateTime endedAt;

    private Certification(String value, LocalDateTime createdAt, LocalDateTime endedAt) {
        this.value = value;
        this.createdAt = createdAt;
        this.endedAt = endedAt;
    }

    public static Certification of(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        now.format(formatter);
        LocalDateTime end = now.plusMinutes(3L);
        return new Certification(value, now, end);
    }
}
