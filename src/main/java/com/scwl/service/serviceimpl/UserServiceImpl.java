package com.scwl.service.serviceimpl;

import com.scwl.mapper.RoleMapper;
import com.scwl.mapper.UserMapper;
import com.scwl.pojo.*;
import com.scwl.service.UserService;
import com.scwl.utils.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public ResBean login(User user) {
        System.out.println(user.getUsername());
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());

        if (null==userDetails||!passwordEncoder.matches(user.getPassword(),userDetails.getPassword())){
            return ResBean.error("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()){
            return ResBean.error("账号被禁用，请联系管理员！");
        }
        //更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails
                ,null,userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        //生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead",tokenHead);
        return ResBean.success("登录成功",tokenMap);


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
         userMapper.insertBatchUser(userList);
        return new ResBean(200,"添加成功",null);
    }

    @Override
    public ResBean editUser(User user) {
        int i = userMapper.updateByPrimaryKey(user);
        if(i==1){
            return new ResBean(200,"修改成功",null);
        }
         return new ResBean(400,"修改失败，请联系管理员!",null);
    }

    @Override
    public ResBean deleteUser(User user) {
        int i = userMapper.deleteByPrimaryKey(user.getId());
        if(i==1){
            return new ResBean(200,"删除成功",null);
        }
        return new ResBean(400,"删除失败，请联系管理员!",null);
    }
}
