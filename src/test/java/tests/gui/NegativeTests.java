package tests.gui;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SettingsPage;
import utils.configuration.ReadProperties;

public class NegativeTests extends BaseTest {

    @Test
    public void incorrectDateTest() {
        Assert.assertEquals(
                loginStep.negativeLogin("test@mail.ru", ReadProperties.password()).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again."
        );

        Assert.assertEquals(
                loginStep.negativeLogin(ReadProperties.username(), "Q_12345").getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "");
    }


    @Test
    public void incorrectPermissibleDateTest() throws InterruptedException {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openPageByUrl();
        Assert.assertEquals(

                settingsStep.incorrectChangePsw("1121231121211212311212112123112121121231121211" +
                        "21231121211212311212112123112121121231121211212311212112123112121121231" +
                        "121211212311").getErrorTextElement().getText(),
                "Field Password is too long (128 characters at most).");

    }

    @Test
    public void screenShortTest() {
        Assert.assertTrue(false);
    }

}