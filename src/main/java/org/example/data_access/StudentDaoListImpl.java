package org.example.data_access;

import org.example.models.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDaoListImpl implements StudentDao {
    private List<Student> studentList = new ArrayList();

    @Override
    public Student save(Student student) {
        if (student.name() == null) throw new IllegalArgumentException("Student name is null");
        studentList.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        Optional<Student> foundedStudent = studentList.stream()
                .filter(student -> student.id() == id)
                .findFirst();
        return foundedStudent.orElse(null);
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentList);
    }

    @Override
    public void delete(int id) {
        if (find(id) != null) {
            studentList.remove(find(id));
        } else {
            System.out.println("There is no student with this Id.");
        }
    }
}
