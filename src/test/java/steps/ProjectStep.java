package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddTestRunPage;
import pages.ProjectsPage;


public class ProjectStep extends BaseStep {
    public ProjectStep(WebDriver driver) {
        super(driver);
    }
    public ProjectsPage deleteProject() {
        projectsPage.deleteProject();
        return projectsPage;
    }
}
