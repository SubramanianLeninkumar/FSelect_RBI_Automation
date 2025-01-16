package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class RBIOptionsOptionsTest extends BaseClass {

    @Test
    public void testRBIOptions() throws IOException {
        rbiOptions.clickRBITab();
        rbiOptions.clickRBIOptions(testData.getStringValueOfRow("options"));
        //added this because issue in RBI Meeting page;
        forcedWaitForThreeSeconds();
    }
}
