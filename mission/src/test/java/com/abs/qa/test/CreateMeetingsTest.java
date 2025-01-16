package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class CreateMeetingsTest extends BaseClass {

    @Test(priority = 14)
    public void testMeetings() throws IOException {
        createMeetings.clickAddMeetings();
        createMeetings.enterMeetingName(testData.getStringValueOfRow("meetingName"));
        createMeetings.selectMeetingType(testData.getStringValueOfRow("meetingType"));
        createMeetings.enterMeetingDate(String.valueOf(testData.getNumericValueOfRow("meetingDate")));
        createMeetings.enterDescription(testData.getStringValueOfRow("description"));
        createMeetings.uploadMeetingDocument();
        uploadFile(properties.getProperty("image.upload"), 1);
        createMeetings.documentDescription(testData.getStringValueOfRow("docDesc"), testData.getStringValueOfRow("docType"));
        createMeetings.selectChecklist(testData.getStringValueOfRow("checkList"));
        forcedWaitForTwoSeconds();
        scrollDown();
        createMeetings.clickSaveButton();
    }
}
