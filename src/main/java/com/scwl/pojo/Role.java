package com.scwl.pojo;

public class Role {
    /**
     */
    private Integer id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色中文显示名
     */
    private String namezh;

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

    public String getNamezh() {
        return namezh;
    }

    public void setNamezh(String namezh) {
        this.namezh = namezh == null ? null : namezh.trim();
    }
}