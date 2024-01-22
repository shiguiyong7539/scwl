package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.scwl.mapper.RentAssetMapper;
import com.scwl.mapper.RentLeaseInfoMapper;
import com.scwl.pojo.*;
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
    private RentLeaseInfoMapper infoMapper;
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
            rentAsset.setUseAcreageNum(rentAsset.getUseAcreage());
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
                if(rentAsset.getStatus()==1){
                    //去查询当前是否租赁中的租约
                    RentLeaseInfoExample example = new RentLeaseInfoExample();
                    RentLeaseInfoExample.Criteria criteria = example.createCriteria();
                     criteria.andStatusEqualTo(1).andAssetIdEqualTo(rentAsset.getId());
                    List<RentLeaseInfo> leaseInfos = infoMapper.selectByExample(example);
                    if(leaseInfos.size()>0){
                        return  ResBean.error("修改失败，当前该资产有租约正在履行，不能更改当前状态");
                    }
                }
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
       //序号	资产名	总面积(㎡)	总可用面积(㎡)	实时可用面积(㎡)	资产地址	状态	添加时间
        Double zero = 0.00;
        for (int i = 0; i < data.size(); i++) {
            RentAsset rentAsset = new RentAsset();
            String[] strings = data.get(i);
            rentAsset.setAssetName(strings[1]);
            rentAsset.setAcreage(strings[2]==""?zero:Double.parseDouble(strings[2]));
            rentAsset.setUseAcreage(strings[3]==""?zero:Double.parseDouble(strings[3]));
            rentAsset.setUseAcreageNum(strings[4]==""?zero:Double.parseDouble(strings[4]));
            rentAsset.setAddress(strings[5]);
            if(strings[6].contains("自用")){
                rentAsset.setStatus(4);
            }else if(strings[6].contains("部分")){
                rentAsset.setStatus(2);
            }else if(strings[6].contains("全部")){
                rentAsset.setStatus(3);
            }else {
                rentAsset.setStatus(1);
            }
            rentAsset.setIsDelete(0);
            rentAsset.setAddTime(new Date());
            assetMapper.insert(rentAsset);

        }
        return  ResBean.success("上传成功");
    }
}
