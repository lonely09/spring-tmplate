package com.smec.template.controller.v1.vo;

/**
 *  bpm流程VO
 * @author 刘鸿亮
 */
public class BpmTaskVo {
    /**
     *  工号
     */
    private String userCode;

    /**
     * page
     */
    private String startIndex;

    /**
     * pageSize
     */
    private String length;

    /**
     * 排序字段
     */
    private String orderby;

    /**
     * ace、desc
     */
    private sequenceType sequence;

    /**
     *  sequence类型
     */
    public enum sequenceType{
        /**
         *  desc类型和ace的2种类型
         */
        ACE,DESC
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public sequenceType getSequence() {
        return sequence;
    }

    public void setSequence(sequenceType sequence) {
        this.sequence = sequence;
    }
    public BpmTaskVo(){

    }
    public BpmTaskVo(String userCode, String startIndex, String length, String orderby, sequenceType sequence) {
        this.userCode = userCode;
        this.startIndex = startIndex;
        this.length = length;
        this.orderby = orderby;
        this.sequence = sequence;
    }
}
