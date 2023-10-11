package org.example;

import config.ComponentScanConfig;
import data_access.StudentDao;
import models.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.UserInputService;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        UserInputService userInputService =context.getBean(UserInputService.class);

        Student bassim = new Student("Bassim Durzi");
        System.out.println(bassim.toString());
        Student ali = new Student("Ali Bashir");
        System.out.println(ali.toString());

        ;
    }
}
