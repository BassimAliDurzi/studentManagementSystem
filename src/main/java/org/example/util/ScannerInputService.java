package org.example.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Scanner;

@Component
public class ScannerInputService implements UserInputService {

    private Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.println("Enter student's name:");
        String name = scanner.next();
        return name;
    }

    @Override
    public int getInt() {
        System.out.println("Enter student's ID:");
        int id = scanner.nextInt();
        return id;
    }
}
