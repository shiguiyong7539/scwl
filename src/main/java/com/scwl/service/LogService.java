package com.scwl.service;

import com.scwl.pojo.ResBean;
import com.scwl.pojo.SysLog;

public interface LogService {

    ResBean addLog(String type,String tableName,Integer rowId,String conent);
    ResBean generateLog(String type,String tableName,Integer rowId,String conent);
    ResBean getLog(int pageNum,int pageSize);
}
