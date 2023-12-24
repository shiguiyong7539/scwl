package com.scwl.utils;

import com.scwl.pojo.RentBill;
import com.scwl.vo.RentLeaseInfoVo;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class CustomExport {

    public static <T> void customExport(HttpServletResponse response, String title, List<Map<String,Object>> list) throws IOException {
        // 设置响应内容类型和字符编码
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");

        // 设置响应头，以便浏览器识别文件类型并弹出下载对话框
        response.setHeader("Content-disposition", "attachment;filename="+ URLEncoder.encode("租金明细.xlsx", "utf-8"));

        // 使用PrintWriter将数据写入到响应中
        PrintWriter out = response.getWriter();
        BigDecimal zero = new BigDecimal(0);
        SimpleDateFormat ym = new SimpleDateFormat("yyyy-MM");
        SimpleDateFormat ymd = new SimpleDateFormat("yyyy-MM-dd");
        out.println(title); // 表头
        for (Map map : list) {
            RentLeaseInfoVo info = (RentLeaseInfoVo) map.get("rentLeaseInfoVo");
            //租约信息
            String content = info.getId() + "\t" + info.getAssetName() + "\t" + info.getLesseeName()
                    + "\t" + info.getRentCycle()+ "\t" + info.getAcreage()+ "\t" + info.getPhone()+ "\t" + ymd.format(info.getLeaseDate())
                    + "\t" + ymd.format(info.getPayDate())+ "\t" + info.getCashPledge()+ "\t" + info.getRemark();

            //月账单信息
            List<RentBill> bills = (List<RentBill>) map.get("rentBill");
            //应收总金额
            BigDecimal totalMoney =new BigDecimal(0);
            //实收总金额
            BigDecimal receiveMoney =new BigDecimal(0);
            //欠费总金额
            BigDecimal owedMoney =new BigDecimal(0);
            //免租总额
            BigDecimal freeMoney =new BigDecimal(0);
            for (RentBill bill : bills) {
                if(bill.getAmount().compareTo(zero)>=0){
                    totalMoney =  totalMoney.add(info.getLeaseUnitPrice());
                    receiveMoney = receiveMoney.add(bill.getAmount());
                    owedMoney =  owedMoney.add(bill.getAmountOwed());
                    content +=  "\t" + bill.getAmount();
                    if(null!=bill.getRemark()&&bill.getRemark().equals("当月免租")){
                        freeMoney =  freeMoney.add(info.getLeaseUnitPrice());
                    }
                }else {
                    content +=  "\t" + " ";
                }

            }
            content +=   "\t" + totalMoney+ "\t" + totalMoney+ "\t" + receiveMoney+ "\t" + owedMoney+ "\t" +freeMoney;
            out.println(content);
        }
        out.flush();
        out.close();
    }

}
