package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EditPlanScopeTest extends BaseClass {

    @Test(priority = 3)
    public void testEditAnomaly() throws IOException {
        editPlanScope.selectProgram(testData.getStringValueOfRow("program"));
        editPlanScope.clickPartName(testData.getStringValueOfRow("partName"));
        editPlanScope.searchRBIInspectionType(testData.getStringValueOfRow("rbiInspectionType"));
        editPlanScope.enterDueDate(String.valueOf(testData.getNumericValueOfRow("dueDate")));
        editPlanScope.enterDoneDate(String.valueOf(testData.getNumericValueOfRow("doneDate")));
        editPlanScope.extDate(String.valueOf(testData.getNumericValueOfRow("extDate")));
        editPlanScope.clickSaveButton();
    }
}
