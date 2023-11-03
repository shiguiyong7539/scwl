package com.scwl.vo;

import com.scwl.pojo.RectifyMatter;
import com.scwl.pojo.RectifyProject;

import java.util.List;

public class RectifyProjectVo extends RectifyProject {

    private List<RectifyMatter> matters;

    public List<RectifyMatter> getMatters() {
        return matters;
    }

    public void setMatters(List<RectifyMatter> matters) {
        this.matters = matters;
    }
}
