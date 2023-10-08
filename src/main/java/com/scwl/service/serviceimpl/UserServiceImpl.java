package com.scwl.service.serviceimpl;

import com.scwl.mapper.RoleMapper;

import com.scwl.mapper.UserMapper;
import com.scwl.pojo.*;
import com.scwl.service.LogService;
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

import java.util.Date;
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
    private LogService logService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public ResBean login(User user) {
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
            user.setUsername(user.getPhone());
            user.setEnable(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userMapper.insert(user);
            logService.addLog("INSERT","user",user.getId(),"新增id为"+user.getId()+"的用户信息");
            return ResBean.success("新增成功");
        }catch (Exception e){
            return ResBean.error("新增失败!");
        }

    }

    @Override
    public ResBean editUser(User user) {
        User oldUser = userMapper.selectByPrimaryKey(user.getId());
        UserExample example = new UserExample();
        if(null!=user.getPassword()&&"" !=user.getPassword()){
            oldUser.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        if(null!=user.getName()&&""!=user.getName()){
            oldUser.setName(user.getName());
        }
        if(null!=user.getPhone()&&""!=user.getPhone()){
            oldUser.setPhone(user.getPhone());
            oldUser.setUsername(user.getPhone());
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
        int i = userMapper.deleteByPrimaryKey(user.getId());
        if(i==1){
            logService.addLog("DELETE","user",user.getId(),"删除id为"+user.getId()+"的用户");
            return  ResBean.success("删除成功",null);
        }
        return  ResBean.error("删除失败，请联系管理员!",null);
    }

}
