package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddTestRunPage extends BasePage {
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Test Run')]");
    private final By addFileLocator = By.id("entityAttachmentListEmptyIcon");
    private final By addNewLocator = By.id("libraryAddAttachment");
    private final By buttonSubmitLocator = (By.id("attachmentNewSubmit"));
    private final By labelUploadedLocator = By.id("attachment-1f014b13-5656-4ecc-84c3-234c571e6c12");
    private final By attachmentSelectedLocator = By.className("attachment-selected");

    public AddTestRunPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return null;
    }

    @Override
    protected By getTitle() {
        return null;
    }

    @Override
    protected By getTitle1() {
        return headerTitleLabelLocator;
    }

    @Override
    protected By getDialogTitle() {
        return null;
    }

    // Блок атомарных методов
    public WebElement getFileButton() {
        return driver.findElement(addFileLocator);
    }

    public WebElement getNewButton() {
        return driver.findElement(addNewLocator);
    }

    public WebElement getButtonSubmit() {
        return waitService.waitForExists(buttonSubmitLocator);
    }

    public WebElement getAttachmentSelected() {
        return waitService.waitForExists(attachmentSelectedLocator);
    }

    public WebElement getLabelUploaded() {
        return waitService.waitForExists(labelUploadedLocator);
    }

    // Блок комплексных методов
    public void clickButton() {
        getFileButton().click();
        //getNewButton().click();
    }
}
