package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.MenuMapper;
import com.scwl.mapper.MenuRoleMapper;
import com.scwl.mapper.RoleMapper;
import com.scwl.mapper.UserRoleMapper;
import com.scwl.pojo.*;
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
        return ResBean.success("添加成功");
    }

    @Override
    public ResBean addMenu(Menu menu) {
        menu.setEnabled(true);
        menuMapper.insert(menu);
        MenuRole menuRole = new MenuRole();
        menuRole.setMid(menu.getId());
        menuRole.setRid(1);
        menuRoleMapper.insert(menuRole);
        return ResBean.success("添加成功");
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
                example.createCriteria().andUserIdEqualTo(uid).andRidEqualTo(rid);
                List<UserRole> userRoles = userRoleMapper.selectByExample(example);
                if(userRoles.size()==0){
                    UserRole userRole = new UserRole();
                    userRole.setUserId(uid);
                    userRole.setRid(rid);
                    userRoleMapper.insert(userRole);
                }else {
                    UserRole userRole = userRoles.get(0);
                    userRole.setRid(rid);
                    userRoleMapper.updateByPrimaryKey(userRole);
                }
            }
        }
        return ResBean.success("授权成功");
    }


}
