package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.scwl.mapper.RentBillMapper;
import com.scwl.mapper.RentLesseeMapper;
import com.scwl.pojo.RentBill;
import com.scwl.pojo.RentLessee;
import com.scwl.pojo.RentLesseeExample;
import com.scwl.pojo.ResBean;
import com.scwl.service.LogService;
import com.scwl.service.RentLesseeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class RentLesseeServiceImpl implements RentLesseeService {
    @Autowired
    private LogService logService;
    @Autowired
    private RentLesseeMapper rentLesseeMapper;

    @Autowired
    private RentBillMapper rentBillMapper;


    @Override
    public ResBean getLesseeList(Integer pageNum, Integer pageSize, RentLessee rentLessee) {
        PageHelper.startPage(pageNum,pageSize);
        RentLesseeExample example = new RentLesseeExample();
        RentLesseeExample.Criteria criteria = example.createCriteria();
        if(null!=rentLessee.getAddress()&&""!=rentLessee.getAddress()){
            criteria.andAddressLike("%"+rentLessee.getAddress()+"%");
        }
        if(null!=rentLessee.getLesseeName()&&""!=rentLessee.getLesseeName()){
            criteria.andLesseeNameLike("%"+rentLessee.getLesseeName()+"%");
        }
        if(null!=rentLessee.getPhone()&&""!=rentLessee.getPhone()){
            criteria.andPhoneLike("%"+rentLessee.getPhone()+"%");
        }
        if(null!=rentLessee.getIdentityCard()&&""!=rentLessee.getIdentityCard()){
            criteria.andIdentityCardLike("%"+rentLessee.getIdentityCard()+"%");
        }
        if(null!=rentLessee.getSex()&&""!=rentLessee.getSex()){
            criteria.andSexEqualTo(rentLessee.getSex());
        }
        criteria.andIsDeleteEqualTo(0);
        List<RentLessee> list = rentLesseeMapper.selectByExample(example);
        PageInfo<RentLessee> pageInfo = new PageInfo<>(list);
        return  ResBean.success("查询成功",pageInfo);
    }

    @Override
    public ResBean addLessee(RentLessee rentLessee) {
        try {
            if(null==rentLessee.getAccount()){
                rentLessee.setAccount(new BigDecimal(0));
            }
            rentLessee.setIsDelete(0);
            rentLessee.setAddTime(new Date());
            rentLesseeMapper.insert(rentLessee);
            logService.addLog("INSERT","rent_asset",rentLessee.getId(),"新增id为"+rentLessee.getId()+"的租户信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return ResBean.error(e.getMessage());
        }
    }

    @Override
    public ResBean editLessee(RentLessee rentLessee) {
        try {
            String content="修改id为"+rentLessee.getId()+"的租户信息";
            RentLessee oldLessee = rentLesseeMapper.selectByPrimaryKey(rentLessee.getId());
            if(null!=rentLessee.getAddress()&&""!=rentLessee.getAddress()){
                oldLessee.setAddress(rentLessee.getAddress());
            }
            if(null!=rentLessee.getLesseeName()&&""!=rentLessee.getLesseeName()){
                oldLessee.setLesseeName(rentLessee.getLesseeName());
            }
            if(null!=rentLessee.getPhone()&&""!=rentLessee.getPhone()){
                oldLessee.setPhone(rentLessee.getPhone());
            }
            if(null!=rentLessee.getIdentityCard()&&""!=rentLessee.getIdentityCard()){
                oldLessee.setIdentityCard(rentLessee.getIdentityCard());
            }
            if(null!=rentLessee.getSex()&&""!=rentLessee.getSex()){
                oldLessee.setSex(rentLessee.getSex());
            }
            if(null!=rentLessee.getAccount()){
                BigDecimal zero = new BigDecimal(0);
                //预存租户账户余额
                    //判断是否欠租
                    if(oldLessee.getAccount().compareTo(zero)<0&&rentLessee.getAccount().compareTo(zero)>0){
                        //扣除欠租
                        RentDeduction(rentLessee);
                    }
                BigDecimal account = rentLessee.getAccount();
                oldLessee.setAccount(oldLessee.getAccount().add(account));
                content="给租户->"+oldLessee.getLesseeName()+"预存"+account+"元；预存前："+oldLessee.getAccount()+"元；预存后："+oldLessee.getAccount()+"元；";

            }
            rentLesseeMapper.updateByPrimaryKey(oldLessee);
            logService.addLog("UPDATE","rent_asset",rentLessee.getId(),content);
            return  ResBean.success("修改成功");
        }catch (Exception e){
            return ResBean.error(e.getMessage());
        }
    }

    @Override
    public ResBean deleteLessee(String ids) {
        Gson gson = new Gson();
        Integer[] idList = gson.fromJson(ids, Integer[].class);
        for (Integer id : idList) {
            RentLessee rentLessee = rentLesseeMapper.selectByPrimaryKey(id);
            rentLessee.setIsDelete(1);
            rentLesseeMapper.updateByPrimaryKey(rentLessee);
            logService.addLog("DELETE", "rent_asset", id, "删除id为" + id + "的租户信息");
        }
        return  ResBean.success("删除成功");
    }

    @Override
    @Transactional
    public ResBean prestore(RentLessee rentLessee) {
        try{
        RentLessee oldLesse = rentLesseeMapper.selectByPrimaryKey(rentLessee.getId());
        BigDecimal account = oldLesse.getAccount();
        oldLesse.setAccount(account.add(rentLessee.getAccount()));
        rentLesseeMapper.updateByPrimaryKey(oldLesse);
        String content="给用户->"+oldLesse.getLesseeName()+"预存"+rentLessee.getAccount()+"元；"+"预存前是:"+account+"元;"+"预存后是:"+oldLesse.getAccount()+"元";
        logService.addLog("UPDATE", "rent_asset", rentLessee.getId(), content);
        return  ResBean.success("预存成功");
        }catch (Exception e){
            return  ResBean.error("预存失败");
        }
    }

    @Override
    public ResBean uploadLesseeFile(List<String[]> data) throws ParseException {
        for (int i = 1; i < data.size(); i++) {
            String[] strings = data.get(i);
            RentLessee rentLessee = new RentLessee();
            rentLessee.setLesseeName(strings[0]);
           // rentLessee.setSex(strings[1]);
            rentLessee.setPhone(strings[1]);
          //  rentLessee.setAddress(strings[3]);
          //  rentLessee.setIdentityCard(strings[4]);
          //  rentLessee.setAddress(strings[5]);
            rentLessee.setAccount(new BigDecimal(0));
            rentLessee.setAddTime(new Date());
            rentLesseeMapper.insert(rentLessee);
        }
        return  ResBean.success("上传成功");
    }

    //预存金额时扣租
    public void RentDeduction(RentLessee lessee){
        BigDecimal zero = new BigDecimal(0);
        List<RentBill> list = rentBillMapper.isExist(lessee.getId());
        BigDecimal account = lessee.getAccount();
        for (RentBill bill : list) {
            BigDecimal amountOwed = bill.getAmountOwed();
            BigDecimal owed = account.subtract(amountOwed);
            if(owed.compareTo(zero)>0){
                //够扣欠费
                bill.setAmount(bill.getAmount().add(bill.getAmountOwed()));
                bill.setAmountOwed(zero);
                bill.setStatus(1);
                bill.setRentDay(new Date());
                rentBillMapper.updateByPrimaryKey(bill);
                account = owed;
            }else {
                //不够扣或者刚好扣
                BigDecimal subtract = amountOwed.subtract(account);
                bill.setAmount(bill.getAmount().add(account));
                bill.setAmountOwed(subtract);
                if(subtract.compareTo(zero)==0){
                    bill.setStatus(1);
                }
                bill.setRentDay(new Date());
                rentBillMapper.updateByPrimaryKey(bill);
                break;
            }
        }
    }
}
