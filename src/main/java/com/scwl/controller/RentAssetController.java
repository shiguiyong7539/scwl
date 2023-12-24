package com.scwl.controller;


import com.scwl.pojo.RentAsset;
import com.scwl.pojo.ResBean;
import com.scwl.service.RentAssetService;
import com.scwl.utils.ExportUtil;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/asset")
@RestController
public class RentAssetController {


    @Autowired
    private RentAssetService rentAssetService;
    /**
     * 获取所有月度租金缴纳信息
     */
    @RequestMapping("/getAssetList")
    @ResponseBody
    public Object getAssetList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, RentAsset rentAsset){
        return rentAssetService.getAssetList(pageNum,pageSize,rentAsset);
    }

    /**
     * 添加月度租金缴纳信息
     */
    @RequestMapping("/addAsset")
    @ResponseBody
    public Object addAsset(HttpServletRequest request,RentAsset rentAsset){
        return rentAssetService.addAsset(rentAsset);
    }
    /**
     * 修改月度租金缴纳信息
     */
    @RequestMapping("/editAsset")
    @ResponseBody
    public Object editAsset(HttpServletRequest request, RentAsset rentAsset){
        return rentAssetService.editAsset(rentAsset);
    }
    /**
     * 删除月度租金缴纳信息
     */
    @RequestMapping("/deleteAsset")
    @ResponseBody
    public Object deleteAsset(HttpServletRequest request, String ids){
        return rentAssetService.deleteAsset(ids);
    }

    /**
     * 导入资产信息
     */
    @RequestMapping("/uploadAssetFile")
    @ResponseBody
    public Object uploadAssetFile(HttpServletRequest request, @RequestParam(value = "assetFile", required = false) MultipartFile file){
        try {
            // 创建Workbook对象并读取上传的文件内容
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0); // 获取第一个工作表
            Iterator<Row> rowIterator = sheet.iterator(); // 迭代行
            List<String[]> data = new ArrayList<>(); // 存储数据的列表

            // 遍历每一行并读取单元格数据
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator(); // 迭代单元格
                List<String> rowData = new ArrayList<>(); // 存储当前行的单元格数据
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING:
                            rowData.add(cell.getStringCellValue());
                            break;
                        case NUMERIC:
                            rowData.add(String.valueOf(cell.getNumericCellValue()));
                            break;
                        case BOOLEAN:
                            rowData.add(String.valueOf(cell.getBooleanCellValue()));
                            break;
                        default:
                            rowData.add(""); // 空值或其他类型数据，可以根据实际情况进行处理
                    }
                }
                data.add(rowData.toArray(new String[0])); // 将当前行的数据添加到列表中
            }
            workbook.close(); // 关闭Workbook对象释放资源
            return  rentAssetService.uploadAssetFile(data);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return ResBean.error("上传失败");  // 处理异常情况，返回错误信息和状态码
        }
    }

    /**
     * 导出资产的权限校验
     */
    @RequestMapping("/exportAsset")
    @ResponseBody
    public Object exportAsset(){
        return  ResBean.success("正在导出");
    }
    /**
     * 导出资产信息
     */
    @RequestMapping("/exportExcel")
    @ResponseBody
    public void exportExcel(HttpServletResponse response){
        List<RentAsset> list = rentAssetService.getAll();
        for (RentAsset rentAsset : list) {
            if(rentAsset.getStatus()==1){
                rentAsset.setRemark("空置中");
            }else {
                rentAsset.setRemark("租赁中");
            }
        }
        ExportUtil.export(response,"资产列表","资产列表",list,RentAsset.class);
    }
}
