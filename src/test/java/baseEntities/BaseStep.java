package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected TestPage testPage;
    protected AddTestRunPage addTestRunPage;
    protected SettingsPage settingsPage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        testPage= new TestPage(driver);
        addTestRunPage = new AddTestRunPage(driver);
        settingsPage = new SettingsPage(driver);
    }
}