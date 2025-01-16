package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ClientSearch extends BaseTag {

    private static final Logger log = LoggerFactory.getLogger(ClientSearch.class);
    @FindBy(xpath = "//*[@placeholder='Search by Vessel']")
    WebElement clientSearchElement;
    @FindBy(css = "div.d-flex.justify-space-between.gap-3")
    List<WebElement> clientNameElement;

    public ClientSearch(WebDriver driver) {
        super(driver);
    }

    public void enterClientName(String clientName) {
        forcedWaitForTwoSeconds();
        waitForElement(clientSearchElement);
        clientSearchElement.sendKeys(clientName);
    }

    public void clickClientName(String fullClientName)  {
        try {
            forcedWaitForThreeSeconds();
            for (WebElement webElement : clientNameElement) {
                if (webElement.getText().equals(fullClientName)) {
                    webElement.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            log.error("e: ", e);
        }
    }
}