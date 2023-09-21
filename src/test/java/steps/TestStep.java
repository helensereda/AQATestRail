package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddTestRunPage;
import pages.DashboardPage;

public class TestStep extends BaseStep {
    public TestStep(WebDriver driver) {
        super(driver);
    }
    public AddTestRunPage addTest() {
        testPage.clickButton();

        return addTestRunPage;
    }
}
