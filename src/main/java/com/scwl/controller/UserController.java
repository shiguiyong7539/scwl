package com.scwl.controller;

import com.scwl.pojo.User;
import com.scwl.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class UserController {


    @Resource
    UserService userService;

    /**
     * 编辑用户信息
     * @return
     */
    @RequestMapping("/editUser")
    @ResponseBody
    public Object editUser(HttpServletRequest request, User user){
        return userService.editUser(user);
    }
    /**
     * 编辑用户信息
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public Object addUser(HttpServletRequest request, User user){
        return userService.addUser(user);
    }

}