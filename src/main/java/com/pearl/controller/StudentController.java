package com.pearl.controller;

import com.pearl.model.Student;
import com.pearl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public Iterable<Student> listStudents() {
        return studentService.findAll();
    }

    @PostMapping(value = "/add")
    public Student addStudent(@RequestBody Student student) {

        if (student == null) return null;

        return studentService.addStudent(student);
    }

    @GetMapping("/find/{id}")
    public Optional<Student> findStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @GetMapping("/search")
    public Iterable<Student> findStudentByFirstAndLastName(@RequestParam(value = "first", required = false) String firstName,
                                                           @RequestParam(value = "last", required = false) String lastName) {

        if (firstName != null & lastName != null) {
            return studentService.findByNames(firstName, lastName);
        } else if (firstName != null) {
            return studentService.findByFirstName(firstName);
        } else if (lastName != null) {
            return studentService.findByLastName(lastName);
        } else
            return studentService.findAll();

    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Student deleteStudent(@PathVariable Long id) {

        return studentService.deleteStudent(id);


    }

}
