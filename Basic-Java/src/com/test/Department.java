package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author erfan
 * @since 12/23/23
 */
public class Department {
    private Map<Student, Integer> studentMap;

    public Department() {
        this.studentMap = new HashMap<>();
    }

    public Map<Student, Integer> getStudentMap() {
        return studentMap;
    }

    public void setStudentMap(Map<Student, Integer> studentMap) {
        this.studentMap = studentMap;
    }

    public void add(Student student, int grade) {
        Student existingStudent = existingStudent(student);
        if (Objects.nonNull(existingStudent)) {
            getStudentMap().remove(existingStudent);
        }

        getStudentMap().put(student, grade);
    }

    public void print() {
        studentMap.forEach((student, grade) -> {
            System.out.println(student.getName() + " : " + grade);
        });
    }

    public Student existingStudent(Student student) {
        for (Student s: getStudentMap().keySet()) {
            if (s.getLastName().equals(student.getLastName())) {
                return s;
            }
        }

        return null;
    }
}
