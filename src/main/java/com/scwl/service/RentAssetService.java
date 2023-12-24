package com.scwl.service;


import com.scwl.pojo.RentAsset;
import com.scwl.pojo.ResBean;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.List;

public interface RentAssetService {
    ResBean getAssetList(Integer pageNum, Integer pageSize, RentAsset rentAsset);
    List<RentAsset> getAll();
    ResBean addAsset(RentAsset rentAsset);
    ResBean editAsset(RentAsset rentAsset);
    ResBean deleteAsset(String ids);
    ResBean uploadAssetFile( List<String[]> data) throws ParseException;

}
