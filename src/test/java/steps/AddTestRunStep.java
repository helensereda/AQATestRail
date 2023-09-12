package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.AddTestRunPage;
import pages.TestPage;

public class AddTestRunStep extends BaseStep {
    public AddTestRunStep(WebDriver driver) {
        super(driver);
    }

    public AddTestRunPage addFile() throws InterruptedException {
        addTestRunPage.clickButton();
        Thread.sleep(5000);
        return addTestRunPage;
    }
}
