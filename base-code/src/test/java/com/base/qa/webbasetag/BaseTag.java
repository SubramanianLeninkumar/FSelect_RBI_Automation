package com.base.qa.webbasetag;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BaseTag {

    public Logger log = LogManager.getLogger(BaseTag.class);

    public WebDriver driver;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    List<WebElement> searchElement;
    @FindBy(css = "div.react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown")
    WebElement monthAndYearElement;

    public BaseTag(WebDriver driver) {
        this.driver = driver;
    }

    public void selectByTextXpath(String text) {
        driver.findElement(By.xpath("//*[@text='" + text + "']")).click();
    }

    public void selectByAriaLabel(String text) {
        driver.findElement(By.xpath("//*[@aria-label='" + text + "']")).click();
    }

    public void selectByText(String text) {
        driver.findElement(By.xpath("//*[text()='" + text + "']")).click();
    }

    public void selectByDateText(String text) {
        driver.findElement(By.xpath("//*[text()='" + text + "']")).click();
    }

    public void selectByButtonText(String text) {
        driver.findElement(By.xpath("//button[text()='" + text + "']")).click();
    }

    public void selectBySpanText(String text) {
        driver.findElement(By.xpath("//span[text()='" + text + "']")).click();
    }

    public void selectByHref(String text) {
        driver.findElement(By.xpath("//a[@href='" + text + "']")).click();
    }

    public void selectByContainsText(String text) {
        driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")).click();
    }

    public void selectByButtonContainsText(String text) {
        driver.findElement(By.xpath("//button[contains(text(),'" + text + "')]")).click();
    }

    public void selectByTitleText(String text) {
        driver.findElement(By.xpath("//span[@title='" + text + "']")).click();
    }

    public void selectFromDropDown(WebElement element, WebElement searchElement, String option) {
        element.click();
        searchElement.sendKeys(option);
        searchElement.sendKeys(Keys.ENTER);
    }

    public void selectFromDropDownCandidateList(WebElement element, WebElement searchElement, String option) {
        element.click();
        searchElement.click();
        searchElement.sendKeys(option);
        searchElement.sendKeys(Keys.ENTER);
    }

    public void switchToActiveElement(WebElement element, String value) {
        element.click();
        searchElement.get(1).sendKeys(value);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    public void switchToActiveElement(WebElement element, WebElement searchElement, String value) {
        element.click();
        searchElement.sendKeys(value);
        driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    }

    public void switchToActiveElement(String value) {
        driver.switchTo().activeElement().sendKeys(value, Keys.ENTER);
    }

    public void waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(300));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void selectFromDropDown(List<WebElement> element, String text) {
        try {
            for (WebElement dropdown : element) {
                if (dropdown.getText().trim().equalsIgnoreCase(text)) {
                    dropdown.click();
                }
            }
        } catch (StaleElementReferenceException e) {
            log.error(e);
        }
    }

    public void selectByTitle(String name) {
        driver.findElement(By.xpath("//label[@title='" + name + "']")).click();
    }

    public void selectByName(String name) {
        driver.findElement(By.xpath("(//button[@title='" + name + "'])[1]")).click();
    }

    public void scrollUp() {
        WebElement body = driver.findElement(By.tagName("html"));
        body.sendKeys(Keys.PAGE_UP);
    }

    public void scrollDown() {
        WebElement body = driver.findElement(By.tagName("html"));
        body.sendKeys(Keys.PAGE_DOWN);
    }

    public void moveAction(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void clickAction(WebElement element) {
        Actions action = new Actions(driver);
        action.click(element).perform();
    }

    public void forcedWaitForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("e: ", e);
        }
    }

    public void forcedWaitForTwoSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("e: ", e);
        }
    }

    public void forcedWaitForThreeSeconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("e: ", e);
        }
    }

    public void selectDate(String dateType, int days) {
        try {
            // Calculate the target date based on dateType (From or To)
            LocalDate targetDate = dateType.equalsIgnoreCase("from")
                    ? LocalDate.now().minusDays(days)
                    : LocalDate.now().plusDays(days);

            DateTimeFormatter monthYearFormatter = DateTimeFormatter.ofPattern("MMMM yyyy");
            DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");

            String targetMonthYear = targetDate.format(monthYearFormatter); // For navigation
            String date = targetDate.format(dayFormatter); // For selecting the date

            // Navigate to the target month and year
            navigateToTargetMonthYear(targetMonthYear);

            // Select the target date
            List<WebElement> desiredDate = driver.findElements(By.xpath(
                    "//div[contains(@class, 'react-datepicker__day') and text()='" + date + "']"));

            if (!desiredDate.isEmpty()) {
                WebElement itemToSelect;
                if (desiredDate.size() >= 2 && desiredDate.get(1).getText().equalsIgnoreCase(desiredDate.get(0).getText())) {
                    itemToSelect = desiredDate.get(1); // Select the second occurrence
                    log.info("Selecting the second occurrence of the date: " + itemToSelect.getText());
                } else {
                    itemToSelect = desiredDate.get(0); // Select the first occurrence
                    log.info("Selecting the first occurrence of the date: " + itemToSelect.getText());
                }

                // Ensure the selected element is enabled and clickable
                if (itemToSelect.isDisplayed() && itemToSelect.isEnabled()) {
                    itemToSelect.click();
                    log.info("Successfully clicked the date: " + itemToSelect.getText());
                } else {
                    log.error("The selected date is not clickable: " + itemToSelect.getText());
                }
            } else {
                log.info("No matching dates found in the calendar.");
            }
        } catch (Exception e) {
            log.error("Error selecting the " + dateType + " date.", e);
        }
    }

    private void navigateToTargetMonthYear(String targetMonthYear) {
        int attempts = 0; // To prevent infinite loops
        int maxAttempts = 12; // Assume at most 12 months of navigation

        while (!monthAndYearElement.getText().equalsIgnoreCase(targetMonthYear) && attempts < maxAttempts) {
            WebElement navigationButton = isTargetAfterDisplayed(targetMonthYear, monthAndYearElement.getText())
                    ? driver.findElement(By.xpath("//button[contains(@class, 'react-datepicker__navigation--next')]"))
                    : driver.findElement(By.xpath("//button[contains(@class, 'react-datepicker__navigation--previous')]"));

            navigationButton.click(); // Click to navigate

            // Increment attempts and wait for the calendar to update
            attempts++;
            waitForCalendarUpdate();
        }

        if (attempts >= maxAttempts) {
            throw new RuntimeException("Unable to navigate to the target month and year: " + targetMonthYear);
        }
    }

    private boolean isTargetAfterDisplayed(String targetMonthYear, String displayedMonthYear) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        YearMonth targetDate = YearMonth.parse(targetMonthYear, formatter);
        YearMonth displayedDate = YearMonth.parse(displayedMonthYear, formatter);
        return targetDate.isAfter(displayedDate);
    }

    private void waitForCalendarUpdate() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOf(monthAndYearElement));
        } catch (TimeoutException e) {
            log.error("Timed out waiting for calendar update", e);
        }
    }
}
