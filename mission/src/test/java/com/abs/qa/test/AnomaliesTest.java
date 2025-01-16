package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class AnomaliesTest extends BaseClass {

    @Test
    public void testAnomalies() throws IOException {
        anomalies.clickAnomaliesTab();
        if (testData.getStringValueOfRow("searchCMAnomaly").equalsIgnoreCase("Yes")) {
            anomalies.searchAnomaly(testData.getStringValueOfRow("cmAnomalyName"));
            anomalies.clickClearSearchResult();
            anomalies.getAnomalyList();
        } else if (testData.getStringValueOfRow("downloadCMAnomaly").equalsIgnoreCase("Yes")) {
            anomalies.downloadAnomalies();
            //verifyFileDownload(properties.getProperty("downloads"),"CMAnomalyList.xlsx");
        } else if (testData.getStringValueOfRow("checkCMAnomalyFilters").equalsIgnoreCase("Yes")) {
            anomalies.clickDaysFilter(testData.getStringValueOfRow("cmAnomalyDaysFilter"));
            anomalies.clickStatusFilter(testData.getStringValueOfRow("cmAnomalyStatusFilter"));
            anomalies.getAnomalyList();
            anomalies.clickClearSearchResult();
        }
    }
}
