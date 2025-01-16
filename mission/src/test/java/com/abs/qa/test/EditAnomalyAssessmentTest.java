package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class EditAnomalyAssessmentTest extends BaseClass {

    @Test(priority = 10)
    public void testEditAnomalyAssessment() throws IOException {
        //TODO : Add Test Case if checkbox is not checked for risk type
        editAnomalyAssessment.selectUnmitigatedLikelihood(testData.getStringValueOfRow("unmitigatedLikelihood"));
        editAnomalyAssessment.selectUnmitigatedConsequence(testData.getStringValueOfRow("unmitigatedConsequence"));
        editAnomalyAssessment.enterUnmitigatedDescription(testData.getStringValueOfRow("unmitigatedDescription"));
        editAnomalyAssessment.selectMitigatedLikelihood(testData.getStringValueOfRow("mitigatedLikelihood"));
        editAnomalyAssessment.selectMitigatedConsequence(testData.getStringValueOfRow("mitigatedConsequence"));
        editAnomalyAssessment.enterMitigatedDescription(testData.getStringValueOfRow("mitigatedDescription"));
        editAnomalyAssessment.selectLikelihoodRanking(testData.getStringValueOfRow("likelihoodRanking"));
        editAnomalyAssessment.selectConsequenceRanking(testData.getStringValueOfRow("consequenceRanking"));
        editAnomalyAssessment.enterRankDescription(testData.getStringValueOfRow("rankDescription"));
        editAnomalyAssessment.clickUpdateButton();
        editAnomalyAssessment.clickOkButton();
        editAnomalyAssessment.clickContinueButton();
    }
}
