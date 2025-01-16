package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class CreateEventTest extends BaseClass {

    @Test
    public void testEventCreation() throws IOException, InterruptedException {
        createEvent.clickCreateEvent();
        createEvent.enterEventName(testData.getStringValueOfRow("newEventName"));
        createEvent.selectEventType(testData.getStringValueOfRow("eventType"));
        createEvent.enterStartDate(testData.getNumericValueOfRow("eventStartDate"));
        createEvent.enterEndDate(testData.getNumericValueOfRow("eventEndDate"));
        createEvent.enterLocation(testData.getStringValueOfRow("location"));
        createEvent.selectOwner(testData.getStringValueOfRow("owner"));
        createEvent.enterComments(testData.getStringValueOfRow("eventComments"));
        createEvent.uploadDocument();
        uploadFile(properties.getProperty("image.upload"), 1);
        createEvent.enterDocumentDescription(testData.getStringValueOfRow("documentDescription"));
        createEvent.selectDocumentType(testData.getStringValueOfRow("documentType"));
        createEvent.clickSaveButton();
    }
}
