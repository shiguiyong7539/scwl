package com.scwl.controller;

import com.scwl.pojo.ResBean;
import com.scwl.pojo.User;
import com.scwl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Resource
    UserService userService;

    /**
     * 登录
     * @return
     */
    @RequestMapping("/")
    public String loginHtml(){
        System.out.println(passwordEncoder.encode("123456"));
        return "login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/loginAdmin")
    public String loginAdmin(){
        System.out.println(passwordEncoder.encode("123456"));
        return "login_admin";
    }


    /**
     * 主页
     * @return
     */
    @RequestMapping("/admin")
    public String admin(){
        return "admin";
    }
    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public String indexHtml(){
        return "index";
    }

    /**
     * 个人信息页面
     * @return
     */
    @RequestMapping("/userInfo")
    public String userInfo(){
        return "userInfo";
    }


    /**
     * 人事信息页面
     * @return
     */
    @RequestMapping("/memberList")
    public String memberList(){
        return "memberList";
    }

    /**
     * 成本管理页面
     * @return
     */
    @RequestMapping("/costManage")
    public String costManage(){
        return "costmanage";
    }

    /**
     * 经营状况页面
     * @return
     */
    @RequestMapping("/mangeState")
    public String mangeState(){
        return "managestate";
    }

    /**
     * 资金状况页面
     * @return
     */
    @RequestMapping("/capitalList")
    public String capitalPosition(){
        return "capital";
    }

    /**
     * 任务管理页面
     * @return
     */
    @RequestMapping("/taskList")
    public String taskList(){
        return "tasklist";
    }


    /**
     * 合同管理页面
     * @return
     */
    @RequestMapping("/contract")
    public String contract(){
        return "contract";
    }


    /**
     * 风控管理页面
     * @return
     */
    @RequestMapping("/risk")
    public String risk(){
        return "risk";
    }



    /**
     * 平台展示页面
     * @return
     */
    @RequestMapping("/centerShow")
    public String centerShow(){
        return "center_show";
    }
    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(HttpServletRequest request,User user){
        return userService.login(user);
    }

    /**
     * 退出
     * @return
     */
    @RequestMapping("/logout")
    @ResponseBody
    public Object logout(HttpServletRequest request){
        return  ResBean.success("已退出");
    }

    /**
     * 验证是否登录
     * 没登录进行提示
     * @return
     */
    @RequestMapping("/isLogin")
    @ResponseBody
    public Object isLogin(HttpServletRequest request){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
           return  ResBean.success("已登录",(User) authentication.getPrincipal());
        }
        return ResBean.error("未登录");
    }



}