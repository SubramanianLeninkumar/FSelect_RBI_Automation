package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class CreateEventWithInspectionTest extends BaseClass {

    @Test
    public void createEventWithInspection() throws IOException {
        createEventWithInspection.clickCreateEvent();
        createEventWithInspection.enterEventName(testData.getStringValueOfRow("newEventName"));
        createEventWithInspection.selectEventType(testData.getStringValueOfRow("eventType"));
        createEventWithInspection.enterEventStartDate(testData.getNumericValueOfRow("eventStartDate"));
        createEventWithInspection.enterEventEndDate(testData.getNumericValueOfRow("eventEndDate"));
        createEventWithInspection.enterEventLocation(testData.getStringValueOfRow("location"));
        createEventWithInspection.selectEventOwner(testData.getStringValueOfRow("owner"));
        createEventWithInspection.enterEventComments(testData.getStringValueOfRow("eventComments"));
        createEventWithInspection.uploadEventDocument();
        uploadFile(properties.getProperty("image.upload"), 1);
        createEventWithInspection.enterEventDocumentDescription(testData.getStringValueOfRow("documentDescription"));
        createEventWithInspection.selectEventDocumentType(testData.getStringValueOfRow("documentType"));
        createEventWithInspection.clickCreateInspection();
        createEventWithInspection.selectAssetType(testData.getStringValueOfRow("inspectionAssetType"));
        createEventWithInspection.selectAssetName(testData.getStringValueOfRow("inspectionAssetName"));
        createEventWithInspection.selectInspectionType(testData.getStringValueOfRow("inspectionType"));
        createEventWithInspection.enterInspectionName(testData.getStringValueOfRow("newInspectionName"));
        createEventWithInspection.selectInspector(testData.getStringValueOfRow("inspectionInspector"));
        createEventWithInspection.enterInspectionPlace(testData.getStringValueOfRow("inspectionPlace"));
        createEventWithInspection.enterInspectionStartDate(testData.getNumericValueOfRow("inspectionStartDate"));
        createEventWithInspection.enterInspectionEndDate(testData.getNumericValueOfRow("inspectionEndDate"));
        createEventWithInspection.enterInspectionComments(testData.getStringValueOfRow("inspectionComments"));
        createEventWithInspection.uploadInspectionDocument();
        uploadFile(properties.getProperty("image.upload"), 1);
        createEventWithInspection.enterInspectionDocumentDescription(testData.getStringValueOfRow("inspectionDocumentDescription"));
        createEventWithInspection.selectInspectionDocumentType(testData.getStringValueOfRow("inspectionDocumentType"));
        createEventWithInspection.clickSaveButton();
    }
}
