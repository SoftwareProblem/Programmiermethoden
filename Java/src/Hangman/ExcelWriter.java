package Hangman;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.XMLHelper;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Date;


public class ExcelWriter extends Writer{
    @Override
    public boolean write(char[] charArray, char cha, int failedAttempts) {
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        Row row;
        Cell cell;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(new File(this.subject+".xls")));
            Cell lastCell = workbook.getSheetAt(0).getRow(workbook.getSheetAt(0).getLastRowNum()).getCell(3);
            if(lastCell.getNumericCellValue()==0.0){
                sheet = workbook.createSheet(""+System.currentTimeMillis());
            } else {
                sheet = workbook.getSheetAt(workbook.getNumberOfSheets());
            }
        } catch (FileNotFoundException e){
            workbook = new XSSFWorkbook();
            sheet = workbook.createSheet(""+System.currentTimeMillis());
            row = sheet.createRow(0);
            cell = row.createCell(0);
            cell.setCellValue("Zeit");
            cell = row.createCell(1);
            cell.setCellValue("Aktueller Stand");
            cell = row.createCell(2);
            cell.setCellValue("Zu letzt geratener Buchstabe");
            cell = row.createCell(3);
            cell.setCellValue("Anzahl noch möglicher Fehlversuche");
        } catch (IOException e) {
            e.printStackTrace();
        }
        int rownum = sheet.getLastRowNum()+1;
        int cellnum = 0;

        row = sheet.createRow(rownum);
        cell = row.createCell(cellnum++);
        cell.setCellValue((new Date().toString()));
        cell = row.createCell(cellnum++);
        cell.setCellValue(String.valueOf(charArray));
        cell = row.createCell(cellnum++);
        cell.setCellValue(Character.toString(cha));
        cell = row.createCell(cellnum);
        if(failedAttempts==-1){
            cell.setCellValue(0);
        }else {
            cell.setCellValue(difficulty.getValue() - failedAttempts);
        }
        try {
            FileOutputStream out = new FileOutputStream(new File(this.subject+".xls"));
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            System.out.println(123);
            e.printStackTrace();
        }
        return false;
    }




}
