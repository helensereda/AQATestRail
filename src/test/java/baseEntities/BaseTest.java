package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AddProjectPage;
import pages.AddTestRunPage;
import pages.TestPage;
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

}