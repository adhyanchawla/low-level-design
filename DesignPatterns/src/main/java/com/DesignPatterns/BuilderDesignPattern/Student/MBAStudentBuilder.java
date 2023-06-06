package main.java.com.DesignPatterns.BuilderDesignPattern.Student;

import java.util.ArrayList;
import java.util.List;

public class MBAStudentBuilder extends StudentBuilder {
    @Override
    public StudentBuilder setSubjects() {
        List<String> subs = new ArrayList<>();
        subs.add("Business");
        subs.add("Economics");
        this.subjects = subs;
        return this;
    }
}