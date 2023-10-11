package com.scwl.service;


import com.scwl.pojo.ResBean;
import com.scwl.pojo.RiskControl;

public interface RiskControlService {

    ResBean getAllRisk(int pageNum, int pageSize);
    ResBean addRisk(RiskControl riskControl);
    ResBean getRiskByCenter();
}
