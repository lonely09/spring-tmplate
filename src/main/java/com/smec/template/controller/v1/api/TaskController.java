package com.smec.template.controller.v1.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 流程接口
 * @author 刘鸿亮
 */
@RestController
@RequestMapping("/v1")
public class TaskController {

    @GetMapping("/tasks/{employee_id}")
    public void tasks(@PathVariable(value = "employee_id") String employeeId){

    }
}
