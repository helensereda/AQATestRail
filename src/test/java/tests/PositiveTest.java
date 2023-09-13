package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddTestRunPage;
import services.WaitService;
import utils.configuration.ReadProperties;
import org.openqa.selenium.WebElement;

public class PositiveTest extends BaseTest {

    @Test
    public void successLoginTest() throws InterruptedException {
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
        WaitService waitService = new WaitService(driver);
        AddTestRunPage addTestRunPage = new AddTestRunPage(driver);
        WebElement fileUploadElement = waitService.waitForExists(By.id("libraryAttachmentsAddItem"));
        String pathToFile = PositiveTest.class.getClassLoader().getResource("download.jpeg").getPath();
        fileUploadElement.sendKeys(pathToFile.substring(1,pathToFile.length()));
        addTestRunPage.getButtonSubmit().click();
        Assert.assertEquals("download.jpeg",addTestRunPage.getLabelUploaded().getText());
    }
}