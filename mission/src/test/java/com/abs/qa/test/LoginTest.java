package com.abs.qa.test;

import com.base.qa.webdriver.RetryAnalyzer;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Parameters({"username", "password"})
    public void testLogin(String username, String password) throws InterruptedException {
        Thread.sleep(10000);
        login.enterUserName(username);
        login.enterPassword(password);
        login.clickLogin();
    }
}
