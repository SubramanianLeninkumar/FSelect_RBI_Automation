package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditEvent extends BaseTag {

    @FindBy(xpath = "//*[@placeholder='Search by Event Name']")
    WebElement searchEventsElement;
    @FindBy(css = "button.dropdown-toggle.btn.btn-action-dd")
    WebElement actionButtonElement;
    @FindBy(css = "input.sc-ikkyvV.jECmaC")
    List<WebElement> eventElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> DDMElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    WebElement textAreaElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-tertiary.undefined")
    List<WebElement> deleteDocumentElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    WebElement saveElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    WebElement documentDescriptionElement;

    public EditEvent(WebDriver driver) {
        super(driver);
    }

    public void searchEvent(String event) {
        searchEventsElement.click();
        searchEventsElement.sendKeys(event);
        forcedWaitForTwoSeconds();
    }

    public void editEvents() {
        forcedWaitForOneSecond();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,200)", "");
        forcedWaitForOneSecond();
        actionButtonElement.click();
        forcedWaitForOneSecond();
        selectBySpanText("Edit Event");
        forcedWaitForOneSecond();
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
        eventElement.get(4).clear();
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

    public void deleteDocument() {
        try {
            deleteDocumentElement.get(0).click();
            forcedWaitForTwoSeconds();
            okElement.click();
            forcedWaitForTwoSeconds();
        } catch (Exception e) {
            log.error(e);
        }
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
        saveElement.click();
        forcedWaitForTwoSeconds();
        okElement.click();
        forcedWaitForThreeSeconds();
    }
}
