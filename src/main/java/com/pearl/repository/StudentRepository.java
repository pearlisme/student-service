package com.pearl.repository;

import com.pearl.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    Iterable<Student> findByFirstNameAndLastName(String firstName, String lastName);

    Iterable<Student> findByFirstName(String firstName);

    Iterable<Student> findByLastName(String lastName);
}
