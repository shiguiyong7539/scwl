package com.scwl.mapper;

import com.scwl.pojo.User;
import com.scwl.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User getAdminByUserName(String userName);
    User selectByEncodePhone(String encodePhone);

    int insertBatchUser(@Param("list")List<User> userList);

    List<User> getAllUserAndRole(User user);

}