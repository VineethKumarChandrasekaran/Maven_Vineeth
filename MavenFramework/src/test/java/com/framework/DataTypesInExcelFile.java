package com.framework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
//hai add this too
public class DataTypesInExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("./src/test/resource/facebooklogindata.xlsx.xlsx");
		Workbook workbook = WorkbookFactory.create(file);
		Sheet sheet = workbook.getSheet("logindetails");
		int lastRowNum = sheet.getLastRowNum();
		System.out.println(lastRowNum);
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		System.out.println(lastCellNum);
		for (int r = 1; r <= lastRowNum; r++) {
			Row row = sheet.getRow(r);
			for (int c = 0; c < lastCellNum; c++) {
				Cell cell = row.getCell(c);
				cell.getCellType();
				if (CellType.STRING != null) {
					System.out.println(cell.getStringCellValue());
				} else {
					cell.getCellType();
					if (CellType.NUMERIC != null) {
						System.out.println((long) cell.getNumericCellValue());
					}
				}
			}
		}
	}

}
