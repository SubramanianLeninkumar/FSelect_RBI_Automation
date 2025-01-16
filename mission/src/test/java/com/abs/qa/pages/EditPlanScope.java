package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditPlanScope extends BaseTag {

    @FindBy(css = "input.select-dropdown")
    WebElement programDropdownElement;
    @FindBy(xpath = "(//span[text()='RBI'])[2]")
    WebElement selectRBIElement;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement searchElement;
    @FindBy(xpath = "(//input[@placeholder='DD-MMM-YYYY'])[1]")
    WebElement dueDateElement;
    @FindBy(xpath = "(//input[@placeholder='DD-MMM-YYYY'])[2]")
    WebElement doneDateElement;
    @FindBy(xpath = "(//input[@placeholder='DD-MMM-YYYY'])[3]")
    WebElement extDateElement;
    @FindBy(xpath = "(//*[text()='Save'])[2]")
    WebElement saveRBIIns;

    public EditPlanScope(WebDriver driver) {
        super(driver);
    }

    public void selectProgram(String text)  {
        forcedWaitForTwoSeconds();
        programDropdownElement.click();
        forcedWaitForOneSecond();
        switch (text) {
            case "RBI" -> selectRBIElement.click();
            case "Not Specified", "N/A" -> selectBySpanText(text);
        }
        forcedWaitForTwoSeconds();
    }

    public void clickPartName(String text)  {
        selectByText(text);
        forcedWaitForTwoSeconds();
    }

    public void searchRBIInspectionType(String text)  {
        searchElement.click();
        searchElement.sendKeys(text);
        forcedWaitForTwoSeconds();
    }

    public void enterDueDate(String date)  {
        dueDateElement.click();
        forcedWaitForOneSecond();
        selectByDateText(date);
        forcedWaitForTwoSeconds();
    }

    public void enterDoneDate(String date)  {
        doneDateElement.click();
        forcedWaitForOneSecond();
        selectByDateText(date);
        forcedWaitForTwoSeconds();
    }

    public void extDate(String date)  {
        extDateElement.click();
        forcedWaitForOneSecond();
        selectByDateText(date);
        forcedWaitForTwoSeconds();
    }

    public void clickSaveButton()  {
        saveRBIIns.click();
        forcedWaitForTwoSeconds();
    }
}
