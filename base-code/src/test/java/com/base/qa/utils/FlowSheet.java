package com.base.qa.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;

public class FlowSheet {

    private static final String FLOWSHEET_PATH = "flows.xls";
    private HSSFWorkbook wb;
    private HSSFSheet sheet;
    private HSSFCell cellContent;

    public void loadSheet(String sheetName) throws IOException {
        InputStream sheetLocation = this.getClass().getClassLoader().getResourceAsStream(FLOWSHEET_PATH);
        wb = new HSSFWorkbook(sheetLocation);
        sheet = wb.getSheet(sheetName);
    }

    public int getColumnNumberUsingContent(String colContent) {
        DataFormatter fmt = new DataFormatter();
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (colContent.equalsIgnoreCase(fmt.formatCellValue(cell))) {
                    return cell.getColumnIndex();
                }
            }
        }
        return 0;
    }

    public int getRowNumberUsingContents(String rowContent) {
        DataFormatter fmt = new DataFormatter();
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (rowContent.trim().equalsIgnoreCase(fmt.formatCellValue(cell).trim())) {
                    return cell.getRowIndex();
                }
            }
        }
        return 0;
    }

    public String getCellStringContent(int rowNum, int colNum) {
        cellContent = sheet.getRow(rowNum).getCell(colNum);
        String stringValueOfCell;
        if (cellContent != null) {
            stringValueOfCell = cellContent.getStringCellValue();
        } else {
            stringValueOfCell = "";
        }
        return stringValueOfCell;
    }

    public int getCellNumericContent(int rowNum, int colNum) {
        cellContent = sheet.getRow(rowNum).getCell(colNum);
        int numericValueOfCell;
        if (cellContent != null) {
            numericValueOfCell = (int) cellContent.getNumericCellValue();
        } else {
            numericValueOfCell = 0;
        }
        return numericValueOfCell;
    }
}
