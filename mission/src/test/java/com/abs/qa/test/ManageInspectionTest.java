package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class ManageInspectionTest extends BaseClass {

    @Test
    public void manageInspectionTest() throws IOException {
        manageInspection.clickManageInspection();
        manageInspection.enterFittingValue(String.valueOf(testData.getNumericValueOfRow("fittingValue")));
        manageInspection.enterComments(testData.getStringValueOfRow("comments"));
        manageInspection.selectReviewer(testData.getStringValueOfRow("reviewer"));
        manageInspection.enterStatusComments(testData.getStringValueOfRow("statusComments"));
        manageInspection.clickSaveButton();
    }
}
