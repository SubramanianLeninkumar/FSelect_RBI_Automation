package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AnomalyFinding extends BaseTag {

    @FindBy(xpath = "(//a[text()='Anomalies'])[1]")
    WebElement anomaliesElement;
    @FindBy(xpath = "//button[text()='Create Anomaly']")
    WebElement createAnomalyElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> DDMElement;
    @FindBy(css = "button.dropdown-item")
    List<WebElement> assetElement;
    @FindBy(xpath = "//input[@value='Select Affected Item']")
    WebElement affectedItemElement;
    @FindBy(xpath = "//input[@value='Select Defect Descriptor']")
    WebElement defectDescriptorElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    WebElement documentDescriptionElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    List<WebElement> textAreaElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    List<WebElement> saveAndContinueButtonElement;

    public AnomalyFinding(WebDriver driver) {
        super(driver);
    }

    public void clickAnomaliesTab(String clickTab) {
        if (clickTab.equalsIgnoreCase("Yes")) {
            anomaliesElement.click();
            forcedWaitForTwoSeconds();
        }
    }

    public void clickCreateAnomaly() {
        waitForElement(createAnomalyElement);
        forcedWaitForTwoSeconds();
    }

    public void selectAssetType(String assetType) {
        forcedWaitForTwoSeconds();
        selectByText("Select Asset Type");
        forcedWaitForTwoSeconds();
        selectByText(assetType);
        forcedWaitForTwoSeconds();
    }

    public void selectAsset(String asset) {
        selectByText("Select Asset");
        forcedWaitForTwoSeconds();
        for (WebElement assetList : assetElement) {
            if (assetList.getText().equalsIgnoreCase(asset)) {
                assetList.click();
                break;
            }
        }
        forcedWaitForTwoSeconds();
    }

    public void selectCriteria(String criteria) {
        selectByText("Select Criteria");
        forcedWaitForTwoSeconds();
        selectByText(criteria);
        forcedWaitForTwoSeconds();
    }

    public void selectAffectedItem(String item) {
        affectedItemElement.click();
        forcedWaitForTwoSeconds();
        selectBySpanText(item);
        forcedWaitForTwoSeconds();
    }

    public void selectIncidentType(String type) {
        selectByText("Select Incident Type");
        forcedWaitForTwoSeconds();
        selectByText(type);
        forcedWaitForTwoSeconds();
    }

    public void selectPrimaryLocation(String location) {
        selectByText("Select Primary location");
        forcedWaitForTwoSeconds();
        selectByButtonText(location);
        forcedWaitForTwoSeconds();
    }

    public void selectDefectDescriptor(String defectDescriptor) {
        defectDescriptorElement.click();
        forcedWaitForTwoSeconds();
        selectBySpanText(defectDescriptor);
        forcedWaitForTwoSeconds();
    }

    public void enterDescription(String description) {
        textAreaElement.get(0).click();
        forcedWaitForTwoSeconds();
        textAreaElement.get(0).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void enterComments(String comments) {
        textAreaElement.get(1).click();
        forcedWaitForTwoSeconds();
        textAreaElement.get(1).sendKeys(comments);
        forcedWaitForTwoSeconds();
    }

    public void uploadFindingDocument() {
        waitForElement(uploadFileElement);
    }

    public void enterDocumentDescription(String description) throws InterruptedException {
        documentDescriptionElement.click();
        forcedWaitForTwoSeconds();
        documentDescriptionElement.sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void selectDocumentType(String documentType, String section) throws InterruptedException {
        DDMElement.get(7).click();
        forcedWaitForTwoSeconds();
        if (section.equalsIgnoreCase("RBIAnomaly")) {
            driver.findElement(By.xpath("(//button[text()='" + documentType + "'])[2]")).click();
        } else {
            selectByButtonText(documentType);
        }
        forcedWaitForTwoSeconds();
    }

    public void clickSaveButton() {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(0).click();
        forcedWaitForTwoSeconds();
    }

    public void clickSaveAndContinue() {
        forcedWaitForTwoSeconds();
        saveAndContinueButtonElement.get(1).click();
        forcedWaitForTwoSeconds();
    }

    public void clickContinueButton(String section) {
        forcedWaitForTwoSeconds();
        switch (section) {
            case "Event" -> saveAndContinueButtonElement.get(1).click();
            case "RBIAnomaly" -> saveAndContinueButtonElement.get(2).click();
        }
        forcedWaitForTwoSeconds();
    }
}
