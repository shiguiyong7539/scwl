package com.scwl.utils;

import org.apache.poi.ss.usermodel.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UploadUtils {

    public static List<String[]> getData(MultipartFile file){
        List<String[]> data = new ArrayList<>(); // 存储数据的列表
        // 创建Workbook对象并读取上传的文件内容
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0); // 获取第一个工作表
            Iterator<Row> rowIterator = sheet.iterator(); // 迭代行
            Row colums = rowIterator.next();
            int cellNumber = colums.getPhysicalNumberOfCells();
            // 遍历每一行并读取单元格数据
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                List<String> rowData = new ArrayList<>(); // 存储当前行的单元格数据
                for (int i = 0; i < cellNumber; i++) {
                    Cell cell = row.getCell(i);
                    if(null!=cell){
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
                    }else {
                        rowData.add(""); // 空值或其他类型数据，可以根据实际情况进行处理
                    }
                }
                data.add(rowData.toArray(new String[0])); // 将当前行的数据添加到列表中
            }
            workbook.close(); // 关闭Workbook对象释放资源
        } catch (IOException e) {
            e.printStackTrace();
        }
       return data;
    }
}

