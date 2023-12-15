package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.EmployeeMapper;
import com.scwl.mapper.RoleMapper;

import com.scwl.mapper.UserMapper;
import com.scwl.mapper.UserRoleMapper;
import com.scwl.pojo.*;
import com.scwl.service.LogService;
import com.scwl.service.UserService;
import com.scwl.utils.JwtTokenUtil;
import com.scwl.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.security.provider.MD5;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private LogService logService;


    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public ResBean getUserList(int pageNum, int pageSize, User user) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users = userMapper.getAllUserAndRole(user);
        PageInfo<User> pageInfo = new PageInfo<>(users);
        return ResBean.success("success",pageInfo);
    }

    @Override
    public ResBean oaLogin(String phone) {
       try{
           User user = userMapper.selectByEncodePhone(phone);
           if(null!=user) {
               UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
               if (!userDetails.isEnabled()){
                   return ResBean.error("账号被禁用，请联系管理员！");
               }
               User user1 = userMapper.getAdminByUserName(user.getUsername());
               user1.setLastLogin(new Date());
               userMapper.updateByPrimaryKey(user1);
               //更新security登录用户对象
               UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
                       ,null,userDetails.getAuthorities());
               SecurityContextHolder.getContext().setAuthentication(authenticationToken);
               // 为用户设置权限
               List<Role> roles =   roleMapper.getRoles(user1.getId());
               List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
               for (Role role : roles) {
                   grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
               }
               //生成token
               String token = jwtTokenUtil.generateToken(userDetails);
               Map<String,String> tokenMap = new HashMap<>();
               tokenMap.put("token",token);
               tokenMap.put("tokenHead",tokenHead);
               logService.addLog("LOGIN","user",user.getId(),"从OA系统登录成功！");
               return ResBean.success("登录成功",tokenMap);
           }else {
               logService.addLog("LOGIN_ERROR","user",0,"从OA系统登录失败！"+phone);
               return ResBean.error("用户不存在！");
           }
       }catch (Exception e){
           return ResBean.error("用户不存在！");
       }



    }

    @Override
    public ResBean generatUser(Integer[] ids) {
        for (Integer id : ids) {
            Employee employee = employeeMapper.selectByPrimaryKey(id);
            User exist = userMapper.getAdminByUserName(employee.getPhone());
            if(null==exist) {
                User user = new User();
                user.setUsername(employee.getPhone());
                user.setPhone(employee.getPhone());
                user.setName(employee.getName());
                user.setEncodePhone(MD5Util.encryptSHA(employee.getPhone()));
                user.setEnable(true);
                user.setPassword(passwordEncoder.encode("Scwl1234"));
                userMapper.insert(user);
                UserRole userRole = new UserRole();
                userRole.setUserId(user.getId());
                userRole.setRid(2);
                userRoleMapper.insert(userRole);
                logService.addLog("INSERT","user",user.getId(),"新增id为"+user.getId()+"的用户信息");

            }
        }
        return ResBean.success("生成成功");
    }

    @Override
    public ResBean login(User user) {
        try{
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

            if (null==userDetails||!passwordEncoder.matches(user.getPassword(),userDetails.getPassword())){
                return ResBean.error("用户名或密码不正确");
            }
            if (!userDetails.isEnabled()){
                return ResBean.error("账号被禁用，请联系管理员！");
            }
            User user1 = userMapper.getAdminByUserName(user.getUsername());
            user1.setLastLogin(new Date());
            userMapper.updateByPrimaryKey(user1);
            //更新security登录用户对象
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
                    ,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            // 为用户设置权限
            List<Role> roles =   roleMapper.getRoles(user1.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (Role role : roles) {
                // grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
                grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
            }
            //生成token
            String token = jwtTokenUtil.generateToken(userDetails);
            Map<String,String> tokenMap = new HashMap<>();
            tokenMap.put("token",token);
            tokenMap.put("tokenHead",tokenHead);
            return ResBean.success("登录成功",tokenMap);
        }catch (Exception e){
            return ResBean.error(e.getMessage());
        }



    }

    @Override
    public User getAdminByUserName(String userName) {
        return userMapper.getAdminByUserName(userName);
    }

    @Override
    public List<Role> getRoles(int userId) {
        return roleMapper.getRoles( userId);
    }

    @Override
    public ResBean insertBatchUser(List<User> userList) {
        try {
            userMapper.insertBatchUser(userList);
            //logService.addLog("DELETE","user",user.getId(),"修改id为"+user.getId()+"的用户信息");
            return  ResBean.success("添加成功",null);
        }catch (Exception e){
            return  ResBean.error("添加失败",null);
        }

    }

    @Override
    public ResBean addUser(User user) {
        try {
            User exist = userMapper.getAdminByUserName(user.getPhone());
            if(null==exist){
                user.setUsername(user.getPhone());
                user.setEncodePhone(MD5Util.encryptSHA(user.getPhone()));
                user.setEnable(true);
                user.setPassword(passwordEncoder.encode(user.getPassword()));
                userMapper.insert(user);
                logService.addLog("INSERT","user",user.getId(),"新增id为"+user.getId()+"的用户信息");
                return ResBean.success("添加成功");
            }else {
                return ResBean.error("添加失败！改手机账号已经存在,它的名称是:"+exist.getName());
            }

        }catch (Exception e){
            return ResBean.error("添加失败!");
        }

    }

    @Override
    public ResBean editUser(User user) {
        User oldUser = userMapper.selectByPrimaryKey(user.getId());
        if(null!=user.getPassword()&&"" !=user.getPassword()){
            oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        if(null!=user.getName()&&""!=user.getName()){
            oldUser.setName(user.getName());
        }
        if(null!=user.getPhone()&&""!=user.getPhone()){
            oldUser.setPhone(user.getPhone());
            oldUser.setUsername(user.getPhone());
            oldUser.setEncodePhone(MD5Util.encryptSHA(user.getPhone()));
        }
        int i = userMapper.updateByPrimaryKey(oldUser);
        if(i==1){
            logService.addLog("UPDATE","user",user.getId(),"修改id为"+user.getId()+"的用户信息");
            return  ResBean.success("修改成功",null);
        }
         return  ResBean.error("修改失败，请联系管理员!",null);
    }

    @Override
    public ResBean deleteUser(User user) {

        User u = userMapper.selectByPrimaryKey(user.getId());
        if(null!=u){
            u.setEnable(false);
            userMapper.updateByPrimaryKey(u);
            logService.addLog("DELETE","user",user.getId(),"删除id为"+user.getId()+"的用户");
            return  ResBean.success("删除成功",null);
        }
        return  ResBean.error("删除失败，请联系管理员!",null);
    }

}
