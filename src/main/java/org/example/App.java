package org.example;

import org.example.config.ComponentScanConfig;
import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.service.StudentManagement;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.example.util.UserInputService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);


        boolean isContinue = true;
        Scanner scanner = new Scanner(System.in);
        Student student = null;

        while (isContinue) {
            student = studentManagement.create();
            studentManagement.save(student);

            System.out.println("Enter '1' to add another student.");
            System.out.println("Or, enter '0' to finish.");

            int userInput = scanner.nextInt();
            if (userInput == 1) {
                isContinue = true;
            } else if (userInput == 0) {
                isContinue = false;
            }else{
                System.out.println("Invalid value");
                System.exit(0);
            }
        }

        studentManagement.findAll().forEach(System.out::println);
        System.out.println("-----------------------------------");

        System.out.println("Find a student by ID...");
        System.out.println(studentManagement.find(student.id()));
        System.out.println("-----------------------------------");

        System.out.println("Delete a student by ID...");
        System.out.println(studentManagement.remove(student.id()));
        System.out.println("-----------------------------------");

        studentManagement.findAll().forEach(System.out::println);
        System.out.println("-----------------------------------");

        System.out.println("Update student's name...");
        System.out.println(studentManagement.edit(student));
        System.out.println("-----------------------------------");


    }
}
