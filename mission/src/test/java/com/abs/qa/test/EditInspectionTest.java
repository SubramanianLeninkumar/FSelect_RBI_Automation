package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EditInspectionTest extends BaseClass {

    @Test
    public void testEditInspection() throws IOException {
        editInspection.clickEditInspection();
        editInspection.selectAssetType(testData.getStringValueOfRow("manageInspection"), testData.getStringValueOfRow("inspectionAssetType"));
        editInspection.selectAssetName(testData.getStringValueOfRow("manageInspection"), testData.getStringValueOfRow("inspectionAssetName"));
        editInspection.selectInspectionType(testData.getStringValueOfRow("manageInspection"), testData.getStringValueOfRow("inspectionType"));
        editInspection.enterInspectionName(testData.getStringValueOfRow("newInspectionName"));
        editInspection.selectInspector(testData.getStringValueOfRow("manageInspection"), testData.getStringValueOfRow("inspectionInspector"));
        editInspection.enterInspectionPlace(testData.getStringValueOfRow("inspectionPlace"));
        editInspection.enterInspectionStartDate(testData.getNumericValueOfRow("inspectionStartDate"));
        editInspection.enterInspectionEndDate(testData.getNumericValueOfRow("inspectionEndDate"));
        editInspection.enterInspectionComments(testData.getStringValueOfRow("inspectionComments"));
        editInspection.deleteDocument();
        editInspection.uploadInspectionDocument();
        uploadFile(properties.getProperty("image.upload"), 1);
        editInspection.enterInspectionDocumentDescription(testData.getStringValueOfRow("inspectionDocumentDescription"));
        editInspection.selectInspectionDocumentType(testData.getStringValueOfRow("inspectionDocumentType"));
        editInspection.clickSaveButton();
    }
}
