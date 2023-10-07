package com.scwl.service;

import com.scwl.pojo.CostManage;
import com.scwl.pojo.ResBean;

import javax.servlet.http.HttpServletRequest;

public interface CostManageService {

    ResBean getAllCost(Integer pageNum, Integer pageSize, CostManage costManage);
    ResBean addCost(CostManage costManage);
    ResBean getCostManageByCenter(String period, String condition);

}
