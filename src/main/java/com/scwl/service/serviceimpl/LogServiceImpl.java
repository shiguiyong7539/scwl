package com.scwl.service.serviceimpl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.scwl.mapper.SysLogMapper;
import com.scwl.mapper.UserMapper;
import com.scwl.pojo.*;
import com.scwl.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private SysLogMapper logMapper;
    @Autowired
    private UserMapper userMapper;


    @Override
    public ResBean addLog(String type,String tableName,Integer rowId,String conent) {
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            SysLog sysLog = new SysLog();
            sysLog.setOperationType(type);
            sysLog.setTableName(tableName);
            sysLog.setRowId(rowId);
            sysLog.setConent(conent);
            sysLog.setOperationTime(new Date());
            if (authentication != null) {
                User userDetails = userMapper.getAdminByUserName(((UserDetails) authentication.getPrincipal()).getUsername());
                sysLog.setUserId(userDetails.getId());
                sysLog.setConent(userDetails.getName()+":"+conent);
            }
            logMapper.insert(sysLog);
            return  ResBean.success("添加成功");
        }catch (Exception e){
            return  ResBean.error("添加失败");
        }
    }

    @Override
    public ResBean getLog(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        SysLogExample logExample = new SysLogExample();
        logExample.setOrderByClause("operation_time desc");
        List<SysLog> logs = logMapper.selectByExample(logExample);
        PageInfo<SysLog> pageInfo = new PageInfo<>(logs);
        return  ResBean.success("",pageInfo);
    }
}
