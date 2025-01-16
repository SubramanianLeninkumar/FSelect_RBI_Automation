package com.base.qa.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.*;

public class DriverListener implements ISuiteListener {

    private static final String DRIVER = "driver";
    String hubURL = "http://0.0.0.0:4444/wd/hub";

    @Override
    public void onStart(ISuite Result) {
        //Chrome option
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless");
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage"); // Recommended for CI
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-software-rasterizer");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-features=TranslateUI,RenderWidget");
        /*WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(hubURL), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }*/
        ChromeDriver driver = new ChromeDriver(options);
        Result.setAttribute(DRIVER, driver);
    }

    @Override
    public void onFinish(ISuite Result) {
        Object driver = Result.getAttribute(DRIVER);
        if (driver == null) {
            return;
        }
        if (!(driver instanceof WebDriver)) {
            throw new IllegalStateException("Corrupted WebDriver.");
        }
        ((WebDriver) driver).quit();
        Result.setAttribute(DRIVER, null);
    }

    public static WebDriver getDriver() {
        ITestResult result = Reporter.getCurrentTestResult();
        if (result == null) {
            throw new UnsupportedOperationException("Please invoke only from within an @Test method");
        }
        Object driver = result.getTestContext().getSuite().getAttribute(DRIVER);
        if (driver == null) {
            throw new IllegalStateException("Unable to find a valid web driver instance");
        }
        if (!(driver instanceof WebDriver)) {
            throw new IllegalStateException("Corrupted WebDriver.");
        }
        return (WebDriver) driver;
    }
}
