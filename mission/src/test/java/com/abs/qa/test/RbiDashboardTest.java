package com.abs.qa.test;

import com.base.qa.webdriver.DriverListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.DevToolsException;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.RequestId;
import org.openqa.selenium.devtools.v129.network.model.Response;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Optional;

public class RbiDashboardTest extends BaseClass {

    private DevTools devTools;
    private String capturedResponseBody; // Variable to hold the captured response body
    private String targetUrl; // Variable to hold the target URL

    @BeforeClass
    public void setup() throws IOException, DevToolsException {
        // Get the WebDriver from DriverListener
        ChromeDriver driver = (ChromeDriver) DriverListener.getDriver();

        // Initialize DevTools
        devTools = driver.getDevTools();
        devTools.createSession();

        // Enable network tracking
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Set the target URL for capturing response
        targetUrl = testData.getStringValueOfRow("desiredUrl");

        // Add listener for network response
        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            String url = res.getUrl();

            // Log received response
            Reporter.log("Received Response URL: " + url);
            Reporter.log("Response Status: " + res.getStatus());

            // Capture the response body if the URL matches the target URL
            if (url.equalsIgnoreCase(targetUrl)) {
                RequestId requestId = response.getRequestId();
                Network.GetResponseBodyResponse bodyResponse = devTools.send(Network.getResponseBody(requestId));
                capturedResponseBody = bodyResponse.getBody(); // Store the response body

                // Pretty print the response body
                Reporter.log("Captured Response Body: " + beautifyJson(capturedResponseBody) + "\n");
            }
        });
    }

    @Test(priority = 1)
    public void testGetActionItem() {
        // Trigger the API call
        driver.get(targetUrl); // This should trigger the network listener

        // Wait for a moment to ensure the listener has time to capture the response
        forcedWaitForOneSecond(); // Wait for 2 seconds; adjust as necessary

        // Print the captured response body
        Reporter.log("Final Captured Response Body: " + capturedResponseBody);

        // Additional check to see if we captured anything
        if (capturedResponseBody == null || capturedResponseBody.isEmpty()) {
            Reporter.log("No response captured. Please check if the API call is being made correctly.");
        }
        // Assertions can go here if needed

        //Back
        driver.navigate().back();
    }

    private static String beautifyJson(String json) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Object jsonObject = gson.fromJson(json, Object.class);
        return gson.toJson(jsonObject);
    }
}

