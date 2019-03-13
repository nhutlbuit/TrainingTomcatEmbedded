package com.training.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * @Expectation writen data to cell on sheet in excel file
	 *  @param sheet
	 *  @param row
	 *  @param column
	 *  @param data has type double
	 *  */
	public static void writeDataToCell(Sheet sheet, int row, int colunm, double data ) {
		Row rowSpec = sheet.getRow(row);
		CellStyle cellStyle = rowSpec.getCell(colunm).getCellStyle();
		Cell pointingCell = rowSpec.createCell(colunm);
		pointingCell.setCellValue(data);
		pointingCell.setCellStyle(cellStyle);
	}
	
	/**
	 * @Expectation writen data to cell on sheet in excel file
	 *  @param sheet
	 *  @param row
	 *  @param column
	 *  @param data has type double
	 *  */
	public static void writeDataToCellDate(Sheet sheet, int row, int colunm, Date data ) {
		Row rowSpec = sheet.getRow(row);
		CellStyle cellStyle = rowSpec.getCell(colunm).getCellStyle();
		Cell pointingCell = rowSpec.createCell(colunm);
		pointingCell.setCellValue(data);
		pointingCell.setCellStyle(cellStyle);
	}
	
	/**
	 * @Expectation writen data to cell on sheet in excel file
	 *  @param sheet
	 *  @param row
	 *  @param column
	 *  @param data has type string
	 *  */
	public static void writeDataToCellString(Sheet sheet, int row, int colunm, String data ) {
		Row rowSpec = sheet.getRow(row);
		CellStyle cellStyle = rowSpec.getCell(colunm).getCellStyle();
		Cell pointingCell = rowSpec.createCell(colunm);
		pointingCell.setCellValue(data);
		pointingCell.setCellStyle(cellStyle);
	}

	/**
	 * @Expectation writen data to cell on sheet in excel file has existed row
	 *  @param row
	 *  @param column
	 *  @param cellStyle
	 *  @param Integer data
	 *  */
	public static void writeDataToCellSExistedRow(Row row, int colunm, CellStyle cellStyle, Integer data) {
		Cell sessionPlanCell = row.createCell(colunm);
		sessionPlanCell.setCellStyle(cellStyle);
		sessionPlanCell.setCellValue(data);
	}
	
	public static void writeDataToCellSExistedRowNoStyle(Row row, int colunm, Integer data) {
		Cell sessionPlanCell = row.getCell(colunm);
		sessionPlanCell.setCellValue(data);
	}
	
	/**
	 * @Expectation writen data to cell on sheet in excel file has existed row
	 *  @param row
	 *  @param column
	 *  @param cellStyle
	 *  @param double data
	 *  */
	public static void writeDataToCellSExistedRowDate(Row row, int colunm, CellStyle cellStyle, Date data) {
		Cell sessionPlanCell = row.createCell(colunm);
		sessionPlanCell.setCellStyle(cellStyle);
		sessionPlanCell.setCellValue(data);
	}
	
	/**
	 * @Expectation writen data to cell on sheet in excel file has existed row
	 *  @param row
	 *  @param column
	 *  @param cellStyle
	 *  @param data has type string
	 *  */
	public static void writeDataToCellSExistedRowString(Row row, int colunm, CellStyle cellStyle, String data) {
		Cell sessionPlanCell = row.createCell(colunm);
		sessionPlanCell.setCellStyle(cellStyle);
		sessionPlanCell.setCellValue(data);
	}
	
	public static void writeDataToCellSExistedRowStringNoStyle(Row row, int colunm, String data) {
		Cell sessionPlanCell = row.getCell(colunm);
		sessionPlanCell.setCellValue(data);
	}
	
	public static void writeDataToCellSExistedRowStringNotZero(Row row, int colunm, CellStyle txtStyle, CellStyle numberStyle, Integer input) {
		Cell sessionPlanCell = row.createCell(colunm);
		sessionPlanCell.setCellStyle(txtStyle);
		String data = null;
		sessionPlanCell.setCellValue(data);
		if (input != 0) {
			sessionPlanCell.setCellStyle(numberStyle);
			sessionPlanCell.setCellValue(input);
		}
	}
	
	private static void removeDataExcel(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException {
		
		File file = new File(filePath);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheetAt(0);
		for(int i=1; i<= sheet.getLastRowNum(); i++){
            Row row = sheet.getRow(i);
            if (row == null) continue;
            int lastRowNum = sheet.getLastRowNum();
            int rowIndex = row.getRowNum();
            if(rowIndex >= 0 && rowIndex < lastRowNum){
                sheet.shiftRows(rowIndex + 1, lastRowNum, -1);
            }
            if(rowIndex == lastRowNum){
                Row removingRow = sheet.getRow(rowIndex);
                if(removingRow != null) {
                    sheet.removeRow(removingRow);
                }
            }
        }
		FileOutputStream fileOut = new FileOutputStream(file, false);
		wb.write(fileOut);
		wb.close();
		fileOut.close();
	}
	
	/**
	 * Remove a row by its index
	 * @param sheet a Excel sheet
	 * @param rowIndex a 0 based index of removing row
	 */
	public static void removeRow(Sheet sheet, int rowIndex) {
	    int lastRowNum = sheet.getLastRowNum();
	    if(rowIndex >= 0 && rowIndex < lastRowNum){
	        sheet.shiftRows(rowIndex+1, lastRowNum, -1);
	    }
	    if(rowIndex == lastRowNum){
	        Row removingRow = sheet.getRow(rowIndex);
	        if(removingRow != null){
	            sheet.removeRow(removingRow);
	        }
	    }
	}
	

}
