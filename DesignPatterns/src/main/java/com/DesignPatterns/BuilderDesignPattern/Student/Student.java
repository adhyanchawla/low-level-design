package main.java.com.DesignPatterns.BuilderDesignPattern.Student;

import main.java.com.DesignPatterns.BuilderDesignPattern.Student.StudentBuilder;

import java.util.List;

public class Student {
    int rollNumber;
    String name;
    String fathersName;
    String mothersName;
    int age;
    List<String> subjects;

    public Student(StudentBuilder studentBuilder) {
        this.rollNumber = studentBuilder.rollNumber;
        this.name = studentBuilder.name;
        this.fathersName = studentBuilder.fathersName;
        this.mothersName = studentBuilder.mothersName;
        this.age = studentBuilder.age;
        this.subjects = studentBuilder.subjects;
    }

    public String toString() {
        return " name " + this.name + " roll number " + this.rollNumber +
                " fathers name " + this.fathersName + " mothers name " + this.mothersName +
                " age " + this.age + " subjects " + this.subjects;
    }
}