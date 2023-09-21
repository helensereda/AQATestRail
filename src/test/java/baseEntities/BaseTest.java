package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AddProjectPage;
import pages.AddTestRunPage;
import pages.TestPage;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import steps.*;
import utils.configuration.ReadProperties;

public class BaseTest {
    protected WebDriver driver;

    protected LoginStep loginStep;
    protected DashboardStep dashboardStep;
    protected TestStep testStep;
    protected AddTestRunStep addTestRunStep;
    protected SettingsStep settingsStep;
    protected AddProjectStep addProjectStep;
    protected ProjectStep projectStep;
    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();

        loginStep = new LoginStep(driver);
        dashboardStep = new DashboardStep(driver);
        testStep = new TestStep(driver);
        addTestRunStep = new AddTestRunStep(driver);
        settingsStep = new SettingsStep(driver);
        addProjectStep = new AddProjectStep(driver);
        projectStep = new ProjectStep(driver);

        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void setUp(ITestContext iTestContext) {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();
        this.setDriverToContext(iTestContext, driver);

        loginStep = new LoginStep(driver);
        dashboardStep = new DashboardStep(driver);
        settingsStep = new SettingsStep(driver);
        driver.get(ReadProperties.getUrl());
    }
    public static void setDriverToContext(ITestContext iTestContext, WebDriver driver) {
        iTestContext.setAttribute("WebDriver", driver);
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (!result.isSuccess()) {
            System.out.println("Make screenshot");
        }
        driver.quit();
    }
}