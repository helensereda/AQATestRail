package baseEntities;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseStep {
    protected WebDriver driver;

    protected LoginPage loginPage;
    protected DashboardPage dashboardPage;
    protected SettingsPage settingsPage;
    public BaseStep(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        settingsPage = new SettingsPage(driver);
    }
}