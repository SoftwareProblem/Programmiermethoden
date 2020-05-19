package Hangman;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Date;


public class ExcelWriter extends Writer{
    /**
     * write the args into a formated .xls File
     * @param charArray current status of the word
     * @param cha the last guessed letter
     * @param failedAttempts
     * @return return true if the game is over, no matter of the player win or lose
     * @author Michel Dudas
     */
    @Override
    public boolean write(char[] charArray, char cha, int failedAttempts) {
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        Row row;
        Cell cell;
        Cell lastCell = null;
        try {
            workbook = new XSSFWorkbook(new FileInputStream(new File(this.subject+".xls")));
            lastCell = workbook.getSheetAt(0).getRow(workbook.getSheetAt(workbook.getNumberOfSheets()-1).getLastRowNum()).getCell(3);
        } catch (FileNotFoundException e){
            workbook = new XSSFWorkbook();
        } catch (IOException e) {
            e.printStackTrace();
        }
        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerCellStyle.setFont(headerFont);
        CellStyle firstCellStyle = workbook.createCellStyle();
        firstCellStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.index);
        firstCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        CellStyle secondCellStyle = workbook.createCellStyle();
        secondCellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.index);
        secondCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        if (lastCell!=null){
            if(lastCell.getCellType()== CellType.NUMERIC){
                if((int) lastCell.getNumericCellValue()==0){
                    sheet = workbook.createSheet(""+System.currentTimeMillis());
                    row = sheet.createRow(0);
                    row.setRowStyle(headerCellStyle);
                    cell = row.createCell(0);
                    cell.setCellStyle(headerCellStyle);
                    cell.setCellValue("Zeit");
                    cell = row.createCell(1);
                    cell.setCellStyle(headerCellStyle);
                    cell.setCellValue("Aktueller Stand");
                    cell = row.createCell(2);
                    cell.setCellStyle(headerCellStyle);
                    cell.setCellValue("Zu letzt geratener Buchstabe");
                    cell = row.createCell(3);
                    cell.setCellStyle(headerCellStyle);
                    cell.setCellValue("Anzahl noch möglicher Fehlversuche");
                }
                else {
                    sheet = workbook.getSheetAt(workbook.getNumberOfSheets()-1);
                }
            } else {
                sheet = workbook.getSheetAt(workbook.getNumberOfSheets()-1);
            }
        } else {
            sheet = workbook.createSheet(""+System.currentTimeMillis());
            row = sheet.createRow(0);
            row.setRowStyle(headerCellStyle);
            cell = row.createCell(0);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue("Zeit");
            cell = row.createCell(1);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue("Aktueller Stand");
            cell = row.createCell(2);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue("Zu letzt geratener Buchstabe");
            cell = row.createCell(3);
            cell.setCellStyle(headerCellStyle);
            cell.setCellValue("Anzahl noch möglicher Fehlversuche");
        }
        int rownum = sheet.getLastRowNum()+1;
        int cellnum = 0;
        if(rownum%2==0){
            row = sheet.createRow(rownum);
            row.setRowStyle(firstCellStyle);
            cell = row.createCell(cellnum++);
            cell.setCellStyle(firstCellStyle);
            cell.setCellValue((new Date().toString()));
            cell = row.createCell(cellnum++);
            cell.setCellStyle(firstCellStyle);
            cell.setCellValue(String.valueOf(charArray));
            cell = row.createCell(cellnum++);
            cell.setCellStyle(firstCellStyle);
            cell.setCellValue(Character.toString(cha));
            cell = row.createCell(cellnum);
            cell.setCellStyle(firstCellStyle);
            if(failedAttempts==-1){
                cell.setCellValue(0);
            }else {
                cell.setCellValue(difficulty.getValue() - failedAttempts);
            }
        } else{
            row = sheet.createRow(rownum);
            row.setRowStyle(secondCellStyle);
            cell = row.createCell(cellnum++);
            cell.setCellStyle(secondCellStyle);
            cell.setCellValue((new Date().toString()));
            cell = row.createCell(cellnum++);
            cell.setCellStyle(secondCellStyle);
            cell.setCellValue(String.valueOf(charArray));
            cell = row.createCell(cellnum++);
            cell.setCellStyle(secondCellStyle);
            cell.setCellValue(Character.toString(cha));
            cell = row.createCell(cellnum);
            cell.setCellStyle(secondCellStyle);
            if(failedAttempts==-1){
                cell.setCellValue(0);
            }else {
                cell.setCellValue(difficulty.getValue() - failedAttempts);
            }
        }
        try {
            FileOutputStream out = new FileOutputStream(new File(this.subject+".xls"));
            workbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }




}
