package com.smec.template.pojo;

import com.smec.template.util.StatusUtil;
import org.hibernate.annotations.Where;

import javax.persistence.*;

/**
 * 代办任务
 * @author 刘鸿亮
 */
@Entity
@Table(name = "AGENT_TASK")
@Where(clause = StatusUtil.NOT_DELETE)
public class AgentTask extends BaseEntity{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AGENT_TASK_S")
    @SequenceGenerator(sequenceName = "AGENT_TASK_S", name = "AGENT_TASK_S", allocationSize = 1)
    private Long id;

    /**
     * 任务状态 true 已完成 false 未完成
     */
    @Column(name = "TASKS_TATUS",columnDefinition = "NUMBER(1)")
    private Boolean taskStatus;

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

    public Boolean getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public AgentTask() {
    }
}
