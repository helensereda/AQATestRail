package baseEntities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import services.WaitService;
import utils.configuration.ReadProperties;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitService waitService;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitService = new WaitService(driver);
    }
    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }
    protected abstract By getPageIdentifier();
    protected abstract By getTestRunsPage();
    protected abstract By getAddTestRunPage();
    protected abstract By getDialogTitle();
    protected abstract By getEnterPasswordTitle();
    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }
    public boolean isPopUpOpened() {
        return driver.findElement(getEnterPasswordTitle()).isDisplayed();
    }
    public boolean getTitleRunPage(){
        return waitService.waitForVisibility(driver.findElement(getTestRunsPage())).isDisplayed();
    }
    public boolean getTitleTestRunPage(){
        return waitService.waitForVisibility(driver.findElement(getAddTestRunPage())).isDisplayed();
    }
    public boolean isDialogTitleDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(getDialogTitle()).isDisplayed();
    }
}