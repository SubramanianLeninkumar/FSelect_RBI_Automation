package com.abs.qa.test;

import org.testng.annotations.Test;
import java.io.IOException;

public class DocumentsTest extends BaseClass {

    @Test
    public void testDocuments() throws IOException {
        if (testData.getStringValueOfRow("cmSearchDocument").equalsIgnoreCase("Yes")) {
            documents.searchDocument(testData.getStringValueOfRow("cmSearchDocumentName"));
            documents.clickClearSearchResult();
            documents.getDocumentList();
        } else if (testData.getStringValueOfRow("cmDocumentFilter").equalsIgnoreCase("Yes")) {
            documents.clickDocumentFilter(testData.getStringValueOfRow("cmDocumentFilterValue"));
            documents.getDocumentList();
        } else if (testData.getStringValueOfRow("cmDeleteDocument").equalsIgnoreCase("Yes")) {
            documents.clickDeleteDocument();
        } else if (testData.getStringValueOfRow("cmDownloadDocument").equalsIgnoreCase("Yes")) {
            documents.clickDownloadDocument();
        }
    }
}