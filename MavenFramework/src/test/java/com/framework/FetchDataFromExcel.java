package com.framework;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {

	public static void main(String[] args, Object STRING, Object NUMERIC) throws EncryptedDocumentException, IOException {
     FileInputStream file = new FileInputStream("./src/test/resource/facebooklogindata.xlsx.xlsx");
     Workbook workbook = WorkbookFactory.create(file);
     int LastRow = workbook.getSheetAt(0).getLastRowNum();
     int LastCell = workbook.getSheetAt(0).getRow(0).getLastCellNum();
     for (int r=1; r<=LastRow; r++) {
    	Row row = workbook.getSheetAt(0).getRow(r);
    	for(int c=0; c<LastCell;c++) {
    		Cell cell = row.getCell(c);
    		CellType cellType = cell.getCellType();
    		if(cellType.equals(STRING)) {
    			System.out.println(cell.getStringCellValue());
    		}else if(cellType.equals(NUMERIC)) {
    			System.out.println(cell.getStringCellValue());
    		}
    		System.out.println();
    	}
     }
	}

}
