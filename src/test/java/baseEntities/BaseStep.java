package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {

    protected WebDriver driver;

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected SettingsPage settingsPage;
    protected TestPage testPage;
    protected AddTestRunPage addTestRunPage;
    protected SettingsPage settingsPage;
    protected AddProjectPage addProjectPage;
    protected ProjectsPage projectsPage;

    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        settingsPage = new SettingsPage(driver);
        testPage= new TestPage(driver);
        addTestRunPage = new AddTestRunPage(driver);
        settingsPage = new SettingsPage(driver);
        addProjectPage = new AddProjectPage(driver);
        projectsPage = new ProjectsPage(driver);
    }
}