package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.ContractMapper;
import com.scwl.pojo.Contract;
import com.scwl.pojo.ContractExample;
import com.scwl.pojo.ResBean;
import com.scwl.service.ContractService;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractMapper contractMapper;

    @Autowired
    private LogService logService;

    @Override
    public ResBean getAllContract(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        ContractExample example = new ContractExample();
       example.setOrderByClause("add_time desc");
        List<Contract> contracts = contractMapper.selectByExample(example);
        PageInfo<Contract> pageInfo = new PageInfo<>(contracts);
        return ResBean.success("success",pageInfo);
    }

    @Override
    public ResBean addContract(Contract contract) {
        try{
            contractMapper.insert(contract);
            logService.addLog("INSERT","contract",contract.getId(),"新增id为"+contract.getId()+"的合同信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }

    @Override
    public ResBean getContractByCenter() {
        List<Contract> list = contractMapper.getContractByCenter();
        return  ResBean.success("success",list);
    }
}
