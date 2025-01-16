package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditAnomalyPlanning extends BaseTag {

    @FindBy(xpath = "//*[@placeholder='Enter the Assignee']")
    WebElement enterAssigneeElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> DDMElement;
    @FindBy(css = "input.sc-ikkyvV.jECmaC.sc-feUYzb.kdQHb.datePickerInput__datePicker")
    WebElement resolutionDateElement;
    @FindBy(xpath = "//*[@placeholder='Enter the Planned event for Closure']")
    WebElement plannedEventElement;
    @FindBy(css = "label.form-check-label.cpusRadioLabel")
    List<WebElement> yesOrNoElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    List<WebElement> textAreaElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-tertiary.undefined")
    WebElement deleteDocumentElement;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    WebElement documentDescriptionElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    List<WebElement> saveAndContinueButtonElement;

    public EditAnomalyPlanning(WebDriver driver) {
        super(driver);
    }

    public void enterAssignedTo(String name) {
        forcedWaitForTwoSeconds();
        enterAssigneeElement.click();
        enterAssigneeElement.clear();
        enterAssigneeElement.sendKeys(name);
        forcedWaitForTwoSeconds();
    }

    public void selectProposedAction(String proposedAction) {
        forcedWaitForTwoSeconds();
        DDMElement.get(2).click();
        selectByButtonText(proposedAction);
        forcedWaitForTwoSeconds();
    }

    public void enterResolutionDate(String resolutionDate) {
        waitForElement(resolutionDateElement);
        forcedWaitForTwoSeconds();
        selectByDateText(resolutionDate);
        forcedWaitForTwoSeconds();
    }

    public void enterPlannedEvent(String event) {
        plannedEventElement.click();
        plannedEventElement.clear();
        plannedEventElement.sendKeys(event);
        forcedWaitForTwoSeconds();
    }

    public void selectRequiredResolution(String resolution) {
        if (!resolution.equalsIgnoreCase("NA")) {
            forcedWaitForTwoSeconds();
            selectByText(resolution);
            forcedWaitForTwoSeconds();
        }
    }

    public void clickChangeOfManagement(String value) {
        if (!value.equalsIgnoreCase("NA")) {
            forcedWaitForTwoSeconds();
            switch (value) {
                case "Yes":
                    yesOrNoElement.get(0).click();
                case "No":
                    yesOrNoElement.get(1).click();
                    forcedWaitForTwoSeconds();
            }
        }
    }

    public void clickUpdateRBIPlan(String value) {
        if (!value.equalsIgnoreCase("NA")) {
            forcedWaitForTwoSeconds();
            switch (value) {
                case "Yes":
                    yesOrNoElement.get(2).click();
                case "No":
                    yesOrNoElement.get(3).click();
                    forcedWaitForTwoSeconds();
            }
        }
    }

    public void enterComments(String comments) {
        forcedWaitForTwoSeconds();
        textAreaElement.get(0).click();
        textAreaElement.get(0).clear();
        textAreaElement.get(0).sendKeys(comments);
        forcedWaitForTwoSeconds();
    }

    public void deleteDocument() {
        try {
            deleteDocumentElement.click();
            forcedWaitForTwoSeconds();
            okElement.click();
            forcedWaitForTwoSeconds();
        } catch (Exception e) {
            log.error(e);
        }
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

    public void clickUpdateButton() throws InterruptedException {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(0).click();
        forcedWaitForTwoSeconds();
    }

    public void clickOkButton() throws InterruptedException {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(2).click();
        forcedWaitForTwoSeconds();
    }

    public void clickContinueButton() {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(1).click();
        forcedWaitForTwoSeconds();
    }
}
