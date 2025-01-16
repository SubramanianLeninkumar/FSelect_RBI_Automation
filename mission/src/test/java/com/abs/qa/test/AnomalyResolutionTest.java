package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class AnomalyResolutionTest extends BaseClass {

    @Test(priority = 8)
    public void testAnomalyResolution() throws IOException, InterruptedException {
        anomalyResolution.selectRepairType(testData.getStringValueOfRow("repairType"));
        anomalyResolution.selectClosedDate(String.valueOf(testData.getNumericValueOfRow("closedDate")));
        anomalyResolution.selectActionTaken(testData.getStringValueOfRow("actionTaken"));
        anomalyResolution.enterComments(testData.getStringValueOfRow("resolutionComments"));
        anomalyResolution.uploadResolutionDocument();
        if (testData.getStringValueOfRow("cmAnomaliesTab").equalsIgnoreCase("Yes")) {
            uploadFile(properties.getProperty("image.upload"), 1);
        } else {
            uploadFile(properties.getProperty("image.upload"), 2);
        }
        anomalyResolution.enterDocumentDescription(testData.getStringValueOfRow("resolutionDocumentDescription"));
        anomalyResolution.selectDocumentType(testData.getStringValueOfRow("resolutionDocumentType"));
        anomalyResolution.clickSaveButton();
    }
}
