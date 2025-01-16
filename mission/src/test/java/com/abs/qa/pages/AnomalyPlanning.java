package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AnomalyPlanning extends BaseTag {

    @FindBy(xpath = "//*[@placeholder='Enter the Assignee']")
    WebElement enterAssigneeElement;
    @FindBy(css = "input.sc-ikkyvV.jECmaC.sc-feUYzb.kdQHb.datePickerInput__datePicker")
    WebElement resolutionDateElement;
    @FindBy(xpath = "//*[@placeholder='Enter the Planned event for Closure']")
    WebElement plannedEventElement;
    @FindBy(css = "label.form-check-label.cpusRadioLabel")
    List<WebElement> yesOrNoElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    List<WebElement> textAreaElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    WebElement documentDescriptionElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    List<WebElement> saveAndContinueButtonElement;


    public AnomalyPlanning(WebDriver driver) {
        super(driver);
    }

    public void enterAssignedTo(String name)  {
        forcedWaitForTwoSeconds();
        enterAssigneeElement.click();
        enterAssigneeElement.sendKeys(name);
        forcedWaitForTwoSeconds();
    }

    public void selectProposedAction(String proposedAction)  {
        forcedWaitForTwoSeconds();
        selectByText("Select Proposed Action ");
        selectByButtonText(proposedAction);
        forcedWaitForTwoSeconds();
    }

    public void enterResolutionDate(String resolutionDate)  {
        waitForElement(resolutionDateElement);
        forcedWaitForTwoSeconds();
        selectByDateText(resolutionDate);
        forcedWaitForOneSecond();
    }

    public void enterPlannedEvent(String event) {
        plannedEventElement.click();
        plannedEventElement.sendKeys(event);
    }

    public void selectRequiredResolution(String resolution)  {
        forcedWaitForTwoSeconds();
        selectByText(resolution);
        forcedWaitForTwoSeconds();
    }

    public void clickChangeOfManagement(String value)  {
        forcedWaitForTwoSeconds();
        switch (value) {
            case "Yes":
                yesOrNoElement.get(0).click();
            case "No":
                yesOrNoElement.get(1).click();
                forcedWaitForTwoSeconds();
        }
    }

    public void clickUpdateRBIPlan(String value)  {
        forcedWaitForTwoSeconds();
        switch (value) {
            case "Yes":
                yesOrNoElement.get(2).click();
            case "No":
                yesOrNoElement.get(3).click();
                forcedWaitForTwoSeconds();
        }
    }

    public void enterComments(String comments) throws InterruptedException {
        forcedWaitForTwoSeconds();
        textAreaElement.get(0).click();
        textAreaElement.get(0).sendKeys(comments);
        forcedWaitForTwoSeconds();
    }

    public void uploadPlanningDocument() {
        waitForElement(uploadFileElement);
    }

    public void enterDocumentDescription(String description) throws InterruptedException {
        forcedWaitForTwoSeconds();
        documentDescriptionElement.click();
        documentDescriptionElement.sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void selectDocumentType(String documentType) throws InterruptedException {
        forcedWaitForTwoSeconds();
        selectByText("Select Type");
        forcedWaitForTwoSeconds();
        selectByButtonText(documentType);
        forcedWaitForTwoSeconds();
    }

    public void clickSaveAndContinue()  {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(1).click();
        forcedWaitForTwoSeconds();
    }
}
