package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class InspectionTest extends BaseClass {

    @Test
    public void testInspection() throws IOException {
        inspection.clickInspectionsTab();
        if (testData.getStringValueOfRow("searchInspection").equalsIgnoreCase("Yes")) {
            inspection.searchInspection(testData.getStringValueOfRow("inspectionName"));
            inspection.clickClearSearchResult();
            inspection.getInspectionList();
        } else if (testData.getStringValueOfRow("downloadInspections").equalsIgnoreCase("Yes")) {
            inspection.downloadInspections();
            //verifyFileDownload(properties.getProperty("downloads"), "InspectionList.xlsx");
        } else if (testData.getStringValueOfRow("checkInspectionFilters").equalsIgnoreCase("Yes")) {
            inspection.clickDaysFilter(testData.getStringValueOfRow("inspectionDaysFilter"));
            inspection.clickStatusFilter(testData.getStringValueOfRow("inspectionStatusFilter"));
            inspection.getInspectionList();
        } else if (testData.getStringValueOfRow("viewInspectionDetails").equalsIgnoreCase("Yes")) {
            inspection.searchInspection(testData.getStringValueOfRow("inspectionName"));
            inspection.viewDetails();
            inspection.getViewDetails();
        } else if (testData.getStringValueOfRow("deleteInspection").equalsIgnoreCase("Yes")) {
            inspection.searchInspection(testData.getStringValueOfRow("inspectionName"));
            inspection.deleteInspection();
        }
    }
}
