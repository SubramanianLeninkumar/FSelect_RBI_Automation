package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateEventWithInspection extends BaseTag {

    @FindBy(xpath = "//*[text()='Create Event']")
    WebElement createEvent;
    @FindBy(css = "input.sc-ikkyvV.jECmaC")
    List<WebElement> eventElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> DDMElement;
    @FindBy(xpath = "//*[text()='Create Inspection']")
    WebElement createInspectionElement;
    @FindBy(xpath = "//*[@placeholder='Enter Inspection Name..']")
    WebElement inspectionNameElement;
    @FindBy(xpath = "//*[@placeholder='Enter Inspection Place..']")
    WebElement inspectionPlaceElement;
    @FindBy(css = "input.sc-ikkyvV.jECmaC")
    List<WebElement> inspectionDateElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    List<WebElement> textAreaElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    List<WebElement> uploadFileElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    List<WebElement> documentDescriptionElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    WebElement saveElement;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okElement;

    public CreateEventWithInspection(WebDriver driver) {
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

    public void enterEventStartDate(int i) {
        eventElement.get(1).click();
        forcedWaitForOneSecond();
        selectDate("from", i);
        forcedWaitForTwoSeconds();
    }

    public void enterEventEndDate(int j) {
        eventElement.get(2).click();
        forcedWaitForOneSecond();
        selectDate("to", j);
        forcedWaitForTwoSeconds();
    }

    public void enterEventLocation(String text) {
        eventElement.get(4).click();
        forcedWaitForOneSecond();
        eventElement.get(4).sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    public void selectEventOwner(String text) {
        DDMElement.get(2).click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void enterEventComments(String description) {
        textAreaElement.get(0).clear();
        textAreaElement.get(0).click();
        textAreaElement.get(0).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void uploadEventDocument() {
        waitForElement(uploadFileElement.get(0));
    }

    public void enterEventDocumentDescription(String description) {
        forcedWaitForTwoSeconds();
        documentDescriptionElement.get(0).click();
        documentDescriptionElement.get(0).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void selectEventDocumentType(String documentType) {
        forcedWaitForTwoSeconds();
        selectByText("Select Type");
        forcedWaitForTwoSeconds();
        selectByButtonText(documentType);
        forcedWaitForTwoSeconds();
    }

    public void clickCreateInspection() {
        createInspectionElement.click();
        forcedWaitForTwoSeconds();
    }

    public void selectAssetType(String text) {
        DDMElement.get(4).click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void selectAssetName(String text) {
        DDMElement.get(5).click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void selectInspectionType(String text) {
        DDMElement.get(6).click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void enterInspectionName(String text) {
        inspectionNameElement.click();
        forcedWaitForOneSecond();
        inspectionNameElement.sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    public void selectInspector(String text) {
        DDMElement.get(7).click();
        forcedWaitForOneSecond();
        driver.findElement(By.xpath("(//button[text()='" + text + "'])[2]")).click();
        forcedWaitForTwoSeconds();
    }

    public void enterInspectionPlace(String text) {
        inspectionPlaceElement.click();
        forcedWaitForOneSecond();
        inspectionPlaceElement.sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    //TODO inspection interval optional

    public void enterInspectionStartDate(int i) {
        inspectionDateElement.get(7).click();
        forcedWaitForOneSecond();
        selectDate("from", i);
        forcedWaitForTwoSeconds();
    }

    public void enterInspectionEndDate(int j) {
        inspectionDateElement.get(8).click();
        forcedWaitForOneSecond();
        selectDate("to", j);
        forcedWaitForTwoSeconds();
    }

    public void enterInspectionComments(String description) {
        textAreaElement.get(1).clear();
        textAreaElement.get(1).click();
        textAreaElement.get(1).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void uploadInspectionDocument() {
        waitForElement(uploadFileElement.get(1));
    }

    public void enterInspectionDocumentDescription(String description) {
        forcedWaitForTwoSeconds();
        documentDescriptionElement.get(1).click();
        documentDescriptionElement.get(1).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void selectInspectionDocumentType(String documentType) {
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
