package com.scwl.controller;

import com.scwl.pojo.RentAsset;
import com.scwl.pojo.RentLessee;
import com.scwl.pojo.RentLessee;
import com.scwl.pojo.ResBean;
import com.scwl.service.RentLesseeService;
import com.scwl.utils.ExportUtil;
import com.scwl.utils.UploadUtils;
import com.scwl.vo.RentLesseeTempVo;
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
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/rentLessee")
@RestController
public class RentLesseeController {

    @Autowired
    private RentLesseeService rentLesseeService;

    /**
     * 获取所有月度租金缴纳信息
     */
    @RequestMapping("/getLesseeList")
    @ResponseBody
    public Object getLesseeList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, RentLessee rentLessee){
        return rentLesseeService.getLesseeList(pageNum,pageSize,rentLessee);
    }

    /**
     * 添加月度租金缴纳信息
     */
    @RequestMapping("/addLessee")
    @ResponseBody
    public Object addLessee(HttpServletRequest request,RentLessee rentLessee){
        return rentLesseeService.addLessee(rentLessee);
    }
    /**
     * 修改月度租金缴纳信息
     */
    @RequestMapping("/editLessee")
    @ResponseBody
    public Object editLessee(HttpServletRequest request, RentLessee rentLessee){
        return rentLesseeService.editLessee(rentLessee);
    }
    /**
     * 删除月度租金缴纳信息
     */
    @RequestMapping("/deleteLessee")
    @ResponseBody
    public Object deleteLessee(HttpServletRequest request, String ids){
        return rentLesseeService.deleteLessee(ids);
    }


    @RequestMapping("/prestore")
    @ResponseBody
    public Object prestore(HttpServletRequest request, RentLessee rentLessee){
        return rentLesseeService.prestore(rentLessee);
    }
    /**
     * 导入资产信息
     */
    @RequestMapping("/uploadLesseeFile")
    @ResponseBody
    public Object uploadLesseeFile(HttpServletRequest request, @RequestParam(value = "lesseFile", required = false) MultipartFile file){

        try {
            List<String[]> data = UploadUtils.getData(file);
            return  rentLesseeService.uploadLesseeFile(data);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResBean.error("导入失败");
        }

    }

    /**
     * 导出资产的权限校验
     */
    @RequestMapping("/exportLesse")
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
        List<RentLessee> list = rentLesseeService.getAllLessee();
        list.forEach(rentLesse -> {
            if(rentLesse.getStatus()==1){
                rentLesse.setRemark("正常");
            }else if(rentLesse.getStatus()==2){
                rentLesse.setRemark("欠费");
            }

        });
        ExportUtil.export(response,"租户列表","租户列表",list,RentLessee.class);
    }

    /**
     * 导出资产模版信息
     */
    @RequestMapping("/exportExcelTemp")
    @ResponseBody
    public void exportExcelTemp(HttpServletResponse response){
        List<RentLesseeTempVo> list = new ArrayList<>();
        ExportUtil.export(response,"租户列表","租户列表",list,RentLesseeTempVo.class);
    }
}
