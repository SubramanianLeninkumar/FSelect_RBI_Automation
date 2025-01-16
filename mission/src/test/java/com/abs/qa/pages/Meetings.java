package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class Meetings extends BaseTag {

    private static final Log log = LogFactory.getLog(Meetings.class);
    @FindBy(xpath = "//*[@placeholder='Search by Meeting Name, Description']")
    WebElement meetingSearchElement;
    @FindBy(xpath = "//*[@value='Select Meeting Type']")
    WebElement filterElement;
    @FindBy(css = "li.justify-content-between.align-items-center")
    List<WebElement> filterNameElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-outline-default.sc-dAlxHm.gGRFrN.btn-secondary.undefined")
    WebElement downloadElement;
    @FindBy(css = "td.pl-3.pr-3")
    List<WebElement> meetingDetailsElement;
    @FindBy(css = "div.col-md-9")
    WebElement meetingLabelElement;
    @FindBy(xpath = "//*[text()='Clear Filters']")
    WebElement clearSearchResultElement;
    @FindBy(css = "div.sc-eDPFhE.kcPVnG")
    List<WebElement> meetingPrimaryInformationElement;
    @FindBy(css = "div.col-md-12.form-group")
    WebElement descriptionElement;

    public Meetings(WebDriver driver) {
        super(driver);
    }

    public void enterMeetingName(String meetingName) {
        waitForElement(meetingSearchElement);
        meetingSearchElement.sendKeys(meetingName);
    }

    public void clickFilters(String filterName) {
        forcedWaitForTwoSeconds();
        filterElement.click();
        forcedWaitForTwoSeconds();
        String[] filters = filterName.split(",");
        for (String filter : filters) {
            switch (filter) {
                case "5-yearly Health Check and Update meeting" -> filterNameElement.get(0).click();
                case "Annual Health Check meeting" -> filterNameElement.get(1).click();
                case "Annual RBI Work-Pack Inspection Scope Kickoff/Close Out" -> filterNameElement.get(2).click();
            }
        }
        meetingLabelElement.click();
    }

    public void downloadMeetings() {
        downloadElement.click();
        forcedWaitForThreeSeconds();
    }

    public void meetingPrimaryInformation(String text) {
        selectByText(text);
        forcedWaitForTwoSeconds();
        for (WebElement info : meetingPrimaryInformationElement) {
            Reporter.log(info.getText());
        }
        Reporter.log("<b>Description : </b>" + descriptionElement.getText());
        forcedWaitForTwoSeconds();
    }

    public void meetingList() {
        for (int i = 0; i < meetingDetailsElement.size(); i += 6) {
            if (i + 3 < meetingDetailsElement.size()) {
                Reporter.log("<b>Meeting Name:</b> " + meetingDetailsElement.get(i).getText() + "<br>");
                Reporter.log("<b>Meeting Type:</b> " + meetingDetailsElement.get(i + 1).getText() + "<br>");
                Reporter.log("<b>Meeting Date:</b> " + meetingDetailsElement.get(i + 2).getText() + "<br>");
                Reporter.log("<b>Meeting </b> " + meetingDetailsElement.get(i + 3).getText() + "<br>");
                forcedWaitForTwoSeconds();
            }// Skip 5th and 6th elements automatically by the loop increment (i += 6)
        }
    }

    public void clearSearchResult() {
        clearSearchResultElement.click();
        forcedWaitForTwoSeconds();
    }
}
