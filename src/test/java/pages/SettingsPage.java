package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage extends BasePage {
    private final static String pagePath = "/index.php?/mysettings";
    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'ui-dialog-title') and contains(text(), 'Enter Password')]");
    private final By pswInputLocator = By.id("password");
    private final By confirmInputLocator = By.id("confirm");
    private final By saveButtonLocator = By.id("accept");
    private final By enterPswInputLocator = By.id("userPassword");
    private final By okButtonLocator = By.id("userPasswordSubmit");
    private final By successTextLocator = By.className("message-success");
    private final By errorTextLocator = By.id("userPasswordErrors");
    // Блок инициализации
    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    @Override
    protected By getTitle() {
        return null;
    }

    @Override
    protected By getTitle1() {
        return null;
    }

    @Override
    protected By getDialogTitle() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }
    public WebElement getPswInput() {
        return driver.findElement(pswInputLocator);
    }
    public WebElement getConfirmInput() {
        return driver.findElement(confirmInputLocator);
    }
    public WebElement getSaveButton() {
        return driver.findElement(saveButtonLocator);
    }
    public WebElement getEnterPswInput() {
        return driver.findElement(enterPswInputLocator);
    }
    public WebElement getOkButton() {
        return driver.findElement(okButtonLocator);
    }
    public WebElement getSuccessTextElement() {
        return driver.findElement(successTextLocator);
    }


    public WebElement getErrorTextElement() {
        return driver.findElement(errorTextLocator);
    }
    //Блок комплексных методов
    public void changePsw(String psw) throws InterruptedException {
        getPswInput().sendKeys(psw);
        getConfirmInput().sendKeys(psw);
        getSaveButton().click();
        getEnterPswInput().sendKeys(psw);
        Thread.sleep(5000);
        getOkButton().click();
        Thread.sleep(5000);
    }
    public void showWindow(String psw){
        getPswInput().sendKeys(psw);
        getConfirmInput().sendKeys(psw);
        getSaveButton().click();
    }
}