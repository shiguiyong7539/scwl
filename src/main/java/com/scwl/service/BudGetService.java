package com.scwl.service;

import com.scwl.pojo.Budget;
import com.scwl.pojo.ResBean;

import java.text.ParseException;

public interface BudGetService {

    ResBean getAllBudget(int pageNum,int pageSize, Budget budget) throws ParseException;
    ResBean addBudget(Budget budget);
    ResBean updateBudget(Budget budget);
    ResBean deleteBudget(String ids);
    ResBean getBudgetByCenter(String condition);
}
