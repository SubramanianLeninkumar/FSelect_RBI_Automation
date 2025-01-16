package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class AnomalyFindingTest extends BaseClass {

    @Test(priority = 5)
    public void testCreateAnomaly() throws InterruptedException, IOException {
        forcedWaitForThreeSeconds();
        anomalyFinding.clickAnomaliesTab(testData.getStringValueOfRow("cmAnomaliesTab"));
        anomalyFinding.clickCreateAnomaly();
        forcedWaitForThreeSeconds();
        anomalyFinding.selectAssetType(testData.getStringValueOfRow("assetType"));
        anomalyFinding.selectAsset(testData.getStringValueOfRow("asset"));
        anomalyFinding.selectCriteria(testData.getStringValueOfRow("criteria"));
        anomalyFinding.selectAffectedItem(testData.getStringValueOfRow("affectedItem"));
        anomalyFinding.selectIncidentType(testData.getStringValueOfRow("incidentType"));
        anomalyFinding.selectPrimaryLocation(testData.getStringValueOfRow("primaryLocation"));
        anomalyFinding.selectDefectDescriptor(testData.getStringValueOfRow("defectDescriptor"));
        anomalyFinding.enterDescription(testData.getStringValueOfRow("description"));
        anomalyFinding.enterComments(testData.getStringValueOfRow("comments"));
        anomalyFinding.uploadFindingDocument();
        if (testData.getStringValueOfRow("cmAnomaliesTab").equalsIgnoreCase("Yes")) {
            uploadFile(properties.getProperty("image.upload"), 1);
        } else {
            uploadFile(properties.getProperty("image.upload"), 2);
        }
        anomalyFinding.enterDocumentDescription(testData.getStringValueOfRow("documentDescription"));
        anomalyFinding.selectDocumentType(testData.getStringValueOfRow("documentType"), testData.getStringValueOfRow("section"));
        anomalyFinding.clickSaveAndContinue();
        anomalyFinding.clickContinueButton(testData.getStringValueOfRow("section"));
    }
}
