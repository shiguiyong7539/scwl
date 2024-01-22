package com.scwl.common;
import com.scwl.pojo.ResBean;
import com.scwl.service.RentBillService;
import com.scwl.service.RentLeaseInfoService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import javax.annotation.Resource;


/**
 * @author stone
 * @date 2023/12/22 23:50
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling  //2.开启定时任务
public class TimedTask {

    @Resource
    private RentBillService rentBillService;
    @Resource
    private RentLeaseInfoService infoService;

    //10分钟
    //@Scheduled(fixedDelay=300000)
    //每天的0点10分执行一次（月日时分秒）
    @Scheduled(cron = "0 10 0 * * ?")
    @Async("executorOne")
    public void autoGennerateBill() {
        //修改昨天到期的合约状态
        ResBean res = infoService.autoExpire();
        System.out.printf(res.getMessage());
        //生成昨天到期的月租金缴费单
        ResBean resBean = rentBillService.generateBill();
        System.out.println(resBean.getMessage());
    }


    //每天的0点15分执行一次（月日时分秒）
    @Scheduled(cron = "0 15 0 * * ?") // 每天中午12点执行一次
    @Async("executorTwo")
    public void auToMonthBill() {
        //更新当前资金管理里面租金收入的的月账单
        ResBean resBean = rentBillService.auToMonthBill();
        System.out.println(resBean.getMessage());
    }



}













































