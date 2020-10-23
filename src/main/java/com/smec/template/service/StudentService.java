package com.smec.template.service;

import com.smec.template.pojo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Loney
 */
public interface StudentService {
    /**
     *  查询所有
     * @return students
     */
    Page<Student> findAll(Pageable pageable);

    /**
     * 添加学生
     * @param student 学生对象
     */
    void addStudents(Student student);

    void removeStudent(Long id);
}
