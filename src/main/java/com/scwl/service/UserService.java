package com.scwl.service;

import com.scwl.pojo.Menu;
import com.scwl.pojo.ResBean;
import com.scwl.pojo.Role;
import com.scwl.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {

  ResBean login(User user);

  User getAdminByUserName(String userName);

   List<Role> getRoles(int userId);
}
