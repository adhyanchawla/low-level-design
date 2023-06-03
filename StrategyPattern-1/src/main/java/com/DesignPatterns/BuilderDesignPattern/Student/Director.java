package main.java.com.DesignPatterns.BuilderDesignPattern.Student;

public class Director {
    public StudentBuilder studentBuilder;

    public Director(StudentBuilder studentBuilder) {
        this.studentBuilder = studentBuilder;
    }

    public Student createStudent() {
        if(studentBuilder instanceof MBAStudentBuilder) {
            return createMBAStudent();
        } else if(studentBuilder instanceof  EngineeringStudentBuilder) {
            return createEngineeringStudent();
        }
        return null;
    }

    public Student createMBAStudent() {
        return studentBuilder.setName("Anshul").setAge(22).setFathersName("Rajan Kumar").setMothersName("Sonia").setRollNumber(123).setSubjects().build();
    }

    public Student createEngineeringStudent() {
        return studentBuilder.setName("Aryan").setAge(22).setRollNumber(221).setSubjects().build();
    }


}