package com.pearl.service;


import com.pearl.model.Student;
import com.pearl.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {


    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {

        return studentRepository.save(student);
    }

    public Optional<Student> findStudentById(Long id) {
        return studentRepository.findById(id);
    }


    public Iterable<Student> findByNames(String firstName, String lastName) {

        return studentRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public Iterable<Student> findAll() {

        return studentRepository.findAll();
    }

    public Iterable<Student> findByFirstName(String firstName) {
        return studentRepository.findByFirstName(firstName);
    }

    public Iterable<Student> findByLastName(String lastName) {
        return studentRepository.findByLastName(lastName);
    }

    public Student deleteStudent(Long id) {

        Optional<Student> student = findStudentById(id);

        if (student.get() != null) {
            studentRepository.delete(student.get());

            return student.get();
        }
        return null;
    }
}
