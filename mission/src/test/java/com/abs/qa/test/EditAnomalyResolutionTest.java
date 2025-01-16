package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EditAnomalyResolutionTest extends BaseClass {

    @Test(priority = 12)
    public void testEditAnomalyResolution() throws InterruptedException, IOException {
        editAnomalyResolution.selectRepairType(testData.getStringValueOfRow("repairType"));
        editAnomalyResolution.selectClosedDate(testData.getNumericValueOfRow("closedDate"));
        editAnomalyResolution.selectActionTaken(testData.getStringValueOfRow("actionTaken"));
        editAnomalyResolution.enterComments(testData.getStringValueOfRow("resolutionComments"));
        editAnomalyResolution.deleteDocument();
        forcedWaitForTwoSeconds();
        editAnomalyResolution.uploadResolutionDocument();
        if (testData.getStringValueOfRow("cmAnomaliesTab").equalsIgnoreCase("Yes")) {
            uploadFile(properties.getProperty("image.upload"), 1);
        } else {
            uploadFile(properties.getProperty("image.upload"), 2);
        }
        editAnomalyResolution.enterDocumentDescription(testData.getStringValueOfRow("resolutionDocumentDescription"));
        editAnomalyResolution.selectDocumentType(testData.getStringValueOfRow("resolutionDocumentType"));
        editAnomalyResolution.clickUpdateButton();
    }
}
