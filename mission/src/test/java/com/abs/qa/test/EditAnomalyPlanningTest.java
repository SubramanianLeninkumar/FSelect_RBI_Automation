package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EditAnomalyPlanningTest extends BaseClass {

    @Test(priority = 11)
    public void testEditAnomalyPlanning() throws IOException, InterruptedException {
        editAnomalyPlanning.enterAssignedTo(testData.getStringValueOfRow("assignedTo"));
        editAnomalyPlanning.selectProposedAction(testData.getStringValueOfRow("proposedAction"));
        editAnomalyPlanning.enterResolutionDate(String.valueOf(testData.getNumericValueOfRow("resolutionDate")));
        editAnomalyPlanning.enterPlannedEvent(testData.getStringValueOfRow("plannedEvent"));
        editAnomalyPlanning.selectRequiredResolution(testData.getStringValueOfRow("requiredResolution"));
        editAnomalyPlanning.clickChangeOfManagement(testData.getStringValueOfRow("changeOfManagement"));
        editAnomalyPlanning.clickUpdateRBIPlan(testData.getStringValueOfRow("updateRBIPlan"));
        editAnomalyPlanning.enterComments(testData.getStringValueOfRow("PlanningComments"));
        editAnomalyPlanning.deleteDocument();
        forcedWaitForTwoSeconds();
        editAnomalyPlanning.uploadPlanningDocument();
        if (testData.getStringValueOfRow("cmAnomaliesTab").equalsIgnoreCase("Yes")) {
            uploadFile(properties.getProperty("image.upload"), 1);
        } else {
            uploadFile(properties.getProperty("image.upload"), 2);
        }
        editAnomalyPlanning.enterDocumentDescription(testData.getStringValueOfRow("planningDocumentDescription"));
        editAnomalyPlanning.selectDocumentType(testData.getStringValueOfRow("planningDocumentType"));
        editAnomalyPlanning.clickUpdateButton();
        editAnomalyPlanning.clickOkButton();
        editAnomalyPlanning.clickContinueButton();
    }
}
