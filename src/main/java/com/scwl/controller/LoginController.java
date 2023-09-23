package com.scwl.controller;

import com.scwl.pojo.ResBean;
import com.scwl.pojo.User;
import com.scwl.mapper.UserMapper;
import com.scwl.service.UserService;
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
    @RequestMapping("/index")
    public String indexHtml(){
        return "index1";
    }
    /**
     * 已登录
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(HttpServletRequest request,User user){
        return userService.login(user);
    }

}