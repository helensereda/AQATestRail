package tests;

import baseEntities.BaseTest;
import elements.TableCell;
import models.Project;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddProjectPage;
import pages.AddTestRunPage;
import pages.ProjectsPage;
import pages.SettingsPage;
import services.WaitService;
import utils.configuration.ReadProperties;
import org.openqa.selenium.WebElement;

import java.time.Duration;


public class PositiveTest extends BaseTest {
    //тест на проверку поля для ввода на граничные значения
    @Test  (groups = "regression")
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
        Assert.assertEquals(

                settingsStep.successChangePsw("Worl").getErrorTextElement().getText(),
                "Field Password is too short (5 characters required).");
    }
    //тест на проверку всплывающего сообщения
    @Test (groups = "regression")
    public void PopUpWindowTest() {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openPageByUrl();
        settingsPage.showWindow("World@4r");
        Assert.assertTrue(driver.findElement(By.id("ui-dialog-title-userPasswordDialog")).isDisplayed());
    }
    //тест на создание сущности
    @Test (groups = {"smoke", "regression"})
    public void AddProjectBuilderTest() throws InterruptedException {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        dashboardStep.addProject();
        Project ProjectBuilder = new Project.Builder()
                .withProjectName("Test")
                .withAnnouncement("Test")
                .build();
        Thread.sleep(5000);
       addProjectStep.clickButton();
    }
    //тест на удаление сущности
    @Test (groups = {"smoke", "regression"})
    public void deleteProjectTest() throws InterruptedException {
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );

        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.openPageByUrl();

        TableCell cell = projectsPage.getProjectsTable().getCell("Project", 1);
        cell.getDeleteLink().click();
        Thread.sleep(3000);
        projectStep.deleteProject();
    }
    //тест на загрузку файла
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
        WaitService waitService = new WaitService(driver);
        AddTestRunPage addTestRunPage = new AddTestRunPage(driver);
        WebElement fileUploadElement = waitService.waitForExists(By.xpath("//*[@id=\"libraryAddAttachment\"]"));
        String pathToFile = PositiveTest.class.getClassLoader().getResource("download.jpeg").getPath();
        System.out.println(pathToFile);
    //    fileUploadElement.sendKeys(pathToFile.substring(1,pathToFile.length()));
    //    addTestRunPage.getButtonSubmit().click();
    //    Assert.assertEquals("download.jpeg",addTestRunPage.getLabelUploaded().getText());
    //    Thread.sleep(3000);
    //    WebElement browse = driver.findElement(By.xpath("//*[@id=\"libraryAddAttachment\"]"));
    //    browse.sendKeys(pathToFile);
    }
}