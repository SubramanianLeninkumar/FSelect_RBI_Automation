package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class PlanScopeTest extends BaseClass {

    @Test(priority = 2)
    public void testPlanScope() throws InterruptedException, IOException {
        if (testData.getStringValueOfRow("downloadFile").equalsIgnoreCase("Yes")) {
            planScope.downloadPlanScope();
            //verifyFileDownload(properties.getProperty("downloads"), "RBIPlanList.xlsx");
        } else {
            planScope.searchPlanScope(testData.getStringValueOfRow("name"));
            planScope.dateBulkUpdate();
            planScope.selectRecordsAndBulkUpdate();
            planScope.selectRBIDueDate();
            planScope.selectRBIDoneDate();
            planScope.selectRBIExtendedDate();
            planScope.saveBulkUpdate();
            planScope.selectDueDropDown(testData.getStringValueOfRow("dueOption"));
            planScope.selectYearDropDown(testData.getStringValueOfRow("year"));
            planScope.selectProgram(testData.getStringValueOfRow("program"));
            planScope.selectSurvey(testData.getStringValueOfRow("survey"));
        }
    }
}
