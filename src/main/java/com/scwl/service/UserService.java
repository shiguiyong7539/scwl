package com.scwl.service;

import com.scwl.pojo.Menu;
import com.scwl.pojo.ResBean;
import com.scwl.pojo.Role;
import com.scwl.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService  {

  ResBean getUserList(int pageNum,int pageSize,User user);

  ResBean login(User user);

  User getAdminByUserName(String userName);

   List<Role> getRoles(int userId);

   ResBean insertBatchUser(List<User> userList);

   ResBean addUser(User user);

   ResBean editUser(User user);

   ResBean deleteUser(User user);

   ResBean oaLogin(String phone);
   ResBean generatUser(Integer[] ids);
}
