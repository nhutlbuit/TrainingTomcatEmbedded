package com.training.service;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.training.util.ExcelUtility;


@Service
public class TrainingClassService {

	private final Logger logger = LoggerFactory.getLogger(TrainingClassService.class);
	
	@Value("classpath:excelTpls/AttendeeList_Template/SBF_1_buoi.xlsx")
	private Resource SBF_Template;
	
	@Value("classpath:excelTpls/AttendeeList_Template/SPP2.xlsx")
	private Resource SPP2_Template;
	
	@Value("classpath:excelTpls/AttendeeList_Template/SPP1.xlsx")
	private Resource SPP1_Template;

	public XSSFWorkbook sPP1Course() {
        XSSFWorkbook excelFromTpl = null;
		try {
			 excelFromTpl = new XSSFWorkbook(SPP1_Template.getInputStream());
			 
			 // Sheet 1
			 int sizeOfListAttendee = 10;
			 int templateRowNumber = 12;
			 int numberOfCols = 9;
			 Sheet sheet = excelFromTpl.getSheetAt(0); 
			 int stt = 1;
			 sheet.shiftRows(templateRowNumber + 1, sheet.getLastRowNum(), sizeOfListAttendee - 1);
			 int footer = sizeOfListAttendee + templateRowNumber;  
			 
			 Row templatedRow = sheet.getRow(templateRowNumber);
			 for ( int r = 1; r < sizeOfListAttendee; r++) {
                 Row activeRow = sheet.createRow(templateRowNumber + r);
                 activeRow.setHeight(templatedRow.getHeight());
                 for (int col = 0; col < numberOfCols; col++) {
                	 activeRow.createCell(col).setCellStyle(templatedRow.getCell(col).getCellStyle());
                 }
                 int index = 0;
                 activeRow.getCell(index++).setCellValue(stt++);
                 activeRow.getCell(index++).setCellValue(509777);
                 activeRow.getCell(index++).setCellValue("PHẠM PHƯƠNG LIÊN");
                 activeRow.getCell(index++).setCellValue(381656634);
             }
			 sheet.getRow(footer++).setHeight(templatedRow.getHeight());
			 sheet.getRow(footer++).setHeight(templatedRow.getHeight());
			 sheet.getRow(footer++).setHeight(templatedRow.getHeight());
			 templatedRow.setHeight((short)0);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return excelFromTpl;
	}
	
	public XSSFWorkbook sPP2Course() {
        XSSFWorkbook excelFromTpl = null;
		try {
			 excelFromTpl = new XSSFWorkbook(SPP2_Template.getInputStream());
			 
			 // Sheet 1
			 int sizeOfListAttendee = 10;
			 int templateRowNumber = 10;
			 int numberOfCols = 10;
			 Sheet sheet = excelFromTpl.getSheetAt(0); 
			 int stt = 1;
			 sheet.shiftRows(templateRowNumber + 1, sheet.getLastRowNum(), sizeOfListAttendee - 1);
			 int footer = sizeOfListAttendee + templateRowNumber;  
			 
			 Row templatedRow = sheet.getRow(templateRowNumber);
			 for ( int r = 1; r < sizeOfListAttendee; r++) {
                 Row activeRow = sheet.createRow(templateRowNumber + r);
                 activeRow.setHeight(templatedRow.getHeight());
                 for (int col = 0; col < numberOfCols; col++) {
                	 activeRow.createCell(col).setCellStyle(templatedRow.getCell(col).getCellStyle());
                 }
                 int index = 0;
                 activeRow.getCell(index++).setCellValue(stt++);
                 activeRow.getCell(index++).setCellValue(509777);
                 activeRow.getCell(index++).setCellValue("PHẠM PHƯƠNG LIÊN");
                 activeRow.getCell(index++).setCellValue(381656634);
             }
			 sheet.getRow(footer++).setHeight(templatedRow.getHeight());
			 sheet.getRow(footer++).setHeight(templatedRow.getHeight());
			 sheet.getRow(footer++).setHeight(templatedRow.getHeight());
			 templatedRow.setHeight((short)0);
			 
			 // Sheet 2
			 sizeOfListAttendee = 10;
			 templateRowNumber = 8;
			 numberOfCols = 7;
			 sheet = excelFromTpl.getSheetAt(1); 
			 stt = 1;
			 footer = sizeOfListAttendee + templateRowNumber;
			 templatedRow = sheet.getRow(templateRowNumber);
			 sheet.shiftRows(templateRowNumber + 1, sheet.getLastRowNum(), sizeOfListAttendee - 1);
			 for ( int r = 1; r < 10; r++) {
                 Row activeRow = sheet.createRow(templateRowNumber + r);
                 activeRow.setHeight(templatedRow.getHeight());
                 for (int col = 0; col < numberOfCols; col++) {
                	 activeRow.createCell(col).setCellStyle(templatedRow.getCell(col).getCellStyle());
                 }
                 int index = 0;
                 activeRow.getCell(index++).setCellValue(stt++);
                 activeRow.getCell(index++).setCellValue(509777);
                 activeRow.getCell(index++).setCellValue("PHẠM PHƯƠNG LIÊN");
                 activeRow.getCell(index++).setCellValue(381656634);
             }
			 sheet.getRow(footer).setHeight(templatedRow.getHeight());
			 templatedRow.setHeight((short)0);
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return excelFromTpl;
	}
	

	 
	
	public XSSFWorkbook SBFCourse() {
        XSSFWorkbook excelFromTpl = null;
		try {
			excelFromTpl = new XSSFWorkbook(SBF_Template.getInputStream());
			 Sheet sheet = excelFromTpl.getSheetAt(0); 
			 Sheet sheetTemplate = excelFromTpl.getSheetAt(1); 
			 short rowHeightTemplate = sheet.getRow(10).getHeight();
			 CellStyle itemNumberStyle = sheetTemplate.getRow(6).getCell(0).getCellStyle();
			 CellStyle itemStringStyle = sheetTemplate.getRow(6).getCell(1).getCellStyle();

			 Row activeRow = null;
			 int rowCount = 10;
			 int stt = 0;
			 for (int i = 0; i < 10; i++) {
				
				 activeRow = sheet.createRow(rowCount);
				 activeRow.setHeight(rowHeightTemplate);
				 int index = 0;
				 ExcelUtility.writeDataToCellSExistedRow(activeRow, index++, itemNumberStyle, stt++);
				 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, itemStringStyle, "A");
				 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, itemStringStyle, "A");
				 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, itemStringStyle, "A");
				 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, itemStringStyle, null);
				 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, itemStringStyle, "A");
				 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, itemStringStyle, null);
				 rowCount++;
			 }
			 
			 footerAppend(excelFromTpl, activeRow, rowCount);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return excelFromTpl;
	}
	
	private void footerAppend(XSSFWorkbook excelFromTpl, Row activeRow, int rowCount) {
		
		 Sheet sheet = excelFromTpl.getSheetAt(0); 
		 Sheet sheetTemplate = excelFromTpl.getSheetAt(1); 
		 
		 CellStyle footerStyle = sheetTemplate.getRow(8).getCell(0).getCellStyle();
		 short footerHeightStyle = sheetTemplate.getRow(0).getHeight();
		 short signatureHeightStyle = sheetTemplate.getRow(2).getHeight();
		 
		 CellStyle boderStyle = sheetTemplate.getRow(4).getCell(0).getCellStyle();
		 excelFromTpl.removeSheetAt(1);
		 
		 activeRow = sheet.createRow(rowCount);
		 activeRow.setHeight(footerHeightStyle);
		 sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 0, 2));
		 sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 3, 6));
		 int index = 0;
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, "Tham dự");
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 
		 rowCount++;
		 activeRow = sheet.createRow(rowCount);
		 activeRow.setHeight(footerHeightStyle);
		 sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 0, 2));
		 sheet.addMergedRegion(new CellRangeAddress(rowCount, rowCount, 3, 6));
		 index = 0;
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, "Vắng mặt");
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, footerStyle, null);

		
		 rowCount++;
		 activeRow = sheet.createRow(rowCount);
		 activeRow.setHeight(signatureHeightStyle);
		 index = 0;
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, 
			"Nhân viên huấn luyện \n (Ký & ghi rõ họ tên)");
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 
		 rowCount++;
		 activeRow = sheet.createRow(rowCount);
		 activeRow.setHeight(signatureHeightStyle);
		 index = 0;
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 ExcelUtility.writeDataToCellSExistedRowString(activeRow, index++, boderStyle, null);
		 
		 sheet.addMergedRegion(new CellRangeAddress(rowCount-1, rowCount, 0, 2));
		 sheet.addMergedRegion(new CellRangeAddress(rowCount-1, rowCount, 3, 6));
	}

  

}
