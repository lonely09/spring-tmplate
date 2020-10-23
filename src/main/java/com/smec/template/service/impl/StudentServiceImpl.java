package com.smec.template.service.impl;

import com.smec.template.pojo.Student;
import com.smec.template.repository.StudentRepository;
import com.smec.template.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 刘鸿亮
 */
@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    /**
     * 添加学生
     *
     * @param student
     */
    @Override
    public void addStudents(Student student) {
         studentRepository.save(student);
    }

    @Override
    public void removeStudent(Long id) {
        studentRepository.findById(id).ifPresent(sutdent->{
            sutdent.setDeleted(true);
            studentRepository.save(sutdent);
        });
    }
}
