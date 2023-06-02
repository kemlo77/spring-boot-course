package org.example.springboot.demo.mycoolapp.dao;

import org.example.springboot.demo.mycoolapp.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student student);

    void delete(Integer id);

    int deleteAll();

}
