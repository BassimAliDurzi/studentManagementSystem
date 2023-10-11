package models;

import java.util.Random;
import java.util.UUID;

public class Student {
    private static int nextId = 1;
    private int id;
    private String name;

    public Student(String name) {
        this.id = nextId++;
        this.name = name;
    }


    public int id() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id: " + id +
                ", name: '" + name + '\'' +
                '}';
    }
}
