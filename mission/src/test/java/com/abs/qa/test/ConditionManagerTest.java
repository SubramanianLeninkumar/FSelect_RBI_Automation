package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class ConditionManagerTest extends BaseClass {

    @Test
    public void testConditionManager() throws IOException {
        conditionManagerOptions.clickConditionManager();
        conditionManagerOptions.clickConditionManagerOptions(testData.getStringValueOfRow("options"));
    }
}