package com.scwl.service;

import com.scwl.pojo.Capital;
import com.scwl.pojo.ResBean;

public interface CapitalService {

  ResBean getCapital(int pageNum, int pageSize, Capital capital);

  ResBean addCapital(Capital capital);

  ResBean getCapitalByCenter(String period,String condition);

  ResBean getCapitalByCenterShow(Integer yearNum);
  ResBean updateCapital(Capital capital);
  ResBean deleteCapital(String ids);

 }
