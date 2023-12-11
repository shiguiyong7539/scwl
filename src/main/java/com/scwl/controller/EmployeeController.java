package com.scwl.controller;

import com.scwl.pojo.Employee;
import com.scwl.pojo.ResBean;
import com.scwl.service.EmployeeService;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@RestController
public class EmployeeController {


    @Resource
    EmployeeService employeeService;

    /**
     * 获取人事信息一览
     * @return
     */
    @RequestMapping("/getEmployeeList")
    @ResponseBody
    public Object getEmployeeList(HttpServletRequest request, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize,Employee employee){
        return employeeService.getEmpList(pageNum,pageSize,employee);
    }


    /**
     * 人事添加员工信息
     * @return
     */
    @RequestMapping("/addEmployee")
    @ResponseBody
    public Object addEmployee(HttpServletRequest request, Employee employee ){
        return employeeService.addEmployee(employee);
    }

    /**
     * 人事添加员工信息
     * @return
     */
    @RequestMapping("/updateMember")
    @ResponseBody
    public Object updateMember(HttpServletRequest request, Employee employee ){
        return employeeService.updateMember(employee);
    }
    /**
     * 按年龄分组
     * @return
     */
    @RequestMapping("/getByCenter")
    @ResponseBody
    public Object getByCenter(){
        return employeeService.getByCenter();
    }

    @RequestMapping("/uploadMemberFile")
    @ResponseBody
    public Object uploadMemberFile(HttpServletRequest request, @RequestParam(value = "memberFile", required = false) MultipartFile file){
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
            return  employeeService.uploadMemberFile(data);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return ResBean.error("上传失败");  // 处理异常情况，返回错误信息和状态码
        }
    }


}