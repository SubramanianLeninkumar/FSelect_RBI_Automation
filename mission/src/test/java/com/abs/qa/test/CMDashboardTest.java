package com.abs.qa.test;

import com.base.qa.webdriver.DriverListener;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v129.network.Network;
import org.openqa.selenium.devtools.v129.network.model.RequestId;
import org.openqa.selenium.devtools.v129.network.model.Response;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

public class CMDashboardTest extends BaseClass {

    private DevTools devTools;
    private String capturedResponseBody;
    private String targetUrl;

    @BeforeClass
    public void setup() {
        try {
            // Set up WebDriver and DevTools
            ChromeDriver driver = (ChromeDriver) DriverListener.getDriver();
            devTools = driver.getDevTools();
            devTools.createSession();

            // Enable network monitoring and configure URL
            devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
            targetUrl = testData.getStringValueOfRow("desiredUrl");

            // Add network response listener
            addNetworkResponseListener();

        } catch (Exception e) {
            Reporter.log("Error initializing DevTools or listener: " + e.getMessage());
        }
    }

    private void addNetworkResponseListener() {
        devTools.addListener(Network.responseReceived(), response -> {
            Response res = response.getResponse();
            String url = res.getUrl();

            // Log received response
            Reporter.log("Received Response URL: " + url);
            Reporter.log("Response Status: " + res.getStatus());

            // Capture response body if URL matches target
            if (url.equalsIgnoreCase(targetUrl)) {
                RequestId requestId = response.getRequestId();
                try {
                    capturedResponseBody = devTools.send(Network.getResponseBody(requestId)).getBody();
                } catch (Exception e) {
                    Reporter.log("Failed to capture or parse response body: " + e.getMessage());
                }
            }
        });
    }

    @Test
    public void testGetActionItem() {
        // Trigger the target API call
        driver.get(targetUrl);

        // Give listener time to capture response
        forcedWaitForOneSecond();

        // Log captured or missing response body
        if (capturedResponseBody != null && !capturedResponseBody.isEmpty()) {
            Reporter.log("Final Captured Response Body:\n" + beautifyJson(capturedResponseBody));
        } else {
            Reporter.log("No response captured. Verify if the API call is reaching the listener.");
        }
    }

    private static String beautifyJson(String json) {
        if (json == null || json.isEmpty()) {
            return "No JSON data to beautify";
        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Object jsonObject = gson.fromJson(json, Object.class);
        return gson.toJson(jsonObject);
    }
}