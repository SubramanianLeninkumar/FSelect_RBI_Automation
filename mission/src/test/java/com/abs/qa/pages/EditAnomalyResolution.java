package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditAnomalyResolution extends BaseTag {

    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> DDMElement;
    @FindBy(css = "input.sc-ikkyvV.jECmaC.sc-feUYzb.kdQHb.datePickerInput__datePicker")
    WebElement closedDateElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    WebElement textAreaElement;
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

    public EditAnomalyResolution(WebDriver driver) {
        super(driver);
    }

    public void selectRepairType(String repairType) {
        forcedWaitForTwoSeconds();
        DDMElement.get(2).click();
        selectByText(repairType);
        forcedWaitForTwoSeconds();
    }

    public void selectClosedDate(int i) {
        waitForElement(closedDateElement);
        forcedWaitForOneSecond();
        selectDate("to", i);
        forcedWaitForTwoSeconds();
    }

    public void selectActionTaken(String actionTaken) {
        DDMElement.get(3).click();
        forcedWaitForTwoSeconds();
        selectByButtonText(actionTaken);
        forcedWaitForTwoSeconds();
    }

    public void enterComments(String comments) {
        textAreaElement.click();
        textAreaElement.clear();
        textAreaElement.sendKeys(comments);
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

    public void uploadResolutionDocument() {
        waitForElement(uploadFileElement);
        forcedWaitForTwoSeconds();
    }

    public void enterDocumentDescription(String description) {
        forcedWaitForTwoSeconds();
        documentDescriptionElement.click();
        documentDescriptionElement.clear();
        documentDescriptionElement.sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void selectDocumentType(String documentType) throws InterruptedException {
        forcedWaitForTwoSeconds();
        selectByText("Select Type");
        selectByButtonText(documentType);
        forcedWaitForTwoSeconds();
    }

    public void clickUpdateButton() throws InterruptedException {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(0).click();
        forcedWaitForTwoSeconds();
    }
}
