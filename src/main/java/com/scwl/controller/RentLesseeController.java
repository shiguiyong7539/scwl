package com.scwl.controller;

import com.scwl.pojo.RentLessee;
import com.scwl.pojo.RentLessee;
import com.scwl.pojo.ResBean;
import com.scwl.service.RentLesseeService;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RequestMapping("/rentLessee")
@RestController
public class RentLesseeController {

    @Autowired
    private RentLesseeService rentLesseeService;

    /**
     * 获取所有月度租金缴纳信息
     */
    @RequestMapping("/getLesseeList")
    @ResponseBody
    public Object getLesseeList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize, RentLessee rentLessee){
        return rentLesseeService.getLesseeList(pageNum,pageSize,rentLessee);
    }

    /**
     * 添加月度租金缴纳信息
     */
    @RequestMapping("/addLessee")
    @ResponseBody
    public Object addLessee(HttpServletRequest request,RentLessee rentLessee){
        return rentLesseeService.addLessee(rentLessee);
    }
    /**
     * 修改月度租金缴纳信息
     */
    @RequestMapping("/editLessee")
    @ResponseBody
    public Object editLessee(HttpServletRequest request, RentLessee rentLessee){
        return rentLesseeService.editLessee(rentLessee);
    }
    /**
     * 删除月度租金缴纳信息
     */
    @RequestMapping("/deleteLessee")
    @ResponseBody
    public Object deleteLessee(HttpServletRequest request, String ids){
        return rentLesseeService.deleteLessee(ids);
    }


    @RequestMapping("/prestore")
    @ResponseBody
    public Object prestore(HttpServletRequest request, RentLessee rentLessee){
        return rentLesseeService.prestore(rentLessee);
    }
    /**
     * 导入资产信息
     */
    @RequestMapping("/uploadLesseeFile")
    @ResponseBody
    public Object uploadLesseeFile(HttpServletRequest request, @RequestParam(value = "lesseFile", required = false) MultipartFile file){
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
            return  rentLesseeService.uploadLesseeFile(data);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return ResBean.error("上传失败");  // 处理异常情况，返回错误信息和状态码
        }
    }
}
