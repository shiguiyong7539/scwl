package com.scwl.service;

import com.scwl.pojo.CapitalPosition;
import com.scwl.pojo.ResBean;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

public interface CapitalService {

  ResBean getCapital(int pageNum, int pageSize);

  ResBean addCapital( CapitalPosition capital);

 }
