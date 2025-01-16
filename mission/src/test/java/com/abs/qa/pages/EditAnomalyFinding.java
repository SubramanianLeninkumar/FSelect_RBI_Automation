package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditAnomalyFinding extends BaseTag {

    @FindBy(xpath = "(//a[text()='Anomalies'])[1]")
    WebElement anomaliesElement;
    @FindBy(xpath = "//input[@placeholder='Search by Finding Type,Finding Number or Asset or AnomalyId']")
    WebElement anomalySearchElement;
    @FindBy(xpath = "//*[@value='Select Status']")
    WebElement filterElement;
    @FindBy(css = "li.justify-content-between.align-items-center")
    List<WebElement> filterNameElement;
    @FindBy(css = "button.dropdown-toggle.btn.btn-action-dd")
    WebElement actionButtonElement;
    @FindBy(xpath = "//*[text()='Anomaly Details']")
    WebElement actionAnomalyDetailsElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> DDMElement;
    @FindBy(css = "input.select-dropdown")
    List<WebElement> selectDDMElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    WebElement documentDescriptionElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    List<WebElement> textAreaElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-tertiary.undefined")
    WebElement deleteDocumentElement;
    @FindBy(xpath = "//*[text()='Ok']")
    WebElement okElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    List<WebElement> saveAndContinueButtonElement;

    public EditAnomalyFinding(WebDriver driver) {
        super(driver);
    }

    public void clickAnomaliesTab(String clickTab,String filterName) {
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

    public void anomalySearch(String clickTab, String text) {
        if (clickTab.equalsIgnoreCase("NA")) {
            anomalySearchElement.click();
            anomalySearchElement.sendKeys(text);
            forcedWaitForTwoSeconds();
        }
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

    public void selectCriteria(String criteria) {
        DDMElement.get(2).click();
        forcedWaitForTwoSeconds();
        selectByText(criteria);
        forcedWaitForTwoSeconds();
    }

    public void selectAffectedItem(String item) {
        selectDDMElement.get(1).click();
        forcedWaitForTwoSeconds();
        selectBySpanText(item);
        forcedWaitForTwoSeconds();
    }

    public void selectIncidentType(String type) {
        DDMElement.get(3).click();
        forcedWaitForTwoSeconds();
        selectByText(type);
        forcedWaitForTwoSeconds();
    }

    public void selectPrimaryLocation(String location) {
        DDMElement.get(4).click();
        forcedWaitForTwoSeconds();
        selectByButtonText(location);
        forcedWaitForTwoSeconds();
    }

    public void selectDefectDescriptor(String defectDescriptor) {
        selectDDMElement.get(2).click();
        forcedWaitForTwoSeconds();
        selectBySpanText(defectDescriptor);
        forcedWaitForTwoSeconds();
    }

    public void enterDescription(String description) {
        textAreaElement.get(0).click();
        textAreaElement.get(0).clear();
        forcedWaitForTwoSeconds();
        textAreaElement.get(0).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void enterComments(String comments) {
        textAreaElement.get(1).click();
        textAreaElement.get(1).clear();
        forcedWaitForTwoSeconds();
        textAreaElement.get(1).sendKeys(comments);
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

    public void uploadFindingDocument() {
        waitForElement(uploadFileElement);
    }

    public void enterDocumentDescription(String description) throws InterruptedException {
        documentDescriptionElement.click();
        documentDescriptionElement.clear();
        forcedWaitForTwoSeconds();
        documentDescriptionElement.sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void selectDocumentType(String documentType) throws InterruptedException {
        DDMElement.get(5).click();
        forcedWaitForTwoSeconds();
        driver.findElement(By.xpath("(//button[text()='" + documentType + "'])[2]")).click();
        forcedWaitForTwoSeconds();
    }

    public void clickUpdateButton() throws InterruptedException {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(0).click();
        forcedWaitForTwoSeconds();
    }

    public void clickOkButton() throws InterruptedException {
        forcedWaitForTwoSeconds();
        okElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickContinueButton() {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(1).click();
        forcedWaitForTwoSeconds();
    }
}