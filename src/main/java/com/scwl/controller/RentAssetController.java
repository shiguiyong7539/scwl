package com.scwl.controller;


import com.scwl.pojo.RentAsset;
import com.scwl.pojo.ResBean;
import com.scwl.service.RentAssetService;
import com.scwl.utils.ExportUtil;
import com.scwl.utils.UploadUtils;
import com.scwl.vo.RentAssetTempVo;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/asset")
@RestController
public class RentAssetController {


    @Autowired
    private RentAssetService rentAssetService;
    /**
     * 获取所有月度租金缴纳信息
     */
    @RequestMapping("/getAssetList")
    @ResponseBody
    public Object getAssetList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, RentAsset rentAsset){
        return rentAssetService.getAssetList(pageNum,pageSize,rentAsset);
    }

    /**
     * 添加月度租金缴纳信息
     */
    @RequestMapping("/addAsset")
    @ResponseBody
    public Object addAsset(HttpServletRequest request,RentAsset rentAsset){
        return rentAssetService.addAsset(rentAsset);
    }
    /**
     * 修改月度租金缴纳信息
     */
    @RequestMapping("/editAsset")
    @ResponseBody
    public Object editAsset(HttpServletRequest request, RentAsset rentAsset){
        return rentAssetService.editAsset(rentAsset);
    }
    /**
     * 删除月度租金缴纳信息
     */
    @RequestMapping("/deleteAsset")
    @ResponseBody
    public Object deleteAsset(HttpServletRequest request, String ids){
        return rentAssetService.deleteAsset(ids);
    }

    /**
     * 导入资产信息
     */
    @RequestMapping("/uploadAssetFile")
    @ResponseBody
    public Object uploadAssetFile(HttpServletRequest request, @RequestParam(value = "assetFile", required = false) MultipartFile file){
        try {
            List<String[]> data = UploadUtils.getData(file);
            return  rentAssetService.uploadAssetFile(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResBean.error("上传失败");  // 处理异常情况，返回错误信息和状态码
        }
    }

    /**
     * 导出资产的权限校验
     */
    @RequestMapping("/exportAsset")
    @ResponseBody
    public Object exportAsset(){
        return  ResBean.success("正在导出");
    }
    /**
     * 导出资产信息
     */
    @RequestMapping("/exportExcel")
    @ResponseBody
    public void exportExcel(HttpServletResponse response){
        List<RentAsset> list = rentAssetService.getAll();
        list.forEach(rentAsset -> {
            if(rentAsset.getStatus()==1){
                rentAsset.setRemark("空置中");
            }else if(rentAsset.getStatus()==2){
                rentAsset.setRemark("部分租赁");
            }
            else if(rentAsset.getStatus()==2){
                rentAsset.setRemark("全部租赁");
            }else {
                rentAsset.setRemark("自用");
            }

        });
        ExportUtil.export(response,"资产列表","资产列表",list,RentAsset.class);
    }

    /**
     * 导出资产信息
     */
    @RequestMapping("/exportExcelTemp")
    @ResponseBody
    public void exportExcelTemp(HttpServletResponse response){
        List<RentAssetTempVo> list = new ArrayList<>();
        ExportUtil.export(response,"资产列表","资产列表",list,RentAssetTempVo.class);
    }
}
