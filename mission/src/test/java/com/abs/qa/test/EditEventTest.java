package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EditEventTest extends BaseClass {

    @Test
    public void testEditEvent() throws IOException, InterruptedException {
        editEvent.searchEvent(testData.getStringValueOfRow("eventName"));
        editEvent.editEvents();
        editEvent.enterEventName(testData.getStringValueOfRow("editEventName"));
        editEvent.selectEventType(testData.getStringValueOfRow("editEventType"));
        editEvent.enterStartDate(testData.getNumericValueOfRow("editEventStartDate"));
        editEvent.enterEndDate(testData.getNumericValueOfRow("editEventStartDate"));
        editEvent.enterLocation(testData.getStringValueOfRow("editLocation"));
        editEvent.selectOwner(testData.getStringValueOfRow("editOwner"));
        editEvent.enterComments(testData.getStringValueOfRow("editComments"));
        editEvent.deleteDocument();
        editEvent.uploadDocument();
        uploadFile(properties.getProperty("image.upload"), 1);
        editEvent.enterDocumentDescription(testData.getStringValueOfRow("editDocumentDescription"));
        editEvent.selectDocumentType(testData.getStringValueOfRow("editDocumentType"));
        editEvent.clickSaveButton();
    }
}
