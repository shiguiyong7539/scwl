package com.scwl.controller;

import com.scwl.pojo.Menu;
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


    @RequestMapping("/getAllMenu")
    public ResBean getAllMenu(HttpServletRequest request,@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, Menu menu){
        return menuService.getAllMenu(pageNum,pageSize,menu);
    }
    @RequestMapping("/addMenu")
    public ResBean addMenu(HttpServletRequest request, Menu menu){
        return menuService.addMenu(menu);
    }
    @RequestMapping("/addMenuRole")
    public ResBean addMenuRole(HttpServletRequest request, Integer[] mids,Integer[] rids){
        return menuService.addMenuRole(mids,rids);
    }

    @RequestMapping("/addUserRole")
    public ResBean addUserRole(HttpServletRequest request, Integer[] uids,Integer[] rids){
        return menuService.addUserRole(uids,rids);
    }

    @RequestMapping("/deleteMenuRole")
    public ResBean deleteMenuRole(HttpServletRequest request, Integer[] mids,Integer[] rids){
        return menuService.deleteMenuRole(mids,rids);
    }
}
