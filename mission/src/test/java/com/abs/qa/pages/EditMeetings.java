package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditMeetings extends BaseTag {

    @FindBy(css = "button.dropdown-toggle.btn.btn-action-dd")
    List<WebElement> actionButtonElement;
    @FindBy(xpath = "//*[text()='Edit Meeting']")
    WebElement editMeetingElement;
    @FindBy(xpath = "//*[@placeholder='Enter Meeting Name']")
    WebElement meetingNameElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> meetingTypeElement;
    @FindBy(css = "input.sc-ikkyvV.jECmaC.sc-feUYzb.kdQHb.datePickerInput__datePicker")
    WebElement dateElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    WebElement descriptionElement;
    @FindBy(css = "div.d-flex.justify-content-center")
    List<WebElement> deleteDocumentElement;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(id = "0-description")
    WebElement docDescElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    WebElement updateButtonElement;

    public EditMeetings(WebDriver driver) {
        super(driver);
    }

    public void clickMeetingAction() {
        forcedWaitForThreeSeconds();
        actionButtonElement.get(0).click();
    }

    public void clickEditMeeting() {
        forcedWaitForTwoSeconds();
        editMeetingElement.click();
        forcedWaitForThreeSeconds();
    }

    public void enterMeetingName(String name) {
        forcedWaitForTwoSeconds();
        meetingNameElement.clear();
        meetingNameElement.sendKeys(name);
        forcedWaitForThreeSeconds();
    }

    public void selectMeetingType(String type) {
        meetingTypeElement.get(1).click();
        selectByButtonText(type);
    }

    public void enterMeetingDate(String date) {
        forcedWaitForTwoSeconds();
        dateElement.click();
        selectByDateText(date);
        forcedWaitForThreeSeconds();
    }

    public void enterDescription(String description) {
        waitForElement(descriptionElement);
        descriptionElement.clear();
        descriptionElement.sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void deleteDocument() {
        try {
            deleteDocumentElement.get(2).click();
            forcedWaitForTwoSeconds();
            okElement.click();
            forcedWaitForTwoSeconds();
        } catch (NoSuchElementException e) {
            log.error(e);
        }
    }

    public void uploadMeetingDocument() {
        waitForElement(uploadFileElement);
    }

    public void documentDescription(String docDesc, String docType) {
        docDescElement.sendKeys(docDesc);
        selectByText("Select Type");
        forcedWaitForOneSecond();
        selectByButtonText(docType);
        forcedWaitForOneSecond();
    }

    public void selectChecklist(String checklist) {
        selectByText(checklist);
        forcedWaitForTwoSeconds();
    }

    public void clickUpdateButton() throws InterruptedException {
        updateButtonElement.click();
        forcedWaitForThreeSeconds();
    }

}
