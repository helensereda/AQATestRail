package tests.gui;
import baseEntities.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SettingsPage;
import utils.configuration.ReadProperties;
import io.qameta.allure.Description;

public class NegativeTests extends BaseTest {
    static Logger logger = LogManager.getLogger(NegativeTests.class);
    @Test(description = "тест на использование некорректных данных", groups = "regression")
    @Description("Negative test")
    public void incorrectDataTest() {
        Assert.assertEquals(
                loginStep.negativeLogin("test@mail.ru", ReadProperties.password()).getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.");
        logger.error("error message -  username is incorrect");
        Assert.assertEquals(
                loginStep.negativeLogin(ReadProperties.username(), "Q_12345").getErrorTextElement().getText(),
                "Email/Login or Password is incorrect. Please try again.",
                "");
        logger.error("error message -  password is incorrect");
    }
    @Test(description = "тест на ввод данных превышающих допустимые", groups = "regression")
    @Description("Negative test")
    public void incorrectPermissibleDataTest() throws InterruptedException {
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
        logger.error("error message -  incorrect change password");
    }
    @Test(description = "тест воспроизводящий любой дефект", groups = "regression")
    @Description("Negative test")
    public void screenShortTest() {
        Assert.assertTrue(false);
    }

}