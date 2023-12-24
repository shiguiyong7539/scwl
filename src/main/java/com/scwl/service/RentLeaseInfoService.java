package com.scwl.service;

import com.scwl.pojo.RentLeaseInfo;
import com.scwl.pojo.ResBean;
import com.scwl.vo.RentLeaseInfoVo;

import java.text.ParseException;
import java.util.List;

public interface RentLeaseInfoService {

    ResBean getLeaseInfoList(Integer pageNum, Integer pageSize, RentLeaseInfoVo rentLeaseInfoVo);
    ResBean addLeaseInfo(RentLeaseInfo rentLeaseInfo);
    ResBean editLeaseInfo(RentLeaseInfo rentLeaseInfo);
    ResBean deleteLeaseInfo(String ids);
    ResBean uploadLeaseInfoFile( List<String[]> data) throws ParseException;
    ResBean autoExpire();
}
