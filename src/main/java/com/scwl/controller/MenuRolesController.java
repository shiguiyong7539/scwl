package com.scwl.controller;

import com.scwl.pojo.ResBean;
import com.scwl.pojo.Role;
import com.scwl.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MenuRolesController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/getAllRole")
    public ResBean getAllRole(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Role role){
        return menuService.getAllRole(pageNum,pageSize,role);
    }
    @RequestMapping("/addRole")
    public ResBean addRole(HttpServletRequest request, Role role){
        return menuService.addRole(role);
    }
}
