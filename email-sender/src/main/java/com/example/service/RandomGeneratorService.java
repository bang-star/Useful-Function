package com.example.service;

import com.example.domain.Certification;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class RandomGeneratorService {

    public String generateRandom() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 6;
        Random random = new Random();
        String value = random.ints(leftLimit, rightLimit + 1)
                .filter((x) -> (x <= 57 || x >= 65) && (x <= 90 || x >= 97))
                .limit((long)targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();

        Certification certification = Certification.of(value);
        return certification.getValue();
    }
}