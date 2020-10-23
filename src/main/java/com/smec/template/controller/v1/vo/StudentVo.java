package com.smec.template.controller.v1.vo;

import com.smec.template.pojo.Student;

/**
 * @author Loney
 */
public class StudentVo {
    private String name;
    private Student.SexType sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student.SexType getSex() {
        return sex;
    }

    public void setSex(Student.SexType sex) {
        this.sex = sex;
    }

    public StudentVo(String name, Student.SexType sex) {
        this.name = name;
        this.sex = sex;
    }
    public StudentVo(){

    }

    public static StudentVo formStudentVo(Student student){
        return new StudentVo(student.getName(),student.getSex());
    }
}
