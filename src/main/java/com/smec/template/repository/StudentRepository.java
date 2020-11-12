package com.smec.template.repository;

import com.smec.template.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Loney
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findById(Long id);
}
