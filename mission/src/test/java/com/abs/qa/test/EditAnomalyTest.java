package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EditAnomalyTest extends BaseClass {

    @Test(priority = 13)
    public void testEditAnomaly() throws IOException {
        editAnomaly.clickAnomalySearch(testData.getStringValueOfRow("cmAnomaliesTab"), testData.getStringValueOfRow("anomalyID"));
        if (testData.getStringValueOfRow("editAnomalyDetails").equalsIgnoreCase("Yes")) {
            editAnomaly.clickAnomalyID(testData.getStringValueOfRow("anomalyID"));
            editAnomaly.getAnomalyDetails();
            editAnomaly.clickCloseButton();
        } else if (testData.getStringValueOfRow("downloadAttachment").equalsIgnoreCase("Yes")) {
            editAnomaly.clickAnomaliesTab(testData.getStringValueOfRow("cmAnomaliesTab"), testData.getStringValueOfRow("cmAnomalyStatusFilter"));
            editAnomaly.clickActionButton();
            editAnomaly.clickActionDownloadAttachment();
            editAnomaly.selectAttachments(testData.getStringValueOfRow("option"));
            editAnomaly.clickDownloadAttachment();
            //verifyFileDownload(properties.getProperty("downloads"), "AnomalyDetail");
        }
    }
}
