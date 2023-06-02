package org.example.springboot.demo.mycoolapp;


import org.example.springboot.demo.mycoolapp.dao.StudentDAO;
import org.example.springboot.demo.mycoolapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class MycoolappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MycoolappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            System.out.println("hello world");
            //createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);
        };
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        int totDeleted = studentDAO.deleteAll();
        System.out.println(String.format("Deleted %s students", totDeleted));
    }

    private void deleteStudent(StudentDAO studentDAO) {
        studentDAO.delete(4);
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findById(1);
        student.setLastName("Bengtsson");
        studentDAO.update(student);

    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("doe");
        theStudents.forEach(student -> System.out.println(student));
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findAll();

        theStudents.forEach(student -> System.out.println(student));
    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object");
        Student tempStudent = new Student("lisa", "doe", "lisa@acme.com");

        System.out.println("Saving the student");
        studentDAO.save(tempStudent);

        final int theStudentId = tempStudent.getId();
        System.out.println("Saved student. GeneratedID: " + theStudentId);

        Student theSavedStudent = studentDAO.findById(theStudentId);

        System.out.println("The student: " + theSavedStudent);


    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating new student object");
        Student tempStudent1 = new Student("Östen", "Anderson", "simon@acme.com");
        Student tempStudent2 = new Student("Ärling", "Bengtsson", "jane@bmw.de");
        Student tempStudent3 = new Student("Åsa", "Carlsson", "dude@google.com");

        System.out.println("Saving the students");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

    }


    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating new student object");
        Student tempStudent = new Student("andrew", "doe", "andrew@acme.com");

        System.out.println("Saving the student");
        studentDAO.save(tempStudent);

        System.out.println("Saved student. GeneratedID: " + tempStudent.getId());
    }



}
