package com.scwl.service;

import com.scwl.pojo.RentBill;
import com.scwl.pojo.ResBean;
import com.scwl.vo.RentBillVo;

import java.util.List;
import java.util.Map;

public interface RentBillService {

    ResBean getBillList(Integer pageNum, Integer pageSize, RentBillVo rentBillVo);
    ResBean addBill(RentBill rentBill);
    ResBean editBill(RentBill rentBill);
    ResBean deleteBill(String ids);
    ResBean generateBill();
    ResBean auToMonthBill();
    List<Map<String,Object>> exportExcel();
}
