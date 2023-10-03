package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.CapitalPositionMapper;
import com.scwl.pojo.CapitalPosition;
import com.scwl.pojo.CapitalPositionExample;
import com.scwl.pojo.Employee;
import com.scwl.pojo.ResBean;
import com.scwl.service.CapitalService;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CapitalServiceImpl implements CapitalService {

    @Autowired
    private CapitalPositionMapper capitalPositionMapper;

    @Autowired
    private LogService logService;

    @Override
    public ResBean getCapital(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<CapitalPosition> capitalPositions = capitalPositionMapper.selectByExample(new CapitalPositionExample());
        PageInfo<CapitalPosition> pageInfo = new PageInfo<>(capitalPositions);
        return ResBean.success("查询成功",pageInfo);
    }

    @Override
    public ResBean addCapital(CapitalPosition capital)  {
        try{
            capitalPositionMapper.insert(capital);
            logService.addLog("INSERT","capital_position",capital.getId(),"新增id为"+capital.getId()+"的资金状况信息");

            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }

    }
}
