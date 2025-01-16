package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class MeetingsTest extends BaseClass {

    @Test(priority = 15)
    public void testMeetingList() throws IOException {
        if (testData.getStringValueOfRow("checkFilters").equalsIgnoreCase("Yes")) {
            meetings.clickFilters(testData.getStringValueOfRow("filterName"));
            meetings.meetingList();
        } else if (testData.getStringValueOfRow("downloadMeeting").equalsIgnoreCase("Yes")) {
            meetings.downloadMeetings();
            //verifyFileDownload(properties.getProperty("downloads"), "MeetingList.xlsx");
        } else {
            meetings.enterMeetingName(testData.getStringValueOfRow("meetingName"));
            meetings.meetingList();
            meetings.clearSearchResult();
            meetings.meetingPrimaryInformation(testData.getStringValueOfRow("meetingName"));
        }
    }
}
