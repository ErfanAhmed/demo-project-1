package com.test;

public class Main {

    public static void main(String[] args) {
        Department department = new Department();
        Student student1 = new Student("Erfan Ahmed", "Ahmed");
        Student student2 = new Student("Farhan Ahmed", "Ahmed");
        Student student3 = new Student("Robin Milford", "Milford");
        Student student4 = new Student("Musa Aman", "Aman");

        department.add(student1, 100);
        department.add(student3, 120);
        department.print();

        department.add(student2, 120);
        department.add(student4, 120);
        department.print();
    }
}
