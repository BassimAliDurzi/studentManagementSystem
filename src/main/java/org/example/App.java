package org.example;

import config.ConfigFileName;
import data_access.StudentDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigFileName.class);
        StudentDao studentDao = context.getBean(StudentDao.class);
    }
}
