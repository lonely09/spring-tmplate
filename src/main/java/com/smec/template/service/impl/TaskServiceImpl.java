package com.smec.template.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smec.template.controller.v1.vo.BpmTaskVo;
import com.smec.template.pojo.AgentTask;
import com.smec.template.service.TaskService;
import com.smec.template.util.RestTemplateUtil;
import org.springframework.stereotype.Service;

/**
 * @author 刘鸿亮
 */
@Service
public class TaskServiceImpl implements TaskService {
    final RestTemplateUtil restTemplateUtil;

    public TaskServiceImpl(RestTemplateUtil restTemplateUtil) {
        this.restTemplateUtil = restTemplateUtil;
    }


    /**
     * 查询我的代办任务
     *
     * @param employeeId
     * @return
     */
    @Override
    public AgentTask queryMyAgentTask(String employeeId) {
        BpmTaskVo bpmTaskVo = new BpmTaskVo(employeeId, "1", "-1", "taskAssignTime", BpmTaskVo.sequenceType.DESC);
        new ObjectMapper().writeValueAsString(bpmTaskVo)
        return null;
    }
}
