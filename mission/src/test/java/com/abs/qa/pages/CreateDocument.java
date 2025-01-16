package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateDocument extends BaseTag {

    @FindBy(xpath = "//button[text()='Add Document']")
    WebElement addDocumentButtonElement;
    @FindBy(xpath = "//input[@placeholder='Enter Document']")
    WebElement documentNameElement;
    @FindBy(xpath = "//*[text()='Select Document Category']")
    WebElement documentCategoryElement;
    @FindBy(xpath = "//*[text()='Select Document Type']")
    WebElement documentTypeElement;
    @FindBy(css = "div.sc-fqkwJk.hTRdNd.p-2.d-flex.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    WebElement textAreaElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    WebElement saveElement;

    public CreateDocument(WebDriver driver) {
        super(driver);
    }

    public void clickAddDocument() {
        addDocumentButtonElement.click();
        forcedWaitForOneSecond();
    }

    public void enterDocumentName(String text) {
        documentNameElement.click();
        documentNameElement.sendKeys(text);
        forcedWaitForOneSecond();
    }

    public void selectDocumentCategory(String text) {
        documentCategoryElement.click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForOneSecond();
    }

    public void selectDocumentType(String text) {
        documentTypeElement.click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
        forcedWaitForOneSecond();
    }

    public void uploadDocument() {
        waitForElement(uploadFileElement);
    }

    public void enterDescription(String description) {
        textAreaElement.click();
        textAreaElement.sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void clickSaveButton() {
        forcedWaitForTwoSeconds();
        saveElement.click();
        forcedWaitForThreeSeconds();
    }
}
