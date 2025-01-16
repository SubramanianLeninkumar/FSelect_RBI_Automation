package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActionPlan extends BaseTag {

    @FindBy(xpath = "(//*[text()='Action Plan'])[1]")
    WebElement actionMenuElement;
    @FindBy(xpath = "//*[text()='Findings']")
    WebElement findingsElement;
    @FindBy(xpath = "//*[@placeholder='Search by Survey Name']")
    WebElement searchSurveyNameElement;
    @FindBy(xpath = "//*[@placeholder='Search by Asset Name, Inspection Name, Criticality']")
    WebElement searchSSIElement;
    @FindBy(xpath = "//*[@value='Select Finding Status']")
    WebElement findingStatusElement;
    @FindBy(xpath = "//*[@placeholder='Search by Comment No, Project No']")
    WebElement searchEngineeringCommentsElement;
    @FindBy(css = "input.sc-ikkyvV.jECmaC.sc-feUYzb.kdQHb.datePickerInput__datePicker")
    WebElement selectDateElement;
    @FindBy(xpath = "//button[@id='icon-index-0']")
    WebElement actionElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-tertiary.undefined")
    List<WebElement> deleteDocumentElement;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okElement;
    @FindBy(xpath = "//*[@placeholder='Enter']")
    WebElement enterActionItemElement;
    @FindBy(xpath = "//*[@placeholder='DD-MMM-YYYY']")
    List<WebElement> dateElement;
    @FindBy(xpath = "//*[@placeholder='Enter Comments']")
    WebElement commentsElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    WebElement documentDescriptionElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    List<WebElement> saveAndContinueButtonElement;
    @FindBy(xpath = "//input[@value='Select Action Plan Status']")
    WebElement actionPlanStatusDropdownElement;
    @FindBy(xpath = "//*[text()='Export Action Plan']")
    WebElement exportElement;
    @FindBy(xpath = "//*[text()='Import Action Plan']")
    WebElement importActionPlanElement;

    public ActionPlan(WebDriver driver) {
        super(driver);
    }

    public void clickActionPlanMenu() {
        actionMenuElement.click();
        forcedWaitForTwoSeconds();
    }

    public void selectActionPlan(String option, String text) throws InterruptedException {
        switch (option) {
            case "Surveys" -> {
                forcedWaitForTwoSeconds();
                searchSurveyNameElement.click();
                forcedWaitForTwoSeconds();
                searchSurveyNameElement.sendKeys(text);
                forcedWaitForTwoSeconds();
            }
            case "SSI" -> {
                Thread.sleep(10000);
                selectByText("SSI");
                forcedWaitForTwoSeconds();
                searchSSIElement.click();
                forcedWaitForTwoSeconds();
                searchSSIElement.sendKeys(text);
                forcedWaitForTwoSeconds();
            }
            case "Findings" -> {
                forcedWaitForThreeSeconds();
                findingsElement.click();
                forcedWaitForThreeSeconds();
                findingStatusElement.click();
                forcedWaitForTwoSeconds();
                selectByText("Open");
                forcedWaitForThreeSeconds();
            }
            case "Engineering Comments" -> {
                forcedWaitForThreeSeconds();
                selectByText("Engineering Comments");
                forcedWaitForTwoSeconds();
                searchEngineeringCommentsElement.click();
                forcedWaitForTwoSeconds();
                searchEngineeringCommentsElement.sendKeys(text);
                forcedWaitForTwoSeconds();
            }
        }
        forcedWaitForTwoSeconds();
    }

    public void selectActionPlanStatus(String text) {
        actionPlanStatusDropdownElement.click();
        forcedWaitForOneSecond();
        selectByText(text);
        forcedWaitForTwoSeconds();
    }

    public void clickActionButton() {
        forcedWaitForTwoSeconds();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", actionElement);
        forcedWaitForTwoSeconds();
        scrollUp();
        forcedWaitForThreeSeconds();
        actionElement.click();
        forcedWaitForThreeSeconds();
        selectActionType();
        forcedWaitForTwoSeconds();
    }

    public void selectActionType() {
        try {
            forcedWaitForTwoSeconds();
            selectByText("Edit Action Plan");
            forcedWaitForTwoSeconds();
        } catch (NoSuchElementException e) {
            log.error(e);
        }
        try {
            forcedWaitForTwoSeconds();
            selectByText("Create Action Plan");
            forcedWaitForTwoSeconds();
        } catch (NoSuchElementException e) {
            log.error(e);
        }
    }

    public void selectDueDate(int i) {
        selectDateElement.click();
        forcedWaitForTwoSeconds();
        selectDate("to", i);
    }

    public void deleteActionItem() {
        try {
            deleteDocumentElement.get(0).click();
            forcedWaitForTwoSeconds();
            okElement.click();
            forcedWaitForTwoSeconds();
        } catch (Exception e) {
            log.error(e);
        }
    }

    public void clickAddActionItem() {
        selectByText("Add Action Item");
        forcedWaitForTwoSeconds();
    }

    public void enterActionItem(String text) {
        enterActionItemElement.click();
        forcedWaitForTwoSeconds();
        enterActionItemElement.sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    public void enterStartDate(int i) {
        dateElement.get(0).click();
        forcedWaitForTwoSeconds();
        selectDate("from", i);
        forcedWaitForTwoSeconds();
    }

    public void enterEndDate(int j) {
        dateElement.get(1).click();
        forcedWaitForTwoSeconds();
        selectDate("to", j);
        forcedWaitForTwoSeconds();
    }

    public void enterComments(String comments) throws InterruptedException {
        commentsElement.clear();
        forcedWaitForTwoSeconds();
        commentsElement.sendKeys(comments);
        forcedWaitForTwoSeconds();
    }

    public void deleteActionPlanDocument() {
        try {
            deleteDocumentElement.get(1).click();
            forcedWaitForTwoSeconds();
            okElement.click();
            forcedWaitForTwoSeconds();
        } catch (Exception e) {
            log.error(e);
        }
    }

    public void uploadActionPlanDocument() {
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
        forcedWaitForThreeSeconds();
        okElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickExportPlanAction() {
        exportElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickImportPlanAction() {
        importActionPlanElement.click();
        forcedWaitForTwoSeconds();
    }
}
