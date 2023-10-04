package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.SettingsPage;

public class SettingsStep extends BaseStep {
    public SettingsStep(WebDriver driver) {
        super(driver);
    }

    public SettingsPage successChangePsw(String psw) throws InterruptedException {
        settingsPage.changePsw(psw);

        return settingsPage;
    }

    public SettingsPage showWindow(String psw)  {
        settingsPage.showWindow(psw);

        return settingsPage;
    }

    public SettingsPage incorrectChangePsw(String psw) throws InterruptedException {
        settingsPage.changePsw(psw);

        return settingsPage;
    }

    public SettingsPage changePswWithLimited(String psw) throws InterruptedException {
        settingsPage.changePswWithLimited(psw);
        return settingsPage;
    }

    public SettingsPage showPopUp()  {
        settingsPage.isPopUpOpened();
        return settingsPage;
    }
}

