package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EditMeetingsTest extends BaseClass {

    @Test(priority = 16)
    public void testEditMeeting() throws InterruptedException, IOException {
        editMeetings.clickMeetingAction();
        editMeetings.clickEditMeeting();
        editMeetings.enterMeetingName(testData.getStringValueOfRow("meetingName"));
        editMeetings.selectMeetingType(testData.getStringValueOfRow("meetingType"));
        editMeetings.enterMeetingDate(String.valueOf(testData.getNumericValueOfRow("meetingDate")));
        editMeetings.enterDescription(testData.getStringValueOfRow("description"));
        editMeetings.deleteDocument();
        editMeetings.uploadMeetingDocument();
        uploadFile(properties.getProperty("image.upload"), 1);
        editMeetings.documentDescription(testData.getStringValueOfRow("docDesc"), testData.getStringValueOfRow("docType"));
        editMeetings.selectChecklist(testData.getStringValueOfRow("checkList"));
        forcedWaitForTwoSeconds();
        scrollDown();
        editMeetings.clickUpdateButton();
    }
}
