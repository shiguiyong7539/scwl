package com.scwl.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import org.apache.commons.codec.Charsets;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class ExportUtil {

    public static <T> void export(HttpServletResponse response, String fileName, String sheetName, List<T> dataList, Class<T> clazz) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding(Charsets.UTF_8.name());
            fileName = URLEncoder.encode(fileName, Charsets.UTF_8.name());
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            EasyExcel.write(response.getOutputStream(), clazz).sheet(sheetName).doWrite(dataList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void exportExcel(HttpServletResponse response,String fileName, List<String[]> data) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // 创建表头
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < data.get(0).length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(data.get(0)[i]);
        }

        // 填充数据
        for (int i = 1; i < data.size(); i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < data.get(i).length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(data.get(i)[j]);
            }
        }

        // 自动调整列宽
        for (int i = 0; i < data.get(0).length; i++) {
            sheet.autoSizeColumn(i);
        }
        // 设置响应头，使浏览器将其视为下载
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        // 将工作簿写入文件
        try (FileOutputStream outputStream = new FileOutputStream(fileName)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
