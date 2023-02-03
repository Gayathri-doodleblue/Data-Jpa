package com.example.entityrelationship.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entityrelationship.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

}
