package com.scwl.pojo;

import java.util.Date;

public class SupervisionRectify {
    /**
     */
    private Integer id;

    /**
     * 标题
     */
    private String headLine;

    /**
     * 监督人（可以多个用 , 连接）
     */
    private String rectifyPerson;

    /**
     * 被监督部门
     */
    private String department;

    /**
     * title
     */
    private String titleIds;

    /**
     * 事项
     */
    private String matterIds;

    /**
     * 整改状态（涉诉状态）
     */
    private String status;

    /**
     * 监督范围
     */
    private String supervisionScope;

    /**
     * 监督方法
     */
    private String supervisionWay;

    /**
     * 存在问题
     */
    private String existingProblem;

    /**
     * 工作建议
     */
    private String businessTips;

    /**
     */
    private String rectifyReply;

    /**
     * 开始监督时间
     */
    private Date startTime;

    /**
     * 整改期限
     */
    private Date deadline;

    /**
     */
    private Date addTime;

    /**
     * 备注
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine == null ? null : headLine.trim();
    }

    public String getRectifyPerson() {
        return rectifyPerson;
    }

    public void setRectifyPerson(String rectifyPerson) {
        this.rectifyPerson = rectifyPerson == null ? null : rectifyPerson.trim();
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    public String getTitleIds() {
        return titleIds;
    }

    public void setTitleIds(String titleIds) {
        this.titleIds = titleIds == null ? null : titleIds.trim();
    }

    public String getMatterIds() {
        return matterIds;
    }

    public void setMatterIds(String matterIds) {
        this.matterIds = matterIds == null ? null : matterIds.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSupervisionScope() {
        return supervisionScope;
    }

    public void setSupervisionScope(String supervisionScope) {
        this.supervisionScope = supervisionScope == null ? null : supervisionScope.trim();
    }

    public String getSupervisionWay() {
        return supervisionWay;
    }

    public void setSupervisionWay(String supervisionWay) {
        this.supervisionWay = supervisionWay == null ? null : supervisionWay.trim();
    }

    public String getExistingProblem() {
        return existingProblem;
    }

    public void setExistingProblem(String existingProblem) {
        this.existingProblem = existingProblem == null ? null : existingProblem.trim();
    }

    public String getBusinessTips() {
        return businessTips;
    }

    public void setBusinessTips(String businessTips) {
        this.businessTips = businessTips == null ? null : businessTips.trim();
    }

    public String getRectifyReply() {
        return rectifyReply;
    }

    public void setRectifyReply(String rectifyReply) {
        this.rectifyReply = rectifyReply == null ? null : rectifyReply.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}