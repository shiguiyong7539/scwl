package com.scwl.service.serviceimpl;

import com.scwl.mapper.MenuMapper;
import com.scwl.mapper.RoleMapper;
import com.scwl.mapper.UserMapper;
import com.scwl.pojo.*;
import com.scwl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;


    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public ResBean login(User user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
        if(userDetails.getPassword().equals(user.getPassword())){
            //更新security登录用户对象
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
                    ,null,userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            return new ResBean(200,"",userDetails);
        }
        return new ResBean(400,"用户名或密码错误",null);
    }

    @Override
    public User getAdminByUserName(String userName) {
        return userMapper.getAdminByUserName(userName);
    }

    @Override
    public List<Role> getRoles(int userId) {
        return roleMapper.getRoles( userId);
    }
}
