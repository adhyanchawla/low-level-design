package main.java.com.DesignPatterns.BuilderDesignPattern.Student;
import java.util.List;
public abstract class StudentBuilder {
    int rollNumber;
    String name;
    String fathersName;
    String mothersName;
    int age;
    List<String>subjects;

    public StudentBuilder setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
        return this;
    }

    public StudentBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public abstract StudentBuilder setSubjects();

    public StudentBuilder setFathersName(String fathersName) {
        this.fathersName = fathersName;
        return this;
    }

    public StudentBuilder setMothersName(String mothersName) {
        this.mothersName = mothersName;
        return this;
    }

    public Student build() {
        return new Student(this);
    }

}