package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateInspection extends BaseTag {

    @FindBy(xpath = "(//a[text()='Inspections'])[1]")
    WebElement inspectionsTabElement;
    @FindBy(xpath = "//*[text()='Create Inspection']")
    WebElement createInspectionElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> DDMElement;
    @FindBy(xpath = "//*[@placeholder='Search by Event Name,..']")
    WebElement searchEventNameElement;
    @FindBy(css = "label.form-check-label.without-label")
    WebElement eventNameElement;
    @FindBy(xpath = "//*[@placeholder='Enter Inspection Name..']")
    WebElement inspectionNameElement;
    @FindBy(xpath = "//*[@placeholder='Enter Inspection Place..']")
    WebElement inspectionPlaceElement;
    @FindBy(css = "input.sc-ikkyvV.jECmaC")
    List<WebElement> inspectionDateElement;
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

    public CreateInspection(WebDriver driver) {
        super(driver);
    }

    public void clickInspectionsTab() {
        inspectionsTabElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickCreateInspection() {
        createInspectionElement.click();
        forcedWaitForTwoSeconds();
    }

    public void selectAssetType(String text) {
        DDMElement.get(2).click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void selectAssetName(String text) {
        DDMElement.get(3).click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void searchByEventName(String text) {
        searchEventNameElement.click();
        forcedWaitForOneSecond();
        searchEventNameElement.sendKeys(text);
        forcedWaitForOneSecond();
        eventNameElement.click();
        forcedWaitForTwoSeconds();
    }

    public void selectInspectionType(String text) {
        DDMElement.get(5).click();
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
        DDMElement.get(6).click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void enterInspectionPlace(String text) {
        inspectionPlaceElement.click();
        forcedWaitForOneSecond();
        inspectionPlaceElement.sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    //TODO inspection interval optional

    public void enterStartDate(int i) {
        inspectionDateElement.get(2).click();
        forcedWaitForOneSecond();
        selectDate("from", i);
        forcedWaitForTwoSeconds();
    }

    public void enterEndDate(int j) {
        inspectionDateElement.get(3).click();
        forcedWaitForOneSecond();
        selectDate("to", j);
        forcedWaitForTwoSeconds();
    }

    public void enterComments(String description) {
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
        saveElement.get(0).click();
        forcedWaitForTwoSeconds();
        okElement.click();
        forcedWaitForThreeSeconds();
    }
}
