package com.scwl.pojo;

import java.util.Date;

public class Employee {
    /**
     */
    private Integer id;

    /**
     * 员工名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 学历
     */
    private String education;

    /**
     * 入职时间
     */
    private Date joinTime;

    /**
     * 职称
     */
    private String rank;

    /**
     * 用工方式
     */
    private String employmentMode;

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank == null ? null : rank.trim();
    }

    public String getEmploymentMode() {
        return employmentMode;
    }

    public void setEmploymentMode(String employmentMode) {
        this.employmentMode = employmentMode == null ? null : employmentMode.trim();
    }
}