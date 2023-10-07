package com.scwl.service;

import com.scwl.pojo.Contract;
import com.scwl.pojo.ResBean;

import javax.servlet.http.HttpServletRequest;

public interface ContractService {

    ResBean getAllContract(int pageNum,int pageSize);
    ResBean addContract(Contract contract);
    ResBean getContractByCenter();
}
