package com.scwl.pojo;

import java.util.Date;

public class Contract {
    private Integer id;

    private Integer totalNum;

    private Integer finishNum;

    private Integer unfinishNum;

    private Date addTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getFinishNum() {
        return finishNum;
    }

    public void setFinishNum(Integer finishNum) {
        this.finishNum = finishNum;
    }

    public Integer getUnfinishNum() {
        return unfinishNum;
    }

    public void setUnfinishNum(Integer unfinishNum) {
        this.unfinishNum = unfinishNum;
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