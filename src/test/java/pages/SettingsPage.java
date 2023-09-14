package pages;

import baseEntities.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SettingsPage extends BasePage {
    private final static String pagePath = "/index.php?/mysettings";
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

}
