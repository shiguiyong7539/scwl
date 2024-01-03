package com.scwl.controller;

import com.scwl.pojo.RentAsset;
import com.scwl.pojo.RentBill;
import com.scwl.pojo.ResBean;
import com.scwl.service.RentBillService;
import com.scwl.utils.CustomExport;
import com.scwl.utils.ExportUtil;
import com.scwl.vo.RentBillVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/rentBill")
@RestController
public class RentBillController {

    @Autowired
    private RentBillService rentBillService;
    /**
     * 获取所有租金收入
     */
    @RequestMapping("/getBillList")
    @ResponseBody
    public Object getBillList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, RentBillVo rentBillVo){
        return rentBillService.getBillList(pageNum,pageSize,rentBillVo);
    }

    /**
     * 添加资产
     */
    @RequestMapping("/addBill")
    @ResponseBody
    public Object addBill(HttpServletRequest request,RentBill rentBill){
        return rentBillService.addBill(rentBill);
    }
    /**
     * 修改资产
     */
    @RequestMapping("/editBill")
    @ResponseBody
    public Object editBill(HttpServletRequest request, RentBill rentBill){
        return rentBillService.editBill(rentBill);
    }
    /**
     * 删除资产
     */
    @RequestMapping("/deleteBill")
    @ResponseBody
    public Object deleteBill(HttpServletRequest request, String ids){
        return rentBillService.deleteBill(ids);
    }

    /**
     * 补交欠费
     */
    @RequestMapping("/deductArrears")
    @ResponseBody
    public Object deductArrears(HttpServletRequest request, String ids){
        return rentBillService.deductArrears(ids);
    }

    /**租金明细导出
     * "ID\t姓名\t年龄"
     */
    @RequestMapping("/exportBill")
    @ResponseBody
    public Object exportAsset(){
        return  ResBean.success("正在导出");
    }
    /**
     * 租金明细导出
     * 序号	门牌号	承租人	交租周期	建筑面积（㎡）	联系方式	租期起算日	租期结算日	租赁保证金	到期提醒
     */
    @RequestMapping("/exportExcel")
    @ResponseBody
    public void exportExcel(HttpServletResponse response){
        List<Map<String,Object>> list = rentBillService.exportExcel();
        String title ="序号\t门牌号\t承租人\t交租周期\t面积（㎡）\t联系方式\t租赁日\t交租日\t押金\t状态";
        //获取目前为止的12个月
        LocalDate localDate = LocalDate.now().minusMonths(11);
        title += "\t"+localDate.getYear()+"年"+localDate.getMonthValue()+"月";
        for (int i = 0; i < 11; i++) {
            localDate = localDate.plusMonths(1);
            title += "\t"+localDate.getYear()+"年"+localDate.getMonthValue()+"月";
        }
        title +="\t总租金\t文旅公司应收\t文旅公司收取\t文旅公司未收\t免租金";
        try {
            CustomExport.customExport(response,title,list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
