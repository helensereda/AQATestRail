package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTestRunPage extends BasePage {
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Test Run')]");
    private final By addFileLocator = By.id("entityAttachmentListEmptyIcon");
    public AddTestRunPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    @Override
    protected By getTestRunsPage() {
        return null;
    }

    @Override
    protected By getAddTestRunPage() {
        return headerTitleLabelLocator;
    }

    @Override
    protected By getDialogTitle() {
        return null;
    }

    @Override
    protected By getEnterPasswordTitle() {
        return null;
    }

    // Блок атомарных методов
    public WebElement getFileButton() {
        return driver.findElement(addFileLocator);
    }

    // Блок комплексных методов
    public void clickButton() {
        getFileButton().click();
    };
}
