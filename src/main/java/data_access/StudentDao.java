package data_access;

import models.Student;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface StudentDao {
    Student save(Student student);
    Student find(int id);
    List<Student> findAll();
    void delete(int id);
}
