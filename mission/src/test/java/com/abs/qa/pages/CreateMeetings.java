package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CreateMeetings extends BaseTag {

    @FindBy(xpath = "//button[text()='Add Meetings']")
    WebElement addMeetingElement;
    @FindBy(xpath = "//input[@placeholder='Enter Meeting Name']")
    WebElement meetingNameElement;
    @FindBy(css = "button.btn-secondary.btn.Ripple-parent.dropdown-toggle")
    List<WebElement> meetingTypeElement;
    @FindBy(css = "button.dropdown-item")
    List<WebElement> meetingOptionsElement;
    @FindBy(xpath = "//input[@placeholder='DD-MM-YYYY']")
    WebElement meetingDateElement;
    @FindBy(css = "textarea.sc-hRJeED.jJbdCC")
    WebElement descriptionElement;
    @FindBy(css = "div.d-flex.p-15.align-items-center.flex-column.justify-content-center")
    WebElement uploadFileElement;
    @FindBy(xpath = "//*[@placeholder='Description']")
    WebElement docDescElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-default.sc-dAlxHm.cygQEj.btn-primary.undefined")
    WebElement saveButtonElement;

    public CreateMeetings(WebDriver driver) {
        super(driver);
    }

    public void clickAddMeetings()  {
        waitForElement(addMeetingElement);
        forcedWaitForTwoSeconds();
    }

    public void enterMeetingName(String meetingName)  {
        waitForElement(meetingNameElement);
        meetingNameElement.sendKeys(meetingName);
        forcedWaitForTwoSeconds();
    }

    public void selectMeetingType(String meetingOption)  {
        forcedWaitForThreeSeconds();
        meetingTypeElement.get(1).click();
        for (WebElement element : meetingOptionsElement) {
            if (element.getText().equalsIgnoreCase(meetingOption))
                element.click();
        }
    }

    public void enterMeetingDate(String meetingDate) {
        meetingDateElement.click();
        selectByDateText(meetingDate);
    }

    public void enterDescription(String description)  {
        waitForElement(descriptionElement);
        descriptionElement.sendKeys(description);
        forcedWaitForTwoSeconds();
    }

    public void uploadMeetingDocument() {
        waitForElement(uploadFileElement);
    }

    public void documentDescription(String docDesc, String docType)  {
        docDescElement.sendKeys(docDesc);
        selectByText("Select Type");
        forcedWaitForOneSecond();
        selectByButtonText(docType);
        forcedWaitForOneSecond();
    }

    public void selectChecklist(String checklist)  {
        selectByText(checklist);
        forcedWaitForTwoSeconds();
    }

    public void clickSaveButton()  {
        forcedWaitForOneSecond();
        saveButtonElement.click();
        forcedWaitForThreeSeconds();
    }
}
