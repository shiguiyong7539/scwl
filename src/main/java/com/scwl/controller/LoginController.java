package com.scwl.controller;

import com.scwl.pojo.ResBean;
import com.scwl.pojo.User;
import com.scwl.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
public class LoginController {


    @Resource
    UserService userService;

    /**
     * 登录
     * @return
     */
    @RequestMapping("/")
    public String loginHtml(){
        return "login";
    }


    /**
     * 登录
     * @return
     */
    @RequestMapping("/admin")
    public String indexHtml(){
        return "admin";
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
        return ResBean.success("已登录");
    }



}