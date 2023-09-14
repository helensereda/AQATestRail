package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SettingsPage extends BasePage {
    private final static String pagePath = "/index.php?/mysettings";
    // Блок описания локаторов для элементов
    private final By pswInputLocator = By.id("password");
    private final By confirmInputLocator = By.id("confirm");
    private final By saveButtonLocator = By.id("accept");
    private final By enterPswInputLocator = By.id("userPassword");
    private final By okButtonLocator = By.id("userPasswordSubmit");
    private final By successTextLocator = By.className("message-success");
    // Блок инициализации
    public SettingsPage(WebDriver driver) {
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
    //Блок комплексных методов
    public void changePsw(String psw) {
        getPswInput().sendKeys(psw);
        getConfirmInput().sendKeys(psw);
        getSaveButton().click();
        getEnterPswInput().sendKeys(psw);
        getOkButton().click();
    }
}
