package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddTestRunPage;
import pages.SettingsPage;
import services.WaitService;
import utils.configuration.ReadProperties;
import org.openqa.selenium.WebElement;


public class PositiveTest extends BaseTest {
    @Test
    public void BoundaryTest() throws InterruptedException{
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openPageByUrl();
        Assert.assertEquals(
                settingsStep.successChangePsw("World@4r").getSuccessTextElement().getText(),
                "Successfully saved your settings.");
    }

    @Test
    public void FileUploadTest() throws InterruptedException {
        Assert.assertTrue(
                loginStep.successLogin(ReadProperties.username(), ReadProperties.password()
                ).isPageOpened()
        );
        Assert.assertTrue(
                dashboardStep.addCase().getTitleInfo()
        );
        Assert.assertTrue(
                testStep.addTest().getTitleCase()
        );
                addTestRunStep.addFile();
//        WaitService waitService = new WaitService(driver);
//        AddTestRunPage addTestRunPage = new AddTestRunPage(driver);
//        //WebElement fileUploadElement = waitService.waitForExists(By.id("libraryAttachmentsAddItem"));
//        new WebDriverWait (driver, 20).until(ExpectedConditions.elementToBeClickable(By.id("libraryAddAttachment"))).click();
//        String pathToFile = PositiveTest.class.getResource("/resources/download.jpeg").getPath();
//        addTestRunPage.sendKeys(pathToFile.substring(1,pathToFile.length()));
//        addTestRunPage.getButtonSubmit().click();
//        Assert.assertEquals("download.jpeg",addTestRunPage.getLabelUploaded().getText());
    }
}