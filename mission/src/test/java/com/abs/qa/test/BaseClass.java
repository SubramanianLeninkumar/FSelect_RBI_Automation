package com.abs.qa.test;

import com.base.qa.utils.PropertyUtils;
import com.base.qa.utils.TestData;
import com.base.qa.webdriver.DriverListener;
import com.abs.qa.pages.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.testng.*;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import static com.base.qa.webdriver.DriverListener.getDriver;

@Listeners({DriverListener.class})
public class BaseClass {

    public Logger log = LogManager.getLogger(BaseClass.class);

    protected ChromeDriver driver;
    protected Login login;
    protected ClientSearch clientSearch;
    protected ConditionManagerOptions conditionManagerOptions;
    protected Events events;
    protected CreateEvent createEvent;
    protected CreateEventWithInspection createEventWithInspection;
    protected ManageEventInspections manageEventInspections;
    protected EditEvent editEvent;
    protected Inspection inspection;
    protected CreateInspection createInspection;
    protected EditInspection editInspection;
    protected ManageInspection manageInspection;
    protected Anomalies anomalies;
    protected CreateDocument createDocument;
    protected Documents documents;
    protected RBIOptions rbiOptions;
    protected PlanScope planScope;
    protected EditPlanScope editPlanScope;
    protected AnomalyFinding anomalyFinding;
    protected AnomalyAssessment anomalyAssessment;
    protected AnomalyPlanning anomalyPlanning;
    protected AnomalyResolution anomalyResolution;
    protected AnomalyRegister anomalyRegister;
    protected EditAnomalyFinding editAnomalyFinding;
    protected EditAnomalyAssessment editAnomalyAssessment;
    protected EditAnomalyPlanning editAnomalyPlanning;
    protected EditAnomalyResolution editAnomalyResolution;
    protected EditAnomaly editAnomaly;
    protected CreateMeetings createMeetings;
    protected EditMeetings editMeetings;
    protected Meetings meetings;
    protected ActionPlan actionPlan;
    protected TestData testData;
    protected Properties properties;
    private static final String SCREENSHOT_DIR = "build/reports/";

    @BeforeClass
    @Parameters({"flowName", "productName", "sheetName", "url"})
    public void setUp(String flowName, String productName, String sheetName, String url) throws IOException {
        driver = (ChromeDriver) getDriver();
        PageFactory.initElements(driver, this);
        if (!userLoggedIn()) {
            driver.get(url);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        login = PageFactory.initElements(driver, Login.class);
        clientSearch = PageFactory.initElements(driver, ClientSearch.class);
        conditionManagerOptions = PageFactory.initElements(driver, ConditionManagerOptions.class);
        events = PageFactory.initElements(driver, Events.class);
        editEvent = PageFactory.initElements(driver, EditEvent.class);
        createEvent = PageFactory.initElements(driver, CreateEvent.class);
        createEventWithInspection = PageFactory.initElements(driver, CreateEventWithInspection.class);
        manageEventInspections = PageFactory.initElements(driver, ManageEventInspections.class);
        inspection = PageFactory.initElements(driver, Inspection.class);
        createInspection = PageFactory.initElements(driver, CreateInspection.class);
        editInspection = PageFactory.initElements(driver, EditInspection.class);
        manageInspection = PageFactory.initElements(driver, ManageInspection.class);
        anomalies = PageFactory.initElements(driver, Anomalies.class);
        createDocument = PageFactory.initElements(driver, CreateDocument.class);
        documents = PageFactory.initElements(driver, Documents.class);
        rbiOptions = PageFactory.initElements(driver, RBIOptions.class);
        planScope = PageFactory.initElements(driver, PlanScope.class);
        editPlanScope = PageFactory.initElements(driver, EditPlanScope.class);
        anomalyFinding = PageFactory.initElements(driver, AnomalyFinding.class);
        anomalyAssessment = PageFactory.initElements(driver, AnomalyAssessment.class);
        anomalyPlanning = PageFactory.initElements(driver, AnomalyPlanning.class);
        anomalyResolution = PageFactory.initElements(driver, AnomalyResolution.class);
        anomalyRegister = PageFactory.initElements(driver, AnomalyRegister.class);
        editAnomalyFinding = PageFactory.initElements(driver, EditAnomalyFinding.class);
        editAnomalyAssessment = PageFactory.initElements(driver, EditAnomalyAssessment.class);
        editAnomalyPlanning = PageFactory.initElements(driver, EditAnomalyPlanning.class);
        editAnomalyResolution = PageFactory.initElements(driver, EditAnomalyResolution.class);
        editAnomaly = PageFactory.initElements(driver, EditAnomaly.class);
        createMeetings = PageFactory.initElements(driver, CreateMeetings.class);
        editMeetings = PageFactory.initElements(driver, EditMeetings.class);
        meetings = PageFactory.initElements(driver, Meetings.class);
        actionPlan = PageFactory.initElements(driver, ActionPlan.class);
        testData = new TestData(flowName, sheetName);
        properties = PropertyUtils.loadProperty(productName);
    }

    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            String resultMessage = result.getMethod().getMethodName();
            takeScreenshot(sanitizeFileName(resultMessage));
            Reporter.log("Failure Reason : " + result.getThrowable());
        }
    }

    public boolean userLoggedIn() {
        return driver.manage().getCookieNamed("access_token") != null;
    }

    public void assertion(String actual, String expected, String fieldName) {
        try {
            Assert.assertEquals(actual, expected);
            Reporter.log("<b> Expected " + fieldName + " :  </b><br><font color=\"green\">" + expected + "</font><br><b>Observed " + fieldName + " : </b><br><font color=\"green\">" + actual + "</font><br><b>Result  : </b><br><font color=\"green\">PASS</font><br>--------------------------------------------------------<br>");
        } catch (AssertionError error) {
            Reporter.log("<b> Expected " + fieldName + " :  </b><br><font color=\"green\">" + expected + "</font><br><b>Observed " + fieldName + " : </b><br><font color=\"red\">" + actual + "</font><br><b>Result  : </b><br><font color=\"red\">FAIL</font><br>--------------------------------------------------------<br>");
        }
    }

    public void scrollDown() {
        WebElement body = driver.findElement(By.tagName("html"));
        body.sendKeys(Keys.PAGE_DOWN);
    }

    public void scrollUp() {
        WebElement body = driver.findElement(By.tagName("html"));
        body.sendKeys(Keys.PAGE_UP);
    }

    private void takeScreenshot(String result) {
        TakesScreenshot ts = (TakesScreenshot) getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(SCREENSHOT_DIR + result + ".png");

        try {
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getMessage());
        }
    }

    private String sanitizeFileName(String fileName) {
        // Replace invalid characters with underscores
        return fileName != null ? fileName.replaceAll("[^a-zA-Z0-9.-]", "_") : "screenshot";
    }

    public void forcedWaitForOneSecond() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            log.error("e: ", e);
        }
    }

    public void forcedWaitForTwoSeconds() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            log.error("e: ", e);
        }
    }

    public void forcedWaitForThreeSeconds() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            log.error("e: ", e);
        }
    }

    public void uploadFile(String filePath, int i) throws IOException {
        forcedWaitForTwoSeconds();
        String workspace = System.getenv("WORKSPACE");
        if (workspace == null || workspace.isEmpty()) {
            // For GitHub Actions, use GITHUB_WORKSPACE
            workspace = System.getenv("GITHUB_WORKSPACE");
            if (workspace == null || workspace.isEmpty()) {
                throw new IllegalStateException("Neither WORKSPACE nor GITHUB_WORKSPACE environment variable is set.");
            }
        }

        // Resolve the full file path
        String absolutePath = new File(workspace, filePath).getAbsolutePath();

        // Verify if the file exists
        File file = new File(absolutePath);
        if (!file.exists()) {
            throw new IOException("File not found: " + absolutePath);
        }

        forcedWaitForTwoSeconds();
        WebElement fileInput = driver.findElement(By.xpath("(//input[@type='file'])[" + i + "]"));
        fileInput.sendKeys(absolutePath);//upload Image using AutoIT
        forcedWaitForThreeSeconds();
    }

    public void verifyFileDownload(String path, String fileName) {
        // C:\Users\Mohan\Downloads
        File fileLocation = new File(path);
        File[] totalFiles = fileLocation.listFiles();
        assert totalFiles != null;
        for (File file : totalFiles) {
            if (file.getName().equals(fileName)) {
                log.info("File downloaded successfully");
                break;
            }
        }
    }
}
