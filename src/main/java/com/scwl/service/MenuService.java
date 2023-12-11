package com.scwl.service;

import com.scwl.pojo.Menu;
import com.scwl.pojo.ResBean;
import com.scwl.pojo.Role;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MenuService {

    List<Menu> getMenusWithRole();
    ResBean getAllRole(int pageNum, int pageSize, Role role);
    ResBean addRole(Role role);
    ResBean addMenu(Menu menu);
    ResBean getAllMenu(int pageNum,int pageSize,Menu menu);
    ResBean addMenuRole(Integer[] mids,Integer[] rids);
    ResBean addUserRole(Integer[] uids,Integer[] rids);
}
