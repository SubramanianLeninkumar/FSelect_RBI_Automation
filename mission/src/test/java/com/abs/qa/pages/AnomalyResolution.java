package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AnomalyResolution extends BaseTag {

    @FindBy(css = "input.sc-ikkyvV.jECmaC.sc-feUYzb.kdQHb.datePickerInput__datePicker")
    WebElement closedDateElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    WebElement textAreaElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    WebElement documentDescriptionElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    List<WebElement> saveAndContinueButtonElement;

    public AnomalyResolution(WebDriver driver) {
        super(driver);
    }

    public void selectRepairType(String repairType)  {
        forcedWaitForTwoSeconds();
        selectByText("Select Repair Type ");
        selectByText(repairType);
        forcedWaitForTwoSeconds();
    }

    public void selectClosedDate(String date)  {
        waitForElement(closedDateElement);
        forcedWaitForOneSecond();
        selectByDateText(date);
        forcedWaitForTwoSeconds();
    }

    public void selectActionTaken(String actionTaken)  {
        selectByText("Select Action taken ");
        forcedWaitForTwoSeconds();
        selectByButtonText(actionTaken);
        forcedWaitForTwoSeconds();
    }

    public void enterComments(String comments) throws InterruptedException {
        textAreaElement.click();
        textAreaElement.sendKeys(comments);
        forcedWaitForTwoSeconds();
    }

    public void uploadResolutionDocument()  {
        waitForElement(uploadFileElement);
        forcedWaitForTwoSeconds();
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
        selectByButtonText(documentType);
        forcedWaitForTwoSeconds();
    }

    public void clickSaveButton()  {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(0).click();
        forcedWaitForTwoSeconds();
    }
}
