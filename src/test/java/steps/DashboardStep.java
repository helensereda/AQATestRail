package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.AddProjectPage;
import pages.DashboardPage;
import pages.TestPage;


public class DashboardStep extends BaseStep {

    public DashboardStep(WebDriver driver) {
        super(driver);
    }

    public TestPage addCase() {
        dashboardPage.clickButton();
        return testPage;
    }
    public AddProjectPage addProject() {
        dashboardPage.clickAddProjectButton();
        return addProjectPage;
    }
}