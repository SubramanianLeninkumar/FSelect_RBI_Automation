package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class ActionPlanTest extends BaseClass {

    @Test
    public void testActionPlan() throws InterruptedException, IOException {
        actionPlan.clickActionPlanMenu();
        if (testData.getStringValueOfRow("actionPlanTest").equalsIgnoreCase("Yes")) {
            actionPlan.selectActionPlan(testData.getStringValueOfRow("options"), testData.getStringValueOfRow("name"));
            actionPlan.clickActionButton();
            actionPlan.selectDueDate(testData.getNumericValueOfRow("dueDate"));
            actionPlan.deleteActionItem();
            actionPlan.clickAddActionItem();
            actionPlan.enterActionItem(testData.getStringValueOfRow("actionItem"));
            actionPlan.enterStartDate(testData.getNumericValueOfRow("startDate"));
            actionPlan.enterEndDate(testData.getNumericValueOfRow("endDate"));
            actionPlan.enterComments(testData.getStringValueOfRow("comments"));
            actionPlan.deleteActionPlanDocument();
            actionPlan.uploadActionPlanDocument();
            uploadFile(properties.getProperty("image.upload"), 1);
            actionPlan.enterDocumentDescription(testData.getStringValueOfRow("documentDescription"));
            actionPlan.selectDocumentType(testData.getStringValueOfRow("documentType"));
            actionPlan.clickUpdateButton();
            actionPlan.clickOkButton();
        } else if (testData.getStringValueOfRow("importActionPlan").equalsIgnoreCase("Yes")) {
            actionPlan.clickImportPlanAction();
            forcedWaitForTwoSeconds();
            Runtime.getRuntime().exec(properties.getProperty(""));//upload Image using AutoIT
            forcedWaitForThreeSeconds();
        } else if (testData.getStringValueOfRow("exportActionPlan").equalsIgnoreCase("Yes")) {
            actionPlan.clickExportPlanAction();
            //verifyFileDownload(properties.getProperty("downloads"), "YOHO_ActionPlanExport.xlsx");
        }
    }
}
