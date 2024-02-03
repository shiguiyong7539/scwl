package com.scwl.service;

import com.scwl.pojo.ManageState;
import com.scwl.pojo.RentBill;
import com.scwl.pojo.ResBean;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

public interface ManageStateService {

 ResBean getAllManageState(int pageNum, int pageSize, ManageState manageState);
 ResBean addState(ManageState manageState);
 ResBean updateState(ManageState manageState);
 ResBean deleteState(String ids);
 ResBean getManageStateByCenter(Integer yearNum);
 ResBean getTotalManage(Integer yearNum);
 void deductArrears(RentBill  bill, BigDecimal money);
}
