package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestPage extends BasePage {
    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Test')]");
    private final By addTestRunLocator = By.xpath("//*[@id=\"navigation-overview-addrunssuite\"]");
    public TestPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    @Override
    protected By getTitle() {
        return headerTitleLabelLocator;
    }

    @Override
    protected By getTitle1() {
        return null;
    }

    @Override
    protected By getDialogTitle() {
        return null;
    }

    public WebElement getClickButton() {
        return driver.findElement(addTestRunLocator);
    }
    // Блок комплексных методов
    public void clickButton() {
        getClickButton().click();
    }
}