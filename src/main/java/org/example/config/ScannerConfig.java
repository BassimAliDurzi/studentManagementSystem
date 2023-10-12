package org.example.config;

import org.springframework.context.annotation.Bean;

import java.util.Scanner;

public class ScannerConfig {
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
