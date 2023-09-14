package steps;

import baseEntities.BaseStep;
import org.openqa.selenium.WebDriver;
import pages.DashboardPage;
import pages.SettingsPage;

public class SettingsStep extends BaseStep {

    public SettingsStep(WebDriver driver) {
            super(driver);
        }
    public SettingsPage successChangePsw(String psw) {
        settingsPage.changePsw(psw);

        return settingsPage;
    }
    }

