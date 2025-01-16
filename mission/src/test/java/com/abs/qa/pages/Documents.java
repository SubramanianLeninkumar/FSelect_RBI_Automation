package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class Documents extends BaseTag {

    @FindBy(xpath = "//*[@placeholder='Search by Document category, Name']")
    WebElement searchDocumentsElement;
    @FindBy(css = "td.pl-3.pr-3")
    List<WebElement> documentsDetailsElement;
    @FindBy(xpath = "//*[text()='Clear Filters']")
    WebElement clearSearchResultElement;
    @FindBy(css = "button.dropdown-toggle.btn.btn-action-dd")
    WebElement actionButtonElement;

    public Documents(WebDriver driver) {
        super(driver);
    }

    public void searchDocument(String event) {
        forcedWaitForThreeSeconds();
        searchDocumentsElement.click();
        searchDocumentsElement.sendKeys(event);
        forcedWaitForOneSecond();
    }

    public void getDocumentList() {
        for (int i = 0; i < documentsDetailsElement.size(); i += 8) {
            if (i + 7 < documentsDetailsElement.size()) {
                Reporter.log("<b>Document Name:</b> " + documentsDetailsElement.get(i).getText() + "<br>");
                Reporter.log("<b>Vessel Name:</b> " + documentsDetailsElement.get(i + 1).getText() + "<br>");
                Reporter.log("<b>Document Category:</b> " + documentsDetailsElement.get(i + 2).getText() + "<br>");
                Reporter.log("<b>Document Type:</b> " + documentsDetailsElement.get(i + 3).getText() + "<br>");
                Reporter.log("<b>Created By:</b> " + documentsDetailsElement.get(i + 4).getText() + "<br>");
                Reporter.log("<b>Created On:</b> " + documentsDetailsElement.get(i + 5).getText() + "<br>");
                forcedWaitForOneSecond();
            }
        }
    }

    public void clickClearSearchResult() {
        clearSearchResultElement.click();
        forcedWaitForOneSecond();
    }

    public void clickDocumentFilter(String text) {
        selectByButtonText("SELECT");
        selectByButtonContainsText(text);
        forcedWaitForOneSecond();
    }


    public void clickDownloadDocument() {
        actionButtonElement.click();
        forcedWaitForOneSecond();
        selectBySpanText("Download Document");
        forcedWaitForOneSecond();
    }

    public void clickDeleteDocument() {
        actionButtonElement.click();
        forcedWaitForOneSecond();
        selectBySpanText("Delete Document");
        forcedWaitForOneSecond();
        selectByButtonText("Delete");
        forcedWaitForThreeSeconds();
    }
}
