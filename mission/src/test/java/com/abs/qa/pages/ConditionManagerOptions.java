package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConditionManagerOptions extends BaseTag {

    @FindBy(xpath = "//*[text()='Condition Manager']")
    WebElement conditionManagerElement;
    @FindBy(xpath = "(//*[text()='Dashboard'])[3]")
    WebElement dashboardElement;
    @FindBy(xpath = "//*[text()='Condition Status']")
    WebElement conditionStatusElement;
    @FindBy(xpath = "(//a[text()='Events'])[1]")
    WebElement eventsElement;
    @FindBy(xpath = "//*[text()='Documents']")
    WebElement documentsElement;

    public ConditionManagerOptions(WebDriver driver) {
        super(driver);
    }

    public void clickConditionManager() {
        conditionManagerElement.click();
        forcedWaitForTwoSeconds();
    }

    public void clickConditionManagerOptions(String options) {
        switch (options) {
            case "Dashboard" -> dashboardElement.click();
            case "Condition Status" -> conditionStatusElement.click();
            case "Events" -> eventsElement.click();
            case "Documents" -> documentsElement.click();
        }
    }
}
