package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EventTest extends BaseClass {

    @Test
    public void testEvents() throws IOException {
        events.getConditionManagerDetails(testData.getStringValueOfRow("eventOptions"));
        if (testData.getStringValueOfRow("searchEvent").equalsIgnoreCase("Yes")) {
            events.searchEvent(testData.getStringValueOfRow("eventName"));
            events.clickClearSearchResult();
            events.getEventList();
        } else if (testData.getStringValueOfRow("downloadEvents").equalsIgnoreCase("Yes")) {
            events.downloadEvents();
            //verifyFileDownload(properties.getProperty("downloads"), "EventsList.xlsx");
        } else if (testData.getStringValueOfRow("viewDetails").equalsIgnoreCase("Yes")) {
            events.searchEvent(testData.getStringValueOfRow("eventName"));
            events.viewDetails();
            events.getViewDetails();
        } else if (testData.getStringValueOfRow("deleteEvent").equalsIgnoreCase("Yes")) {
            events.searchEvent(testData.getStringValueOfRow("eventName"));
            events.deleteEvent();
        }
    }
}