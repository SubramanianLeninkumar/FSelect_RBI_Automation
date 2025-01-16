package com.abs.qa.pages;

import com.base.qa.webbasetag.BaseTag;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class Events extends BaseTag {

    @FindBy(xpath = "//ul[@class='widgets-list']/li")
    List<WebElement> eventsListElement;
    @FindBy(xpath = "//*[@placeholder='Search by Event Name']")
    WebElement searchEventsElement;
    @FindBy(css = "td.pl-3.pr-3")
    List<WebElement> eventDetailsElement;
    @FindBy(xpath = "//*[text()='Clear Filters']")
    WebElement clearSearchResultElement;
    @FindBy(css = "button.btn.Ripple-parent.btn-sm.btn-outline-default.sc-dAlxHm.gGRFrN.btn-secondary.undefined")
    WebElement downloadElement;
    @FindBy(css = "button.dropdown-toggle.btn.btn-action-dd")
    WebElement actionButtonElement;
    @FindBy(css = "div.col-md-12")
    List<WebElement> eventsDetailsElement;

    public Events(WebDriver driver) {
        super(driver);
    }

    public void getConditionManagerDetails(String event) {
        //Get event details
        String[] eventOptions = event.split(",");
        for (String eventOption : eventOptions) {
            switch (eventOption.trim()) {
                case "Events" -> {
                    forcedWaitForTwoSeconds();
                    Reporter.log("<b>Events:</b><br>");
                    Reporter.log(eventsListElement.get(0).getText() + "<br>");
                    Reporter.log(eventsListElement.get(1).getText() + "<br>");
                    Reporter.log(eventsListElement.get(2).getText() + "<br>");
                }
                case "Inspections" -> {
                    Reporter.log("<b>Inspections:</b><br>");
                    Reporter.log(eventsListElement.get(3).getText() + "<br>");
                    Reporter.log(eventsListElement.get(4).getText() + "<br>");
                    Reporter.log(eventsListElement.get(5).getText() + "<br>");
                }
                case "Anomalies" -> {
                    Reporter.log("<b>Anomalies:</b><br>");
                    Reporter.log(eventsListElement.get(6).getText() + "<br>");
                    Reporter.log(eventsListElement.get(7).getText() + "<br>");
                    Reporter.log(eventsListElement.get(8).getText() + "<br>");
                }
            }
            forcedWaitForTwoSeconds();
        }
    }

    public void searchEvent(String event) {
        searchEventsElement.click();
        searchEventsElement.sendKeys(event);
        forcedWaitForTwoSeconds();
    }

    public void getEventList() {
        for (int i = 0; i < eventDetailsElement.size(); i += 10) {
            if (i + 7 < eventDetailsElement.size()) {
                Reporter.log("<b>Event Name:</b> " + eventDetailsElement.get(i).getText() + "<br>");
                Reporter.log("<b>Event Type:</b> " + eventDetailsElement.get(i + 1).getText() + "<br>");
                Reporter.log("<b>Start Date:</b> " + eventDetailsElement.get(i + 2).getText() + "<br>");
                Reporter.log("<b>End Date:</b> " + eventDetailsElement.get(i + 3).getText() + "<br>");
                Reporter.log("<b>Duration(In Days):</b> " + eventDetailsElement.get(i + 4).getText() + "<br>");
                Reporter.log("<b>Location:</b> " + eventDetailsElement.get(i + 5).getText() + "<br>");
                Reporter.log("<b>Owner/Creator:</b> " + eventDetailsElement.get(i + 6).getText() + "<br>");
                Reporter.log("<b>Associated Inspections:</b> " + eventDetailsElement.get(i + 7).getText() + "<br>");
                forcedWaitForTwoSeconds();
            }
        }
    }

    public void clickClearSearchResult() {
        clearSearchResultElement.click();
        forcedWaitForTwoSeconds();
    }

    public void downloadEvents() {
        downloadElement.click();
        forcedWaitForThreeSeconds();
    }

    public void viewDetails() {
        forcedWaitForOneSecond();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,200)", "");
        forcedWaitForOneSecond();
        actionButtonElement.click();
        forcedWaitForOneSecond();
        selectBySpanText("View Details");
        forcedWaitForOneSecond();
    }

    public void getViewDetails() {
        Reporter.log("<b>Event Information:</b><br>");
        Reporter.log(eventsDetailsElement.get(5).getText() + "<br>");
        Reporter.log("<b>Attachments:</b><br>");
        Reporter.log(eventsDetailsElement.get(8).getText() + "<br>");
        Reporter.log("<b>Inspection Information:</b><br>");
        Reporter.log(eventsDetailsElement.get(9).getText() + "<br>");
    }

    public void deleteEvent() {
        forcedWaitForOneSecond();
        ((JavascriptExecutor) driver).executeScript("window.scroll(0,200)", "");
        forcedWaitForOneSecond();
        actionButtonElement.click();
        forcedWaitForOneSecond();
        selectBySpanText("Delete Event");
        forcedWaitForOneSecond();
        selectByButtonText("Yes");
        forcedWaitForThreeSeconds();
    }
}