package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BaseTag {

    @FindBy(id = "signInName")
    public WebElement userNameElement;
    @FindBy(id = "password")
    public WebElement passwordElement;
    @FindBy(css = "button#next")
    public WebElement loginButtonElement;

    public Login(WebDriver driver) {
        super(driver);
    }

    public void enterUserName(String username) {
        waitForElement(userNameElement);
        userNameElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForElement(passwordElement);
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        loginButtonElement.click();
    }
}