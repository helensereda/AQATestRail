package baseEntities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.configuration.ReadProperties;

public abstract class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUrl() + pagePath);
    }

    protected abstract By getPageIdentifier();
    protected abstract By getTitle();
    protected abstract By getTitle1();

    public boolean isPageOpened() {
        return driver.findElement(getPageIdentifier()).isDisplayed();
    }
    public boolean getTitleInfo() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(getTitle()).isDisplayed();
    }
    public boolean getTitleCase() throws InterruptedException {
        Thread.sleep(2000);
        return driver.findElement(getTitle1()).isDisplayed();
    }
}