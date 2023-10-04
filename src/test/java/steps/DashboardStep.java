package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;
import pages.TestPage;

public class DashboardStep extends BaseStep {
    public DashboardStep(WebDriver driver) {
        super(driver);
    }

    public TestPage addCase() throws InterruptedException {
        dashboardPage.clickButton();

        return testPage;
    }

    public AddProjectPage addProject() {
        dashboardPage.clickAddProjectButton();

        return addProjectPage;
    }
}