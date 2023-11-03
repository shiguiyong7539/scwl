package com.scwl.service;


import com.scwl.pojo.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface RiskControlService {

    ResBean getAllRisk(int pageNum, int pageSize);
    ResBean addRisk(RiskControl riskControl);
    ResBean getAllRectify(int pageNum, int pageSize, SupervisionRectify supervisionRectify);
    ResBean addRectify(SupervisionRectify supervisionRectify);
    ResBean updateRectify(SupervisionRectify supervisionRectify);
    ResBean getRectifyDetail(String id);
    ResBean getProjectList();
    ResBean getProjectListAndMatters();
    ResBean getMatterList(String id);
    ResBean addProject(RectifyProject project);
    ResBean addMatter(RectifyMatter matter);
    ResBean getRiskByCenter();
}
