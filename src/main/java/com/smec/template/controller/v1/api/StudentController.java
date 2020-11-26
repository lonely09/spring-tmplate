package com.smec.template.controller.v1.api;

import com.smec.template.controller.PageVo;
import com.smec.template.controller.v1.vo.StudentVo;
import com.smec.template.pojo.Student;
import com.smec.template.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

/**
 * @author 刘鸿亮
 */
@RestController
@RequestMapping("/v1")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public PageVo<StudentVo> getPageList(@RequestParam(value = "page",required = false,defaultValue = "0") int page,
                              @RequestParam(value = "size",required = false,defaultValue = "20") int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Student> pageData = studentService.findAll(pageable);
        PageVo<StudentVo>pageVo=new PageVo<>();
        pageVo.setData(
                pageData.getContent()
                        .stream()
                        .map(StudentVo::formStudentVo)
                        .collect(Collectors.toList())
        );
        pageVo.setPage(page);
        pageVo.setSize(size);
        pageVo.setTotal(pageData.getTotalElements());
        return pageVo;
    }

    @GetMapping("/students/sort")
    public PageVo<StudentVo> listSort(@PageableDefault(page = 0, size = 20, sort = {"created"}, direction = Sort.Direction.DESC)Pageable pageable){
        Page<Student> pageData = studentService.findAll(pageable);
        PageVo<StudentVo> studentVoPageVo=new PageVo<>();
        studentVoPageVo.setData(
                pageData.getContent()
                        .stream()
                        .map(StudentVo::formStudentVo)
                        .collect(Collectors.toList())
        );
        studentVoPageVo.setPage(pageData.getNumber());
        studentVoPageVo.setSize(pageData.getSize());
        studentVoPageVo.setTotal(pageData.getTotalElements());
        return studentVoPageVo;
    }

    @PostMapping("/students")
    public void addStudents(@RequestBody StudentVo studentVo){
        Student student=Student.toStudent(studentVo);
        studentService.addStudents(student);
    }

    @DeleteMapping("/students/{student_id}")
    public void removeStudent(@PathVariable("student_id") Long student_id){
        studentService.removeStudent(student_id);
    }

}
