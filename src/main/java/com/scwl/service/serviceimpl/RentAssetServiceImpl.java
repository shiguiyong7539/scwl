package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.scwl.mapper.RentAssetMapper;
import com.scwl.pojo.RentAsset;
import com.scwl.pojo.RentAssetExample;
import com.scwl.pojo.ResBean;
import com.scwl.service.LogService;
import com.scwl.service.RentAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class RentAssetServiceImpl implements RentAssetService {

    @Autowired
    private RentAssetMapper assetMapper;
    @Autowired
    private LogService logService;

    @Override
    public ResBean getAssetList(Integer pageNum, Integer pageSize, RentAsset rentAsset) {
        PageHelper.startPage(pageNum,pageSize);
        RentAssetExample example = new RentAssetExample();
        RentAssetExample.Criteria criteria = example.createCriteria();
        if(null!=rentAsset.getAssetName()&&""!=rentAsset.getAssetName()){
            criteria.andAssetNameLike("%"+rentAsset.getAssetName()+"%");
        }
        if(null!=rentAsset.getAddress()&&""!=rentAsset.getAddress()){
            criteria.andAddressLike("%"+rentAsset.getAddress()+"%");
        }
        if(null!=rentAsset.getAcreage()){
            criteria.andAcreageBetween(rentAsset.getAcreage(),Double.parseDouble("100000"));
        }
        if(null!=rentAsset.getStatus()){
            criteria.andStatusEqualTo(rentAsset.getStatus());
        }
        criteria.andIsDeleteEqualTo(0);
        List<RentAsset> list = assetMapper.selectByExample(example);

        PageInfo<RentAsset> pageInfo = new PageInfo<>(list);
        return  ResBean.success("查询成功",pageInfo);
    }

    @Override
    public   List<RentAsset>  getAll() {
        return assetMapper.selectByExample(new RentAssetExample());
    }

    @Override
    public ResBean addAsset(RentAsset rentAsset) {
        try {
            rentAsset.setAddTime(new Date());
            rentAsset.setIsDelete(0);
            assetMapper.insert(rentAsset);
            logService.addLog("INSERT","rent_asset",rentAsset.getId(),"新增id为"+rentAsset.getId()+"的资产信息");
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return ResBean.error(e.getMessage());
        }

    }

    @Override
    public ResBean editAsset(RentAsset rentAsset) {
        try {
            RentAsset oldAsset = assetMapper.selectByPrimaryKey(rentAsset.getId());
            if(null!=rentAsset.getAssetName()&&""!=rentAsset.getAssetName()){
                oldAsset.setAssetName(rentAsset.getAssetName());
            }
            if(null!=rentAsset.getAddress()&&""!=rentAsset.getAddress()){
                oldAsset.setAddress(rentAsset.getAddress());
            }
            if(null!=rentAsset.getAcreage()){
                oldAsset.setAcreage(rentAsset.getAcreage());
            }
            if(null!=rentAsset.getStatus()){
                oldAsset.setStatus(rentAsset.getStatus());
            }
            if(null!=rentAsset.getRemark()&&""!=rentAsset.getRemark()){
                oldAsset.setRemark(rentAsset.getRemark());
            }
            assetMapper.updateByPrimaryKey(oldAsset);
            logService.addLog("UPDATE","rent_asset",rentAsset.getId(),"修改id为"+rentAsset.getId()+"的资产信息为:"+oldAsset.toString());
            return  ResBean.success("修改成功");
        }catch (Exception e){
            return ResBean.error(e.getMessage());
        }

    }

    @Override
    public ResBean deleteAsset(String ids) {
        try {
            Gson gson = new Gson();
            Integer[] idList = gson.fromJson(ids, Integer[].class);
            for (Integer id : idList) {
                RentAsset rentAsset = assetMapper.selectByPrimaryKey(id);
                rentAsset.setIsDelete(1);
                assetMapper.updateByPrimaryKey(rentAsset);
                logService.addLog("DELETE", "rent_asset", id, "删除:" + id + "的资产信息");
            }
            return  ResBean.success("删除成功");
        }catch (Exception e){
            return ResBean.error(e.getMessage());
        }
    }

    @Override
    public ResBean uploadAssetFile(List<String[]> data) throws ParseException {

        for (int i = 1; i < data.size(); i++) {
            RentAsset rentAsset = new RentAsset();
            String[] strings = data.get(i);
            if(null!=strings[1]&&""!=strings[1]){
            rentAsset.setAssetName(strings[0]);
            rentAsset.setAcreage(Double.parseDouble(strings[1]));
            rentAsset.setAddress(strings[2]);
            if(strings[3].equals("空置")){
                rentAsset.setStatus(1);
            }else {
                rentAsset.setStatus(2);
            }
            rentAsset.setAddTime(new Date());
            assetMapper.insert(rentAsset);}
        }
        return  ResBean.success("上传成功");
    }
}
