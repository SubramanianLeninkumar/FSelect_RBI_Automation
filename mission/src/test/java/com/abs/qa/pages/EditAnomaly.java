package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class EditAnomaly extends BaseTag {

    @FindBy(xpath = "(//a[text()='Anomalies'])[1]")
    WebElement anomaliesElement;
    @FindBy(xpath = "//input[@placeholder='Search by Finding Type,Finding Number or Asset or AnomalyId']")
    WebElement anomalySearchElement;
    @FindBy(css = "button.dropdown-toggle.btn.btn-action-dd")
    WebElement actionButtonElement;
    @FindBy(xpath = "//*[@value='Select Status']")
    WebElement filterElement;
    @FindBy(css = "li.justify-content-between.align-items-center")
    List<WebElement> filterNameElement;
    @FindBy(xpath = "//*[text()='Anomaly Details']")
    WebElement actionAnomalyDetailsElement;
    @FindBy(css = "div.card.sc-guJBQA.cubKJK.sc-kMkwmO.drJvRW")
    List<WebElement> anomalyDetailsElement;
    @FindBy(xpath = "//*[contains(text(),'Download Attachment')]")
    List<WebElement> downloadAttachmentElement;
    @FindBy(css = "label.form-check-label.without-label")
    List<WebElement> selectAttachmentElement;
    @FindBy(css = "button.btn-close")
    WebElement closeButtonElement;

    public EditAnomaly(WebDriver driver) {
        super(driver);
    }

    public void clickAnomaliesTab(String clickTab, String filterName) {
        if (clickTab.equalsIgnoreCase("Yes")) {
            anomaliesElement.click();
            forcedWaitForTwoSeconds();
            ((JavascriptExecutor) driver).executeScript("window.scroll(0,200)", "");
            forcedWaitForTwoSeconds();
            clickStatusFilter(filterName);
            forcedWaitForTwoSeconds();
        }
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

    public void clickAnomalySearch(String clickTab, String text) {
        if (clickTab.equalsIgnoreCase("NA")) {
            anomalySearchElement.click();
            anomalySearchElement.sendKeys(text);
            forcedWaitForTwoSeconds();
        }
    }

    public void clickAnomalyID(String text) {
        selectByText(text);
        forcedWaitForTwoSeconds();
    }

    public void getAnomalyDetails() {
        for (WebElement details : anomalyDetailsElement) {
            Reporter.log(details.getText() + "\n");
        }
        forcedWaitForTwoSeconds();
    }

    public void clickActionButton() {
        forcedWaitForTwoSeconds();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(1000, 0);");  // Scroll 1000 pixels to the left (negative value scrolls left)
        forcedWaitForTwoSeconds();
        actionButtonElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickActionAnomalyDetails() {
        actionAnomalyDetailsElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickActionDownloadAttachment() {
        downloadAttachmentElement.get(0).click();
        forcedWaitForTwoSeconds();
    }

    public void clickDownloadAttachment() {
        downloadAttachmentElement.get(1).click();
        forcedWaitForTwoSeconds();
    }

    public void selectAttachments(String option) {
        switch (option) {
            case "Select All" -> selectAttachmentElement.get(0).click();
            case "Individual Select" -> {
                for (int i = 1; i < selectAttachmentElement.size(); i++) {
                    selectAttachmentElement.get(i).click();
                }
            }
        }
    }

    public void clickCloseButton() {
        closeButtonElement.click();
        forcedWaitForOneSecond();
    }
}
