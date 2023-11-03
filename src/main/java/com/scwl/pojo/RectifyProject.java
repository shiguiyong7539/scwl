package com.scwl.pojo;

public class RectifyProject {
    /**
     */
    private Integer id;

    /**
     * 整改项目
     */
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
}