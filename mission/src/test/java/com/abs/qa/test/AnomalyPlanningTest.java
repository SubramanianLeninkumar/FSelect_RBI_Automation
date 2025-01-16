package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class AnomalyPlanningTest extends BaseClass {

    @Test(priority = 7)
    public void testAnomalyPlanning() throws InterruptedException, IOException {
        anomalyPlanning.enterAssignedTo(testData.getStringValueOfRow("assignedTo"));
        anomalyPlanning.selectProposedAction(testData.getStringValueOfRow("proposedAction"));
        anomalyPlanning.enterResolutionDate(String.valueOf(testData.getNumericValueOfRow("resolutionDate")));
        anomalyPlanning.enterPlannedEvent(testData.getStringValueOfRow("plannedEvent"));
        if (testData.getStringValueOfRow("rbiAnomalyCreation").equalsIgnoreCase("Yes")) {
            anomalyPlanning.selectRequiredResolution(testData.getStringValueOfRow("requiredResolution"));
            anomalyPlanning.clickChangeOfManagement(testData.getStringValueOfRow("changeOfManagement"));
            anomalyPlanning.clickUpdateRBIPlan(testData.getStringValueOfRow("updateRBIPlan"));
        }
        anomalyPlanning.enterComments(testData.getStringValueOfRow("PlanningComments"));
        anomalyPlanning.uploadPlanningDocument();
        if (testData.getStringValueOfRow("cmAnomaliesTab").equalsIgnoreCase("Yes")) {
            uploadFile(properties.getProperty("image.upload"), 1);
        } else {
            uploadFile(properties.getProperty("image.upload"), 2);
        }
        anomalyPlanning.enterDocumentDescription(testData.getStringValueOfRow("planningDocumentDescription"));
        anomalyPlanning.selectDocumentType(testData.getStringValueOfRow("planningDocumentType"));
        anomalyPlanning.clickSaveAndContinue();
    }
}
