package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.ProjectsPage;

public class ProjectStep extends BaseStep {
    public ProjectStep(WebDriver driver) {
        super(driver);
    }
    public ProjectsPage deleteProject() throws InterruptedException {
        projectsPage.deleteProject();

        return projectsPage;
    }
}
