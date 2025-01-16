package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class Inspection extends BaseTag {

    @FindBy(xpath = "(//a[text()='Inspections'])[1]")
    WebElement inspectionsTabElement;
    @FindBy(xpath = "//*[@placeholder='Search by  Inspection ID, Inspection Name, Item Name, Inspection Type']")
    WebElement searchInspectionElement;
    @FindBy(css = "td.pl-3.pr-3")
    List<WebElement> inspectionListElement;
    @FindBy(xpath = "//*[text()='Clear Filters']")
    WebElement clearSearchResultElement;
    @FindBy(xpath = "//*[text()='All']")
    WebElement yearsDropdownElement;
    @FindBy(xpath = "//*[@value='Select by Status']")
    WebElement filterElement;
    @FindBy(css = "li.justify-content-between.align-items-center")
    List<WebElement> filterNameElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-outline-default.sc-dAlxHm.gGRFrN.btn-secondary.undefined")
    WebElement downloadElement;
    @FindBy(css = "button.dropdown-toggle.btn.btn-action-dd")
    WebElement actionButtonElement;
    @FindBy(css = "div.col-md-12")
    List<WebElement> inspectionDetailsElement;

    public Inspection(WebDriver driver) {
        super(driver);
    }

    public void clickInspectionsTab() {
        forcedWaitForTwoSeconds();
        inspectionsTabElement.click();
        forcedWaitForTwoSeconds();
    }

    public void searchInspection(String inspection) {
        searchInspectionElement.click();
        searchInspectionElement.sendKeys(inspection);
        forcedWaitForTwoSeconds();
    }

    public void getInspectionList() {
        // Loop through the inspectionDetailsElement list
        for (int i = 0; i < inspectionListElement.size(); i += 14) {
            try {
                if (i + 10 < inspectionListElement.size()) {
                    Reporter.log("<b>Inspection ID:</b> " + inspectionListElement.get(i).getText() + "<br>");
                    Reporter.log("<b>Inspection Name:</b> " + inspectionListElement.get(i + 1).getText() + "<br>");
                    Reporter.log("<b>Item Name:</b> " + inspectionListElement.get(i + 2).getText() + "<br>");
                    Reporter.log("<b>Inspection Type:</b> " + inspectionListElement.get(i + 3).getText() + "<br>");
                    Reporter.log("<b>Scheduled Date:</b> " + inspectionListElement.get(i + 4).getText() + "<br>");
                    Reporter.log("<b>Inspection Date:</b> " + inspectionListElement.get(i + 5).getText() + "<br>");
                    Reporter.log("<b>Inspection Status:</b> " + inspectionListElement.get(i + 6).getText() + "<br>");
                    Reporter.log("<b>Location:</b> " + inspectionListElement.get(i + 7).getText() + "<br>");
                    Reporter.log("<b>Assigned To:</b> " + inspectionListElement.get(i + 8).getText() + "<br>");
                    Reporter.log("<b>Associated Event:</b> " + inspectionListElement.get(i + 9).getText() + "<br>");
                    forcedWaitForTwoSeconds();
                } else {
                    Reporter.log("Skipping incomplete set of elements at index: " + i + "<br>");
                }
            } catch (Exception e) {
                Reporter.log("Error processing element at index: " + i + ". Exception: " + e.getMessage() + "<br>");
            }
        }
    }

    public void clickClearSearchResult() {
        clearSearchResultElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickDaysFilter(String year) {
        yearsDropdownElement.click();
        forcedWaitForTwoSeconds();
        selectByText(year);
        forcedWaitForOneSecond();
    }

    public void clickStatusFilter(String filterName) {
        forcedWaitForTwoSeconds();
        filterElement.click();
        forcedWaitForOneSecond();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,200)", "");
        forcedWaitForTwoSeconds();
        String[] filters = filterName.split(",");
        for (String filter : filters) {
            switch (filter) {
                case "Approved" -> filterNameElement.get(0).click();
                case "Created" -> filterNameElement.get(1).click();
                case "Deleted" -> filterNameElement.get(2).click();
                case "New" -> filterNameElement.get(3).click();
                case "Open" -> filterNameElement.get(4).click();
                case "Revised" -> filterNameElement.get(5).click();
                case "Submitted" -> filterNameElement.get(6).click();
            }
            forcedWaitForOneSecond();
        }
        inspectionsTabElement.click();
    }

    public void downloadInspections() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(1750, 0);");
        forcedWaitForOneSecond();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(1750, 0);");
        forcedWaitForOneSecond();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,200)", "");
        forcedWaitForOneSecond();
        downloadElement.click();
        forcedWaitForThreeSeconds();
    }

    public void viewDetails() {
        forcedWaitForOneSecond();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,200)", "");
        forcedWaitForOneSecond();
        actionButtonElement.click();
        forcedWaitForOneSecond();
        selectBySpanText("View Details");
        forcedWaitForOneSecond();
    }

    public void getViewDetails() {
        Reporter.log("<b>Asset Information:</b><br>");
        Reporter.log(inspectionDetailsElement.get(5).getText() + "<br>");
        Reporter.log("<b>Inspection Information:</b><br>");
        Reporter.log(inspectionDetailsElement.get(7).getText() + "<br>");
        Reporter.log("<b>Planned Event(s):</b><br>");
        Reporter.log(inspectionDetailsElement.get(10).getText() + "<br>");
        Reporter.log("<b>Inspection Data:</b><br>");
        Reporter.log(inspectionDetailsElement.get(12).getText() + "<br>");
        Reporter.log("<b>Attachments:</b><br>");
        Reporter.log(inspectionDetailsElement.get(15).getText() + "<br>");
        Reporter.log("<b>Change Log:</b><br>");
        Reporter.log(inspectionDetailsElement.get(17).getText() + "<br>");
        forcedWaitForThreeSeconds();
    }

    public void deleteInspection() {
        forcedWaitForOneSecond();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,200)", "");
        forcedWaitForOneSecond();
        actionButtonElement.click();
        forcedWaitForOneSecond();
        selectBySpanText("Delete Inspection");
        forcedWaitForOneSecond();
        selectByButtonText("Ok");
        forcedWaitForThreeSeconds();
    }
}
