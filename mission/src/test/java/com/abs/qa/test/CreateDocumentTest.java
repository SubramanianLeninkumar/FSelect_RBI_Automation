package com.abs.qa.test;

import org.testng.annotations.Test;

import java.io.IOException;

public class CreateDocumentTest extends BaseClass {

    @Test
    public void testCreateDocuments() throws IOException {
        createDocument.clickAddDocument();
        createDocument.enterDocumentName(testData.getStringValueOfRow("documentName"));
        createDocument.selectDocumentCategory(testData.getStringValueOfRow("documentCategory"));
        createDocument.selectDocumentType(testData.getStringValueOfRow("cmDocumentType"));
        createDocument.uploadDocument();
        uploadFile(properties.getProperty("image.upload"), 1);
        createDocument.enterDescription(testData.getStringValueOfRow("cmDocumentDescription"));
        createDocument.clickSaveButton();
    }
}
