package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class CreateInspectionTest extends BaseClass {

    @Test
    public void testInspections() throws IOException, InterruptedException {
        createInspection.clickInspectionsTab();
        createInspection.clickCreateInspection();
        createInspection.selectAssetType(testData.getStringValueOfRow("inspectionAssetType"));
        createInspection.selectAssetName(testData.getStringValueOfRow("inspectionAssetName"));
        createInspection.searchByEventName(testData.getStringValueOfRow("inspectionEventName"));
        createInspection.selectInspectionType(testData.getStringValueOfRow("inspectionType"));
        createInspection.enterInspectionName(testData.getStringValueOfRow("newInspectionName"));
        createInspection.selectInspector(testData.getStringValueOfRow("inspectionInspector"));
        createInspection.enterInspectionPlace(testData.getStringValueOfRow("inspectionPlace"));
        createInspection.enterStartDate(testData.getNumericValueOfRow("inspectionStartDate"));
        createInspection.enterEndDate(testData.getNumericValueOfRow("inspectionEndDate"));
        createInspection.enterComments(testData.getStringValueOfRow("inspectionComments"));
        createInspection.uploadDocument();
        uploadFile(properties.getProperty("image.upload"), 1);
        createInspection.enterDocumentDescription(testData.getStringValueOfRow("inspectionDocumentDescription"));
        createInspection.selectDocumentType(testData.getStringValueOfRow("inspectionDocumentType"));
        createInspection.clickSaveButton();
    }
}
