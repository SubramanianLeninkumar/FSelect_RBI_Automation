package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateEvent extends BaseTag {

    @FindBy(xpath = "//*[text()='Create Event']")
    WebElement createEvent;
    @FindBy(css = "input.sc-ikkyvV.jECmaC")
    List<WebElement> eventElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> DDMElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    WebElement textAreaElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    WebElement documentDescriptionElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    List<WebElement> saveElement;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okElement;

    public CreateEvent(WebDriver driver) {
        super(driver);
    }

    public void clickCreateEvent() {
        createEvent.click();
        forcedWaitForTwoSeconds();
    }

    public void enterEventName(String text) {
        eventElement.get(0).click();
        eventElement.get(0).clear();
        eventElement.get(0).sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    public void selectEventType(String text) {
        DDMElement.get(1).click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void enterStartDate(int i) {
        eventElement.get(1).click();
        forcedWaitForOneSecond();
        selectDate("from", i);
        forcedWaitForTwoSeconds();
    }

    public void enterEndDate(int j) {
        eventElement.get(2).click();
        forcedWaitForOneSecond();
        selectDate("to", j);
        forcedWaitForTwoSeconds();
    }

    public void enterLocation(String text) {
        eventElement.get(4).click();
        forcedWaitForOneSecond();
        eventElement.get(4).sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    public void selectOwner(String text) {
        DDMElement.get(2).click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void enterComments(String description) {
        textAreaElement.clear();
        textAreaElement.click();
        textAreaElement.sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void uploadDocument() {
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

    public void clickSaveButton() {
        forcedWaitForTwoSeconds();
        saveElement.get(1).click();
        forcedWaitForTwoSeconds();
        okElement.click();
        forcedWaitForThreeSeconds();
    }
}
