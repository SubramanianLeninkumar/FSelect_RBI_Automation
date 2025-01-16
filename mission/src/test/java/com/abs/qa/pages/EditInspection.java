package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditInspection extends BaseTag {

    @FindBy(xpath = "(//a[text()='Inspections'])[1]")
    WebElement inspectionsTabElement;
    @FindBy(css = "button.dropdown-toggle.btn.btn-action-dd")
    WebElement actionButtonElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> DDMElement;
    @FindBy(xpath = "//*[@placeholder='Enter Inspection Name..']")
    WebElement inspectionNameElement;
    @FindBy(xpath = "//*[@placeholder='Enter Inspection Place..']")
    WebElement inspectionPlaceElement;
    @FindBy(css = "input.sc-ikkyvV.jECmaC")
    List<WebElement> inspectionDateElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    WebElement textAreaElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-tertiary.undefined")
    WebElement deleteDocumentElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    WebElement documentDescriptionElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    WebElement saveElement;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okElement;

    public EditInspection(WebDriver driver) {
        super(driver);
    }

    public void clickEditInspection() {
        forcedWaitForTwoSeconds();
        inspectionsTabElement.click();
        forcedWaitForTwoSeconds();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,200)", "");
        forcedWaitForOneSecond();
        actionButtonElement.click();
        forcedWaitForOneSecond();
        selectBySpanText("Edit Inspection");
        forcedWaitForOneSecond();
    }

    public void selectAssetType(String manageInspection, String text) {
        if (manageInspection.equalsIgnoreCase("Yes")) {
            DDMElement.get(1).click();
        } else {
            DDMElement.get(2).click();
        }
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void selectAssetName(String manageInspection, String text) {
        if (manageInspection.equalsIgnoreCase("Yes")) {
            DDMElement.get(2).click();
        } else {
            DDMElement.get(3).click();
        }
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void selectInspectionType(String manageInspection, String text) {
        if (manageInspection.equalsIgnoreCase("Yes")) {
            DDMElement.get(3).click();
        } else {
            DDMElement.get(5).click();
        }
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void enterInspectionName(String text) {
        forcedWaitForOneSecond();
        inspectionNameElement.clear();
        inspectionNameElement.click();
        forcedWaitForOneSecond();
        inspectionNameElement.sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    public void selectInspector(String manageInspection, String text) {
        if (manageInspection.equalsIgnoreCase("Yes")) {
            DDMElement.get(4).click();
        } else {
            DDMElement.get(6).click();
        }
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForTwoSeconds();
    }

    public void enterInspectionPlace(String text) {
        forcedWaitForOneSecond();
        inspectionPlaceElement.clear();
        inspectionPlaceElement.click();
        forcedWaitForOneSecond();
        inspectionPlaceElement.sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    //TODO inspection interval optional

    public void enterInspectionStartDate(int i) {
        inspectionDateElement.get(2).click();
        forcedWaitForOneSecond();
        selectDate("from", i);
        forcedWaitForTwoSeconds();
    }

    public void enterInspectionEndDate(int j) {
        inspectionDateElement.get(3).click();
        forcedWaitForOneSecond();
        selectDate("to", j);
        forcedWaitForTwoSeconds();
    }

    public void enterInspectionComments(String description) {
        textAreaElement.clear();
        textAreaElement.click();
        textAreaElement.sendKeys(description);
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

    public void uploadInspectionDocument() {
        waitForElement(uploadFileElement);
    }

    public void enterInspectionDocumentDescription(String description) {
        forcedWaitForTwoSeconds();
        documentDescriptionElement.clear();
        documentDescriptionElement.click();
        documentDescriptionElement.sendKeys(description);
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
