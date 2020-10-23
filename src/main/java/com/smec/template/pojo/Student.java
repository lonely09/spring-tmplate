package com.smec.template.pojo;

import com.smec.template.controller.v1.vo.StudentVo;
import com.smec.template.util.StatusUtil;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 学生表
 * @author 刘鸿亮
 */
@Entity
@Table(name = "STUDENT")
@Where(clause = StatusUtil.NOT_DELETE)
public class Student extends BaseEntity{



    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_S")
    @SequenceGenerator(sequenceName = "STUDENT_S", name = "STUDENT_S", allocationSize = 1)
    private Long id;

    /**
     * 姓名
     */
    @Column(name = "NAME", columnDefinition = "varchar(40)")
    private String name;

    /**
     * 性别
     */
    @Column(name = "SEX_TYPE", columnDefinition = "varchar(40) default '男'")
    @Enumerated(EnumType.STRING)
    private SexType sex;

    /**
     * 是否已删除
     */
    @Column(name = "IS_DELETED", columnDefinition = "NUMBER(1)")
    private boolean deleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SexType getSex() {
        return sex;
    }

    public void setSex(SexType sex) {
        this.sex = sex;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * 性别类型
     */
    public enum SexType {

        /*
         * male: 男
         * Female: 女
         */
        male, Female
    }

    public Student(String name, SexType sex, boolean deleted) {
        this.name = name;
        this.sex = sex;
        this.deleted = deleted;
    }
    public Student() {

    }

    public static Student toStudent(StudentVo studentVo){
        Student student=new Student();
        student.setName(studentVo.getName());
        student.setSex(studentVo.getSex());
        return student;
    }
}
