package baseEntities;

import factory.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AddTestRunPage;
import pages.TestPage;
import steps.AddTestRunStep;
import steps.DashboardStep;
import steps.LoginStep;
import steps.TestStep;
import utils.configuration.ReadProperties;

public class BaseTest {
    protected WebDriver driver;

    protected LoginStep loginStep;
    protected DashboardStep dashboardStep;
    protected TestStep testStep;
    protected AddTestRunStep addTestRunStep;
    @BeforeMethod
    public void setUp() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getDriver();

        loginStep = new LoginStep(driver);
        dashboardStep = new DashboardStep(driver);
        testStep = new TestStep(driver);
        addTestRunStep = new AddTestRunStep(driver);


        driver.get(ReadProperties.getUrl());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}