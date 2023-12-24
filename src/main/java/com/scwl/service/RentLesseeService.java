package com.scwl.service;

import com.scwl.pojo.RentLessee;
import com.scwl.pojo.ResBean;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

public interface RentLesseeService {

    ResBean getLesseeList(Integer pageNum, Integer pageSize, RentLessee rentLessee);
    ResBean addLessee(RentLessee rentLessee);
    ResBean editLessee(RentLessee rentLessee);
    ResBean deleteLessee(String ids);
    ResBean prestore( RentLessee rentLessee);
    ResBean uploadLesseeFile( List<String[]> data) throws ParseException;
}
