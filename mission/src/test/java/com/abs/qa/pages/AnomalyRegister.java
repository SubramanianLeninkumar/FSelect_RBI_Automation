package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class AnomalyRegister extends BaseTag {

    @FindBy(xpath = "//input[@placeholder='Search by Finding Type,Finding Number or Asset or AnomalyId']")
    WebElement anomalySearchElement;
    @FindBy(css = "td.pl-3.pr-3")
    List<WebElement> anomalyDetailsElement;
    @FindBy(xpath = "//*[text()='Clear Filters']")
    WebElement clearSearchResultElement;
    @FindBy(xpath = "//*[text()='All']")
    WebElement yearsDropdownElement;
    @FindBy(xpath = "//input[@value='Select Status']")
    WebElement statusDropdownElement;
    @FindBy(xpath = "(//*[@context='[object Object]'])[1]")
    WebElement selectClosedStatusElement;
    @FindBy(xpath = "(//*[@context='[object Object]'])[2]")
    WebElement selectNewStatusElement;
    @FindBy(xpath = "(//*[@context='[object Object]'])[3]")
    WebElement selectOpenStatusElement;
    @FindBy(xpath = "//button[text()='Download Template']")
    WebElement downloadTemplateElement;
    @FindBy(xpath = "//button[text()='Import Anomaly']")
    WebElement importAnomalyElement;

    public AnomalyRegister(WebDriver driver) {
        super(driver);
    }

    public void clickAnomalySearch(String text) {
        anomalySearchElement.click();
        anomalySearchElement.sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    public void clickClearSearchResult() {
        clearSearchResultElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickYearsDropdown(String year) {
        yearsDropdownElement.click();
        forcedWaitForTwoSeconds();
        selectByText(year);
        forcedWaitForOneSecond();
    }

    public void selectStatus(String status) {
        statusDropdownElement.click();
        forcedWaitForTwoSeconds();
        String[] statusOption = status.split(",");
        for (String option : statusOption) {
            switch (option) {
                case "Closed" -> selectClosedStatusElement.click();
                case "New" -> selectNewStatusElement.click();
                case "Open" -> selectOpenStatusElement.click();
            }
        }
    }

    public void clickDownloadTemplate()  {
        downloadTemplateElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickImportAnomalyTemplate() {
        importAnomalyElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickCloseButton() {
        selectByButtonText("Close");
        forcedWaitForTwoSeconds();
    }

    public void getAnomalyList() {
        // Each anomaly consists of 11 elements, so increment i by 11 in each iteration
        for (int i = 0; i < anomalyDetailsElement.size(); i += 12) {
            // Ensure that the list has at least 11 elements left to access
            if (i + 10 < anomalyDetailsElement.size()) {
                Reporter.log("<b>Anomaly ID:</b>" + anomalyDetailsElement.get(i).getText() + "<br>");
                Reporter.log("<b>Finding Type:</b>" + anomalyDetailsElement.get(i + 1).getText() + "<br>");
                Reporter.log("<b>Finding Number:</b>" + anomalyDetailsElement.get(i + 2).getText() + "<br>");
                Reporter.log("<b>Location:</b>" + anomalyDetailsElement.get(i + 3).getText() + "<br>");
                Reporter.log("<b>Asset:</b>" + anomalyDetailsElement.get(i + 4).getText() + "<br>");
                Reporter.log("<b>Affected Item:</b>" + anomalyDetailsElement.get(i + 5).getText() + "<br>");
                Reporter.log("<b>Defect Descriptor:</b>" + anomalyDetailsElement.get(i + 6).getText() + "<br>");
                Reporter.log("<b>Anomaly Description:</b>" + anomalyDetailsElement.get(i + 7).getText() + "<br>");
                Reporter.log("<b>Proposed Actions:</b>" + anomalyDetailsElement.get(i + 8).getText() + "<br>");
                Reporter.log("<b>Due/Closed Date:</b>" + anomalyDetailsElement.get(i + 9).getText() + "<br>");
                Reporter.log("<b>Anomaly Status:</b>" + anomalyDetailsElement.get(i + 10).getText() + "<br>");
            } else {
                // Log a message or handle the case where the list is incomplete
                Reporter.log("Insufficient elements to extract anomaly details starting at index " + i + "<br>");
            }
        }
    }
}

