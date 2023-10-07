package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.CapitalPositionMapper;
import com.scwl.pojo.*;
import com.scwl.service.CapitalService;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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

    @Override
    public ResBean getCapitalByCenter(String period, String condition) {
        if(period.equals("年")){
            List<CapitalPosition> capitalPositions = capitalPositionMapper.getCapitalByYear(condition);
            return ResBean.success("success",capitalPositions);
        }else {
            period ="%Y-%m";
            List<CapitalPosition> capitalPositions =   capitalPositionMapper.getCapitalByMonth(period,condition.substring(0,7));
            return ResBean.success("success",capitalPositions);
        }
    }

    @Override
    public ResBean getCapitalByCenterShow() {
        //收入状况
        List<CapitalPosition> income = capitalPositionMapper.getIncome();
        //支出状况
        List<CapitalPosition> expend = capitalPositionMapper.getExpend();
        HashMap<String, Object> map = new HashMap<>();
        map.put("income",income);
        map.put("expend",expend);
        return ResBean.success("success",map);
    }
}
