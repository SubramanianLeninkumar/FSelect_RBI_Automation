package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ManageInspection extends BaseTag {

    @FindBy(xpath = "(//a[text()='Inspections'])[1]")
    WebElement inspectionsTabElement;
    @FindBy(css = "td.pl-3.pr-3")
    List<WebElement> inspectionDetailsElement;
    @FindBy(css = "input.sc-ikkyvV.jECmaC.matrix-input")
    List<WebElement> fittingValueElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    List<WebElement> textAreaElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> selectReviewerElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    WebElement saveElement;

    public ManageInspection(WebDriver driver) {
        super(driver);
    }

    public void clickManageInspection() {
        forcedWaitForTwoSeconds();
        inspectionsTabElement.click();
        forcedWaitForTwoSeconds();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,250)", "");
        forcedWaitForThreeSeconds();
        // Loop through every 8th, 20th, 32nd, etc., element
        for (int i = 7; i < inspectionDetailsElement.size(); i += 12) {  // Start at index 6 for the 7th element, increment by 12 each time
            WebElement targetElement = inspectionDetailsElement.get(i);
            String data = targetElement.getText().trim();

            if (data.isEmpty()) {
                log.info("Element at position " + (i + 1) + " is empty.");

                int clickIndex = i + 3;  // Calculate index for the fourth element after the target element

                // Ensure the clickIndex is within bounds
                if (clickIndex < inspectionDetailsElement.size()) {
                    forcedWaitForOneSecond();
                    ((JavascriptExecutor) driver).executeScript("window.scroll(0,100)", "");
                    forcedWaitForOneSecond();
                    inspectionDetailsElement.get(clickIndex).click();
                    log.info("Clicked element at position " + (clickIndex + 1));
                    break;  // Exit after clicking the first matched element
                } else {
                    log.info("No element found at position " + (clickIndex + 1) + " or out of bounds.");
                }
            } else {
                log.info("Data from position " + (i + 1) + ": " + data);
            }
        }
        forcedWaitForTwoSeconds();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,250)", "");
        forcedWaitForOneSecond();
        selectBySpanText("Manage Inspection");
        forcedWaitForOneSecond();
    }

    public void enterFittingValue(String text) {
        forcedWaitForOneSecond();
        for (WebElement element : fittingValueElement) {
            element.sendKeys(text);
        }
        forcedWaitForOneSecond();
    }

    public void enterComments(String description) {
        forcedWaitForTwoSeconds();
        textAreaElement.get(0).clear();
        textAreaElement.get(0).click();
        textAreaElement.get(0).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void selectReviewer(String text) {
        forcedWaitForOneSecond();
        selectReviewerElement.get(2).click();
        forcedWaitForOneSecond();
        selectByButtonText(text);
    }

    public void enterStatusComments(String description) {
        forcedWaitForTwoSeconds();
        textAreaElement.get(1).clear();
        textAreaElement.get(1).click();
        textAreaElement.get(1).sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void clickSaveButton() {
        forcedWaitForTwoSeconds();
        saveElement.click();
        forcedWaitForThreeSeconds();
    }
}
