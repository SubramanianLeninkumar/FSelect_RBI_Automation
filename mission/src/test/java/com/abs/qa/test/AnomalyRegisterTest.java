package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class AnomalyRegisterTest extends BaseClass {

    @Test(priority = 4)
    public void testAnomalyRegisterSearch() throws IOException {
        anomalyRegister.clickAnomalySearch(testData.getStringValueOfRow("anomalyValue"));
        anomalyRegister.clickClearSearchResult();
        anomalyRegister.getAnomalyList();
        if (testData.getStringValueOfRow("yearFilter").equalsIgnoreCase("Yes")) {
            anomalyRegister.clickYearsDropdown(testData.getStringValueOfRow("yearValue"));
            anomalyRegister.getAnomalyList();
        } else if (testData.getStringValueOfRow("statusFilter").equalsIgnoreCase("Yes")) {
            anomalyRegister.selectStatus(testData.getStringValueOfRow("statusValue"));
            anomalyRegister.getAnomalyList();
        } else if (testData.getStringValueOfRow("downloadTemplate").equalsIgnoreCase("Yes")) {
            anomalyRegister.clickDownloadTemplate();
            //verifyFileDownload(properties.getProperty("downloads"), "YOHO_AnomalyExport.xlsx");
        } else if (testData.getStringValueOfRow("importTemplate").equalsIgnoreCase("Yes")) {
            anomalyRegister.clickImportAnomalyTemplate();
            forcedWaitForTwoSeconds();
            uploadFile(properties.getProperty("import.anomaly"), 0);//upload Image using AutoIT
            forcedWaitForThreeSeconds();
            anomalyRegister.clickCloseButton();
        }
        forcedWaitForTwoSeconds();
    }
}