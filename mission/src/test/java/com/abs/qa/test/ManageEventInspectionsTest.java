package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class ManageEventInspectionsTest extends BaseClass {

    @Test
    public void manageEventInspectionsTest() throws IOException {
        manageEventInspections.clickManageInspection();
        manageEventInspections.selectAssetType(testData.getStringValueOfRow("manageInspection"), testData.getStringValueOfRow("inspectionAssetType"));
        manageEventInspections.selectAssetName(testData.getStringValueOfRow("manageInspection"), testData.getStringValueOfRow("inspectionAssetName"));
        manageEventInspections.selectInspectionType(testData.getStringValueOfRow("manageInspection"), testData.getStringValueOfRow("inspectionType"));
        manageEventInspections.enterInspectionName(testData.getStringValueOfRow("newInspectionName"));
        manageEventInspections.selectInspector(testData.getStringValueOfRow("manageInspection"), testData.getStringValueOfRow("inspectionInspector"));
        manageEventInspections.enterInspectionPlace(testData.getStringValueOfRow("inspectionPlace"));
        manageEventInspections.enterInspectionStartDate(testData.getNumericValueOfRow("inspectionStartDate"));
        manageEventInspections.enterInspectionEndDate(testData.getNumericValueOfRow("inspectionEndDate"));
        manageEventInspections.enterInspectionComments(testData.getStringValueOfRow("inspectionComments"));
        manageEventInspections.deleteDocument();
        manageEventInspections.uploadInspectionDocument();
        uploadFile(properties.getProperty("image.upload"), 1);
        manageEventInspections.enterInspectionDocumentDescription(testData.getStringValueOfRow("inspectionDocumentDescription"));
        manageEventInspections.selectInspectionDocumentType(testData.getStringValueOfRow("inspectionDocumentType"));
        manageEventInspections.clickSaveButton();
    }
}