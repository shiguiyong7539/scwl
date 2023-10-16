package com.scwl.pojo;

import java.util.Date;

public class Task {
    /**
     */
    private Integer id;

    /**
     */
    private String project;

    /**
     */
    private Integer totalNum;

    /**
     * 已完成
     */
    private Integer completed;

    /**
     * 未完成
     */
    private Integer unfinished;

    /**
     * 逾期
     */
    private Integer overdue;

    /**
     */
    private Date term;

    /**
     */
    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getUnfinished() {
        return unfinished;
    }

    public void setUnfinished(Integer unfinished) {
        this.unfinished = unfinished;
    }

    public Integer getOverdue() {
        return overdue;
    }

    public void setOverdue(Integer overdue) {
        this.overdue = overdue;
    }

    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}