package com.scwl.service;

import com.scwl.pojo.Budget;
import com.scwl.pojo.ResBean;

public interface BudGetService {

    ResBean getAllBudget(int pageNum,int pageSize, Budget budget);
    ResBean addBudget(Budget budget);
    ResBean getBudgetByCenter(String condition);
}
