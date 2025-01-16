package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditAnomalyAssessment extends BaseTag {

    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> unmitigatedElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    List<WebElement> textAreaElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    List<WebElement> saveAndContinueButtonElement;

    public EditAnomalyAssessment(WebDriver driver) {
        super(driver);
    }

    public void selectRiskType(String type) {
        forcedWaitForTwoSeconds();
        selectByText(type);
        forcedWaitForTwoSeconds();
    }

    public void selectUnmitigatedLikelihood(String likelihood) {
        forcedWaitForTwoSeconds();
        unmitigatedElement.get(2).click();
        selectByText(likelihood);
        forcedWaitForTwoSeconds();
    }

    public void selectUnmitigatedConsequence(String consequence) {
        forcedWaitForTwoSeconds();
        unmitigatedElement.get(3).click();
        selectByText(consequence);
        forcedWaitForTwoSeconds();
    }

    public void enterUnmitigatedDescription(String description) {
        forcedWaitForTwoSeconds();
        textAreaElement.get(0).click();
        textAreaElement.get(0).clear();
        textAreaElement.get(0).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void selectMitigatedLikelihood(String likelihood) {
        forcedWaitForTwoSeconds();
        unmitigatedElement.get(4).click();
        selectByText(likelihood);
        forcedWaitForTwoSeconds();
    }

    public void selectMitigatedConsequence(String consequence) {
        forcedWaitForTwoSeconds();
        unmitigatedElement.get(5).click();
        selectByText(consequence);
        forcedWaitForTwoSeconds();
    }

    public void enterMitigatedDescription(String description) {
        forcedWaitForTwoSeconds();
        textAreaElement.get(1).click();
        textAreaElement.get(1).clear();
        textAreaElement.get(1).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void selectLikelihoodRanking(String description) {
        forcedWaitForTwoSeconds();
        unmitigatedElement.get(6).click();
        selectByText(description);
        forcedWaitForTwoSeconds();
    }

    public void selectConsequenceRanking(String description) {
        forcedWaitForTwoSeconds();
        unmitigatedElement.get(7).click();
        selectByText(description);
        forcedWaitForTwoSeconds();
    }

    public void enterRankDescription(String description) {
        forcedWaitForTwoSeconds();
        textAreaElement.get(2).click();
        textAreaElement.get(2).clear();
        textAreaElement.get(2).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void clickUpdateButton() {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(0).click();
        forcedWaitForTwoSeconds();
    }

    public void clickContinueButton() {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(1).click();
        forcedWaitForTwoSeconds();
    }

    public void clickOkButton() {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(2).click();
        forcedWaitForTwoSeconds();
    }
}
