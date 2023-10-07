package com.scwl.service;

import com.scwl.pojo.ManageState;
import com.scwl.pojo.ResBean;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public interface ManageStateService {

 ResBean getAllManageState(int pageNum, int pageSize, ManageState manageState);
 ResBean addState(ManageState manageState);
 ResBean getManageStateByCenter();
}
