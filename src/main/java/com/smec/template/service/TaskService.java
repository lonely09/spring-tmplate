package com.smec.template.service;

import com.smec.template.pojo.AgentTask;

/**
 * @author 刘鸿亮
 */
public interface TaskService {

    /**
     *  查询我的代办任务
     * @param employeeId
     * @return
     */
    AgentTask queryMyAgentTask(String employeeId);

}
