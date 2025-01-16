package com.base.qa.utils;

import java.io.IOException;

public class TestData {

    String setSheetName;
    String setFlowName;
    FlowSheet readFromExcelSheet = new FlowSheet();

    public TestData(String flowName, String sheetName) {
        this.setFlowName = flowName;
        this.setSheetName = sheetName;
    }

    public String getStringValueOfRow(String row) throws IOException {
        initializeSheet();
        return readFromExcelSheet.getCellStringContent(readFromExcelSheet.getRowNumberUsingContents(row), testColumn());
    }

    public int getNumericValueOfRow(String row) throws IOException {
        initializeSheet();
        return readFromExcelSheet.getCellNumericContent(readFromExcelSheet.getRowNumberUsingContents(row), testColumn());
    }

    public int testColumn() throws IOException {
        initializeSheet();
        return readFromExcelSheet.getColumnNumberUsingContent(setFlowName);
    }

    public void initializeSheet() throws IOException {
        readFromExcelSheet.loadSheet(setSheetName);
    }
}
