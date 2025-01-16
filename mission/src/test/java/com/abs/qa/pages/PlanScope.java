package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PlanScope extends BaseTag {

    @FindBy(xpath = "//input[@placeholder='Search by Part Name,Inspection Type or Part of']")
    WebElement planScopeSearchBoxElement;
    @FindBy(xpath = "//*[text()='Clear Filters']")
    WebElement clearSearchBoxElement;
    @FindBy(xpath = "(//*[@class='form-check'])[1]")
    WebElement selectRecords;
    @FindBy(xpath = "//*[text()='Bulk Update']")
    WebElement bulkUpdate;
    @FindBy(xpath = "//*[text()='Cancel']")
    WebElement bulkUpdateCancel;
    @FindBy(xpath = "//*[text()='Save']")
    WebElement bulkUpdateSave;
    @FindBy(xpath = "//*[text()='OK']")
    WebElement alertOK;
    @FindBy(xpath = "//input[@id='CP_INPUT_id2']")
    WebElement RBIDueDate;
    @FindBy(xpath = "//input[@id='CP_INPUT_id3']")
    WebElement RBIDoneDate;
    @FindBy(xpath = "//input[@id='CP_INPUT_id4']")
    WebElement RBIExtendedDate;
    @FindBy(xpath = "//*[text()='Confirm']")
    WebElement confirmDates;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> dueAndYearDropDownElement;
    @FindBy(xpath = "//input[@value='Select Program']")
    WebElement programDropdownElement;
    @FindBy(xpath = "(//span[text()='RBI'])[2]")
    WebElement selectRBIElement;
    @FindBy(xpath = "//input[@value='Select Survey']")
    WebElement surveyDropdownElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-outline-default.sc-dAlxHm.gGRFrN.btn-secondary.undefined")
    WebElement downloadPlanListElement;

    public PlanScope(WebDriver driver) {
        super(driver);
    }

    public void searchPlanScope(String name)  {
        planScopeSearchBoxElement.sendKeys(name);
        forcedWaitForTwoSeconds();
        clearSearchBoxElement.click();
        forcedWaitForTwoSeconds();
    }

    public void dateBulkUpdate()  {
        forcedWaitForOneSecond();
        bulkUpdate.click();
        forcedWaitForOneSecond();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,100)", "");
        forcedWaitForOneSecond();
        bulkUpdateSave.click();
        forcedWaitForOneSecond();
        alertOK.click();
        bulkUpdateCancel.click();
        forcedWaitForOneSecond();
    }

    public void selectRecordsAndBulkUpdate()  {
        selectRecords.click();
        forcedWaitForOneSecond();
        bulkUpdate.click();
        forcedWaitForOneSecond();
        bulkUpdateSave.click();
        forcedWaitForOneSecond();
    }

    public void selectRBIDueDate()  {
        RBIDueDate.click();
        forcedWaitForOneSecond();
        selectByDateText("20");
        forcedWaitForOneSecond();
    }

    public void selectRBIDoneDate()  {
        RBIDoneDate.click();
        forcedWaitForOneSecond();
        selectByDateText("21");
        forcedWaitForOneSecond();
    }

    public void selectRBIExtendedDate()  {
        RBIExtendedDate.click();
        forcedWaitForOneSecond();
        selectByDateText("22");
        forcedWaitForOneSecond();
    }

    public void saveBulkUpdate() throws InterruptedException {
        bulkUpdateSave.click();
        forcedWaitForOneSecond();
        confirmDates.click();
        Thread.sleep(9000);
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,-300)", "");
        forcedWaitForOneSecond();
        selectRecords.click();
        forcedWaitForTwoSeconds();
    }

    public void selectDueDropDown(String due)  {
        dueAndYearDropDownElement.get(0).click();
        forcedWaitForOneSecond();
        selectByText(due);
        forcedWaitForOneSecond();
    }

    public void selectYearDropDown(String year)  {
        dueAndYearDropDownElement.get(1).click();
        forcedWaitForOneSecond();
        selectByText(year);
        forcedWaitForOneSecond();
    }

    public void selectProgram(String text)  {
        programDropdownElement.click();
        forcedWaitForOneSecond();
        switch (text) {
            case "RBI" -> selectRBIElement.click();
            case "Not Specified", "N/A" -> selectBySpanText(text);
        }
        forcedWaitForTwoSeconds();
    }

    public void selectSurvey(String survey)  {
        surveyDropdownElement.click();
        forcedWaitForOneSecond();
        selectByText(survey);
        forcedWaitForTwoSeconds();
    }

    public void downloadPlanScope()  {
        downloadPlanListElement.click();
        forcedWaitForThreeSeconds();
    }
}
