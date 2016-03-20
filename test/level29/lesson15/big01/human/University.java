package com.javarush.test.level29.lesson15.big01.human;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        Student student = null;
        for (Student student1 :students) {
            if (student1.getAverageGrade() == averageGrade) {
                student = student1;
                break;
            }
        }

        return student;
    }

    public Student getStudentWithMaxAverageGrade() {
        double temp = 0;
        Student result = null;
        for (Student student :students) {
            if (student.getAverageGrade() > temp){
                temp = student.getAverageGrade();
                result = student;
            }
        }

        return result;
    }

    public Student getStudentWithMinAverageGrade() {
        double temp = students.get(0).getAverageGrade();
        Student result = null;
        for (Student student :students) {
            if (student.getAverageGrade() < temp) {
                temp = student.getAverageGrade();
                result = student;
            }
        }
        return result;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}
