package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class AnomalyAssessmentTest extends BaseClass {

    @Test(priority = 6)
    public void testAnomalyAssessment() throws InterruptedException, IOException {
        anomalyAssessment.selectRiskType(testData.getStringValueOfRow("riskType"));
        anomalyAssessment.selectUnmitigatedLikelihood(testData.getStringValueOfRow("unmitigatedLikelihood"));
        anomalyAssessment.selectUnmitigatedConsequence(testData.getStringValueOfRow("unmitigatedConsequence"));
        anomalyAssessment.enterUnmitigatedDescription(testData.getStringValueOfRow("unmitigatedDescription"));
        anomalyAssessment.selectMitigatedLikelihood(testData.getStringValueOfRow("mitigatedLikelihood"));
        anomalyAssessment.selectMitigatedConsequence(testData.getStringValueOfRow("mitigatedConsequence"));
        anomalyAssessment.enterMitigatedDescription(testData.getStringValueOfRow("mitigatedDescription"));
        anomalyAssessment.selectLikelihoodRanking(testData.getStringValueOfRow("likelihoodRanking"));
        anomalyAssessment.selectConsequenceRanking(testData.getStringValueOfRow("consequenceRanking"));
        anomalyAssessment.enterRankDescription(testData.getStringValueOfRow("rankDescription"));
        anomalyAssessment.clickSaveButton();
        anomalyAssessment.clickOkButton();
        if (testData.getStringValueOfRow("rbiAnomalyCreation").equalsIgnoreCase("Yes")) {
            anomalyAssessment.clickRBISaveButton();
        } else {
            anomalyAssessment.clickCMAnomalySaveButton();
        }
    }
}
