package com.scwl.controller;

import com.scwl.pojo.User;
import com.scwl.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class UserController {


    @Resource
    UserService userService;

    /**
     * 获取用户一览
     * @param request
     * @param pageNum
     * @param pageSize
     * @param user
     * @return
     */
    @RequestMapping("/getUserList")
    @ResponseBody
    public Object getUserList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize,User user){
        return userService.getUserList(pageNum,pageSize,user);
    }

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



    /**
     *根据员工手机生成账户
     * @return
     */
    @RequestMapping("/generatUser")
    @ResponseBody
    public Object generatUser(HttpServletRequest request, Integer[] eids){
        return userService.generatUser(eids);
    }

}