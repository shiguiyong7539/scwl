package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.MenuMapper;
import com.scwl.mapper.RoleMapper;
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


}
