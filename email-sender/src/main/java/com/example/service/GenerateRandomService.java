package com.example.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateRandomService {

    public String generateRandom() {
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 6;
        Random random = new Random();
        return ((StringBuilder)random.ints(leftLimit, rightLimit + 1).filter((x) -> {
            return (x <= 57 || x >= 65) && (x <= 90 || x >= 97);
        }).limit((long)targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)).toString();
    }
}