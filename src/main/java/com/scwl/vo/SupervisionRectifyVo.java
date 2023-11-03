package com.scwl.vo;

import com.scwl.pojo.RectifyMatter;
import com.scwl.pojo.SupervisionRectify;

import java.util.List;

public class SupervisionRectifyVo extends SupervisionRectify {

    public List<RectifyProjectVo> getRectifyProjectVos() {
        return rectifyProjectVos;
    }

    public void setRectifyProjectVos(List<RectifyProjectVo> rectifyProjectVos) {
        this.rectifyProjectVos = rectifyProjectVos;
    }

    private List<RectifyProjectVo> rectifyProjectVos;

}
