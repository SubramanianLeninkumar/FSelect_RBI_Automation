package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EditAnomalyFindingTest extends BaseClass {

    @Test(priority = 9)
    public void testEditAnomalyFinding() throws IOException, InterruptedException {
        editAnomalyFinding.clickAnomaliesTab(testData.getStringValueOfRow("cmAnomaliesTab"), testData.getStringValueOfRow("cmAnomalyStatusFilter"));
        editAnomalyFinding.anomalySearch(testData.getStringValueOfRow("cmAnomaliesTab"), testData.getStringValueOfRow("anomalyID"));
        editAnomalyFinding.clickActionButton();
        editAnomalyFinding.clickActionAnomalyDetails();
        editAnomalyFinding.selectCriteria(testData.getStringValueOfRow("criteria"));
        editAnomalyFinding.selectIncidentType(testData.getStringValueOfRow("incidentType"));
        editAnomalyFinding.selectPrimaryLocation(testData.getStringValueOfRow("primaryLocation"));
        editAnomalyFinding.selectDefectDescriptor(testData.getStringValueOfRow("defectDescriptor"));
        editAnomalyFinding.enterDescription(testData.getStringValueOfRow("description"));
        editAnomalyFinding.enterComments(testData.getStringValueOfRow("comments"));
        editAnomalyFinding.deleteDocument();
        forcedWaitForTwoSeconds();
        editAnomalyFinding.uploadFindingDocument();
        if (testData.getStringValueOfRow("cmAnomaliesTab").equalsIgnoreCase("Yes")) {
            uploadFile(properties.getProperty("image.upload"), 1);
        } else {
            uploadFile(properties.getProperty("image.upload"), 2);
        }
        editAnomalyFinding.enterDocumentDescription(testData.getStringValueOfRow("documentDescription"));
        editAnomalyFinding.selectDocumentType(testData.getStringValueOfRow("documentType"));
        editAnomalyFinding.clickUpdateButton();
        editAnomalyFinding.clickOkButton();
        editAnomalyFinding.clickContinueButton();
    }
}
