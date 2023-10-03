package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddProjectPage;

public class AddProjectStep extends BaseStep {
    public AddProjectStep(WebDriver driver) {
        super(driver);
    }

    public AddProjectPage clickButton()  {
        addProjectPage.clickAddProject();

        return addProjectPage;
    }
}
