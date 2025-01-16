package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RBIOptions extends BaseTag {

    @FindBy(xpath = "(//*[text()='RBI'])[1]")
    WebElement RBIElement;
    @FindBy(xpath = "(//*[text()='Dashboard'])[4]")
    WebElement dashboardElement;
    @FindBy(xpath = "(//*[text()='Plan Scope'])[1]")
    WebElement planScopeElement;
    @FindBy(xpath = "(//*[text()='Anomaly Register'])[1]")
    WebElement anomalyRegisterElement;
    @FindBy(xpath = "(//*[text()='Meetings'])[1]")
    WebElement meetingsElement;

    public RBIOptions(WebDriver driver) {
        super(driver);
    }

    public void clickRBITab()  {
        forcedWaitForThreeSeconds();
        waitForElement(RBIElement);
        forcedWaitForThreeSeconds();
    }

    public void clickRBIOptions(String options) {
        switch (options) {
            case "Dashboard" -> dashboardElement.click();
            case "Plan Scope" -> planScopeElement.click();
            case "Anomaly Register" -> anomalyRegisterElement.click();
            case "Meetings" -> meetingsElement.click();
        }
    }
}
