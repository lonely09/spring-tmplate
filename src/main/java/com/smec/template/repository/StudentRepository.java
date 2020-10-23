package com.smec.template.repository;

import com.smec.template.pojo.Student;
import javafx.beans.binding.LongExpression;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Loney
 */
public interface StudentRepository extends JpaRepository<Student, LongExpression> {

    Optional<Student> findById(Long id);
}
