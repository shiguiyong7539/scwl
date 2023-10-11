package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.ContractMapper;
import com.scwl.pojo.Capital;
import com.scwl.pojo.Contract;
import com.scwl.pojo.ContractExample;
import com.scwl.pojo.ResBean;
import com.scwl.service.ContractService;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
            contract.setAddTime(new Date());
            contractMapper.insert(contract);
            logService.addLog("INSERT","contract",contract.getId(),"新增id为"+contract.getId()+"的合同信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }

    @Override
    public ResBean updateContract(Contract contract) {
        try{
            contract.setAddTime(new Date());
            contractMapper.update(contract);
            logService.addLog("UPDATE","contract",contract.getId(),"更新id为"+contract.getId()+"的合同状态信息");
            return  ResBean.success("更新成功");
        }catch (Exception e){
            return  ResBean.error("更新失败");
        }

    }
    @Override
    public ResBean getContractByCenter() {
        //合同总数
        List<Contract> list = contractMapper.getTotal();
        for (Contract contract : list) {
            //履行踪的总数
            int continueTotal = contractMapper.getContinueTotal(contract.getDepartment());
            contract.setUnfinishNum(continueTotal);
            //履行完毕总数
            int overTotal = contractMapper.getOverTotal(contract.getDepartment());
            contract.setFinishNum(overTotal);
        }

        return  ResBean.success("success",list);
    }
}
