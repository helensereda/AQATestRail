package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.AddTestRunPage;
import services.WaitService;

public class AddTestRunStep extends BaseStep {
    WaitService waitService = new WaitService(driver);
    public AddTestRunStep(WebDriver driver) {
        super(driver);
    }

    public AddTestRunPage addFile() throws InterruptedException {
        addTestRunPage.clickButton();
        Thread.sleep(3000);
        return addTestRunPage;
    }

    public AddTestRunPage uploadAvatar(String path) {
        waitService.waitForExists(By.xpath("//html/body/input[3]")).sendKeys(path);

        return addTestRunPage;
    }

    public boolean isDisplayedButtonDelete() {
        waitService.waitForVisibility(driver.findElement(By.id("libraryDeleteAttachment"))).isDisplayed();

        return true;
    }
}
