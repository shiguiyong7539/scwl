package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.MenuMapper;
import com.scwl.mapper.MenuRoleMapper;
import com.scwl.mapper.RoleMapper;
import com.scwl.mapper.UserRoleMapper;
import com.scwl.pojo.*;
import com.scwl.service.LogService;
import com.scwl.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private MenuRoleMapper menuRoleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private LogService logService;
    @Override
    public List<Menu> getMenusWithRole() {
        return menuMapper.getMenusWithRole();
    }

    @Override
    public ResBean getAllRole(int pageNum, int pageSize, Role role) {
        String msg="查询成功！";
        PageHelper.startPage(pageNum,pageSize);
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        if(null!=role.getName()&&""!=role.getName()){
           criteria.andNameLike("%"+role.getName()+"%");
       }
        if(null!=role.getNamezh()&&""!=role.getNamezh()){
            criteria.andNamezhLike("%"+role.getNamezh()+"%");
        }
        List<Role> roles = roleMapper.selectByExample(roleExample);
        PageInfo<Role> pageInfo = new PageInfo<>(roles);
        return ResBean.success(msg,pageInfo);
    }

    @Override
    public ResBean addRole(Role role) {
        roleMapper.insert(role);
        logService.addLog("INSERT","role",role.getId(),"新增id为"+role.getId()+"的角色信息");

        return ResBean.success("添加成功");
    }

    @Override
    public ResBean addMenu(Menu menu) {
        MenuExample menuExample = new MenuExample();
        menuExample.createCriteria().andUrlEqualTo(menu.getUrl());
        List<Menu> menus = menuMapper.selectByExample(menuExample);
        if(menus.size()==0){
            menu.setEnabled(true);
            menuMapper.insert(menu);
            MenuRole menuRole = new MenuRole();
            menuRole.setMid(menu.getId());
            menuRole.setRid(1);
            menuRoleMapper.insert(menuRole);
            logService.addLog("INSERT","menu",menu.getId(),"新增id为"+menu.getId()+"的角色信息");
            logService.addLog("INSERT","menu_role",menuRole.getId(),"绑定id为"+menuRole.getId()+"的角色权限信息");
            return ResBean.success("添加成功");
        }else {
            return ResBean.success("此菜单的URL已经存在");
        }

    }

    @Override
    public ResBean getAllMenu(int pageNum, int pageSize, Menu menu) {
        String msg="查询成功！";
        PageHelper.startPage(pageNum,pageSize);
        String menuName="";
        String roleName="";
        if(null!=menu.getName()&&""!=menu.getName()){
            menuName =  "%"+menu.getName()+"%";
        }
        if(null!=menu.getUrl()&&""!=menu.getUrl()){
            roleName =  "%"+menu.getUrl()+"%";
        }
        List<Menu> menus =  menuMapper.getAllMenuAndRole(menuName,roleName);
        PageInfo<Menu> pageInfo = new PageInfo<>(menus);
        return ResBean.success(msg,pageInfo);
    }

    @Override
    public ResBean addMenuRole(Integer[] mids, Integer[] rids) {
        for (Integer mid : mids) {
            for (Integer rid : rids) {
                MenuRoleExample example = new MenuRoleExample();
                example.createCriteria().andMidEqualTo(mid).andRidEqualTo(rid);
                List<MenuRole> menuRoles = menuRoleMapper.selectByExample(example);
                if(menuRoles.size()==0) {
                    MenuRole menuRole = new MenuRole();
                    menuRole.setMid(mid);
                    menuRole.setRid(rid);
                    menuRoleMapper.insert(menuRole);
                    logService.addLog("INSERT","menu_role",menuRole.getId(),"绑定id为"+menuRole.getId()+"的角色权限信息");

                }
            }
        }
        return ResBean.success("授权成功");
    }

    @Override
    public ResBean addUserRole(Integer[] uids, Integer[] rids) {
        for (Integer uid : uids) {
            for (Integer rid : rids) {
                UserRoleExample example = new UserRoleExample();
                example.createCriteria().andUserIdEqualTo(uid);
                List<UserRole> userRoles = userRoleMapper.selectByExample(example);
                if(userRoles.size()==0){
                    UserRole userRole = new UserRole();
                    userRole.setUserId(uid);
                    userRole.setRid(rid);
                    userRoleMapper.insert(userRole);
                    logService.addLog("INSERT","user_role",userRole.getId(),"绑定用户id为"+userRole.getUserId()+"的角色信息");
                }else {
                    UserRole userRole = userRoles.get(0);
                    userRole.setRid(rid);
                    userRoleMapper.updateByPrimaryKey(userRole);
                    logService.addLog("UPDATE","user_role",userRole.getId(),"更新用户id为"+userRole.getUserId()+"的角色信息");


                }
            }
        }
        return ResBean.success("授权成功");
    }

    @Override
    public ResBean deleteMenuRole(Integer[] mids, Integer[] rids) {
        for (Integer mid : mids) {
            for (Integer rid : rids) {
                MenuRoleExample example = new MenuRoleExample();
                example.createCriteria().andMidEqualTo(mid).andRidEqualTo(rid);
                List<MenuRole> menuRoles = menuRoleMapper.selectByExample(example);
                if(menuRoles.size()>0) {
                    for (MenuRole menuRole : menuRoles) {
                        menuRoleMapper.deleteByPrimaryKey(menuRole.getId());
                        logService.addLog("DELETE","menu_role",menuRole.getId(),"更新角色id为"+rid+"的菜单id为"+mid+"的权限信息");

                    }
                }
            }
        }
        return ResBean.success("授权删除成功");
    }


}
