package dev.streams;

import dev.streams.challenge.Course;
import dev.streams.challenge.Student;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Course pymc = new Course("PYMC","Python Masterclass");
        Course jmc = new Course("JMC","Java Masterclass");

//        Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
//                .limit(10)
//                .forEach(System.out::println);

        //Count number of female students
//        var femaleStudents =  Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
//                .limit(10);

        Student[] students = new Student[100];
        Arrays.setAll(students, s -> Student.getRandomStudent(pymc, jmc));

        var femaleStudents = Arrays.stream(students).filter(s -> s.getGender().equals("F"));


        System.out.println("Number of female students: " + femaleStudents.count());

    }
}
