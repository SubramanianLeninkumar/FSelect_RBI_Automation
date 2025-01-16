package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class Anomalies extends BaseTag {

    @FindBy(xpath = "(//a[text()='Anomalies'])[1]")
    WebElement anomaliesElement;
    @FindBy(xpath = "//*[@placeholder='Search by Finding Type,Finding Number or Asset or AnomalyId']")
    WebElement searchAnomalyElement;
    @FindBy(css = "td.pl-3.pr-3")
    List<WebElement> anomalyDetailsElement;
    @FindBy(xpath = "//*[text()='Clear Filters']")
    WebElement clearSearchResultElement;
    @FindBy(xpath = "//*[text()='All']")
    WebElement yearsDropdownElement;
    @FindBy(xpath = "//*[@value='Select Status']")
    WebElement filterElement;
    @FindBy(css = "li.justify-content-between.align-items-center")
    List<WebElement> filterNameElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-outline-default.sc-dAlxHm.gGRFrN.btn-secondary.undefined")
    WebElement downloadElement;

    public Anomalies(WebDriver driver) {
        super(driver);
    }

    public void clickAnomaliesTab() {
        anomaliesElement.click();
        forcedWaitForTwoSeconds();
    }

    public void searchAnomaly(String inspection) {
        searchAnomalyElement.click();
        searchAnomalyElement.sendKeys(inspection);
        forcedWaitForTwoSeconds();
    }

    public void getAnomalyList() {
        // Loop through the inspectionDetailsElement list
        for (int i = 0; i < anomalyDetailsElement.size(); i += 11) {
            try {
                if (i + 9 < anomalyDetailsElement.size()) {
                    Reporter.log("<b>Anomaly ID:</b> " + anomalyDetailsElement.get(i).getText() + "<br>");
                    Reporter.log("<b>Finding Type:</b> " + anomalyDetailsElement.get(i + 1).getText() + "<br>");
                    Reporter.log("<b>Finding Number:</b> " + anomalyDetailsElement.get(i + 2).getText() + "<br>");
                    Reporter.log("<b>Asset:</b> " + anomalyDetailsElement.get(i + 3).getText() + "<br>");
                    Reporter.log("<b>Defect Descriptor:</b> " + anomalyDetailsElement.get(i + 4).getText() + "<br>");
                    Reporter.log("<b>Proposed Actions:</b> " + anomalyDetailsElement.get(i + 5).getText() + "<br>");
                    Reporter.log("<b>Due/Closed Date:</b> " + anomalyDetailsElement.get(i + 6).getText() + "<br>");
                    Reporter.log("<b>Assigned To:</b> " + anomalyDetailsElement.get(i + 7).getText() + "<br>");
                    Reporter.log("<b>Anomaly Status:</b> " + anomalyDetailsElement.get(i + 8).getText() + "<br>");
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
                case "Closed" -> filterNameElement.get(0).click();
                case "In Progress" -> filterNameElement.get(1).click();
                case "New" -> filterNameElement.get(2).click();
                case "Open" -> filterNameElement.get(3).click();
            }
            forcedWaitForOneSecond();
        }
        anomaliesElement.click();
    }

    public void downloadAnomalies() {
        forcedWaitForOneSecond();
        downloadElement.click();
        forcedWaitForThreeSeconds();
    }
}
