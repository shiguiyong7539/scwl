package com.scwl.controller;

import com.scwl.pojo.RentLeaseInfo;
import com.scwl.pojo.ResBean;
import com.scwl.service.RentLeaseInfoService;
import com.scwl.vo.RentLeaseInfoVo;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/rentLeaseInfo")
@RestController
public class RentLeaseInfoController {
    @Autowired
    private RentLeaseInfoService rentLeaseInfoService;

    /**
     * 获取所有租约信息
     */
    @RequestMapping("/getLeaseInfoList")
    @ResponseBody
    public Object getLeaseInfoList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, RentLeaseInfoVo rentLeaseInfoVo){
        return rentLeaseInfoService.getLeaseInfoList(pageNum,pageSize,rentLeaseInfoVo);
    }

    /**
     * 添加租约信息
     */
    @RequestMapping("/addLeaseInfo")
    @ResponseBody
    public Object addLeaseInfo(HttpServletRequest request,RentLeaseInfo rentLeaseInfo){
        return rentLeaseInfoService.addLeaseInfo(rentLeaseInfo);
    }
    /**
     * 修改租约信息
     */
    @RequestMapping("/editLeaseInfo")
    @ResponseBody
    public Object editLeaseInfo(HttpServletRequest request, RentLeaseInfo rentLeaseInfo){
        return rentLeaseInfoService.editLeaseInfo(rentLeaseInfo);
    }
    /**
     * 删除租约信息
     */
    @RequestMapping("/deleteLeaseInfo")
    @ResponseBody
    public Object deleteLeaseInfo(HttpServletRequest request, String ids){
        return rentLeaseInfoService.deleteLeaseInfo(ids);
    }

    /**
     * 导入资产信息
     */
    @RequestMapping("/uploadLeaseInfoFile")
    @ResponseBody
    public Object uploadLeaseInfoFile(HttpServletRequest request, @RequestParam(value = "LeaseInfoFile", required = false) MultipartFile file){
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
            return  rentLeaseInfoService.uploadLeaseInfoFile(data);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return ResBean.error("上传失败");  // 处理异常情况，返回错误信息和状态码
        }
    }
}
