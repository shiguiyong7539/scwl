package com.scwl.pojo;

import java.util.Date;

public class RiskControl {
    private Integer id;

    private String name;

    private Integer num;

    private Integer yearNum;

    private Integer unfinishNum;

    private Date addTime;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getYearNum() {
        return yearNum;
    }

    public void setYearNum(Integer yearNum) {
        this.yearNum = yearNum;
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