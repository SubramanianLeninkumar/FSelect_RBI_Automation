package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class ClientSearchTest extends BaseClass {

    @Test
    public void testClientSearch() throws IOException {
        forcedWaitForOneSecond();
        clientSearch.enterClientName(testData.getStringValueOfRow("clientName"));
        clientSearch.clickClientName(testData.getStringValueOfRow("fullClientName"));
        forcedWaitForTwoSeconds();
    }
}
