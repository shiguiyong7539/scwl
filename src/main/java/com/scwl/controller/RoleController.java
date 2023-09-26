package com.scwl.controller;

import com.scwl.pojo.Role;
import com.scwl.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class RoleController {


    @Resource
    UserService userService;

    /**
     * 已登录
     * @return
     */
    @RequestMapping("/addRole")
    @ResponseBody
    public Object addRole(HttpServletRequest request, Role role){
        return null;
    }

}