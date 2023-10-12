package org.example.service;

import org.example.data_access.StudentDao;
import org.example.models.Student;
import org.example.util.ScannerInputService;
import org.example.util.UserInputService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    private StudentDao studentDao;
    private UserInputService userInputService;
    @Autowired
    public StudentManagementConsoleImpl(StudentDao studentDao, UserInputService userInputService) {
        this.studentDao = studentDao;
        this.userInputService = userInputService;
    }

    @Override
    public Student create() {
        String name = userInputService.getString();
        Student student = new Student();
        student.setName(name);
        return student;
    }

    @Override
    public Student save(Student student) {
        if (student.name() == null) throw new IllegalArgumentException("Student name is null");
        Student createdStudent = studentDao.save(student);
        return createdStudent;
    }

    @Override
    public Student find(int studentId) {
        studentId = userInputService.getInt();
        Student foundedStudent = studentDao.find(studentId);
        return foundedStudent;
    }

    @Override
    public Student remove(int id) {
        id = userInputService.getInt();
        Student student = studentDao.find(id);
        studentDao.delete(id);
        System.out.print("The deleted student is: ");
        return student;
    }

    @Override
    public List<Student> findAll() {
      List<Student> students =  studentDao.findAll();
        return students;
    }

    @Override
    public Student edit(Student student) {
        int id = userInputService.getInt();
        student = studentDao.find(id);

        String name = userInputService.getString();
        student.setName(name);
        System.out.print("Updated student's name: ");
        return student;
    }
}
