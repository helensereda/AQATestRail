package tests.gui;

import baseEntities.BaseTest;
import elements.TableCell;
import io.qameta.allure.Description;
import lombok.extern.slf4j.Slf4j;
import models.Project;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import java.time.Instant;

public class PositiveTest extends BaseTest {
    static Logger logger = LogManager.getLogger(PositiveTest.class);
    @Test(description = "тест на проверку поля для ввода на граничные значения", groups = "regression", priority = 1)
    @Description("Positive test")
    public void BoundaryTest() throws InterruptedException{

        WaitService waitService = new WaitService(driver);
        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openPageByUrl();
        Assert.assertEquals(
                settingsStep.successChangePsw("World@4r").getSuccessTextElement().getText(),
                "Successfully saved your settings.");
        logger.info("success change password");
        Assert.assertEquals(
                settingsStep.incorrectChangePsw("Worl").getErrorTextElement().getText(),
                "Field Password is too short (5 characters required).");
        logger.error("error message for field Password");
        Assert.assertEquals(
                settingsStep.changePswWithLimited("1121231121211212311212112123112121121231121211" +
                                "21231121211212311212112123112121121231121211212311212112123112121121231" +
                                "121211212311").getErrorTextElement().getText(),
                        "Field Password is too long (128 characters at most).");
        logger.error("error message for field Password");
    }
    @Test(description = "тест на проверку всплывающего сообщения", groups = "regression", priority = 6)
    @Description("Positive test")
    public void PopUpWindowTest() {

        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        SettingsPage settingsPage = new SettingsPage(driver);
        settingsPage.openPageByUrl();
        settingsPage.showWindow("World@4r");
        Assert.assertTrue(driver.findElement(By.id("ui-dialog-title-userPasswordDialog")).isDisplayed());
        logger.info("pop-up window is displayed");
    }
    @Test(description = "тест на создание сущности", groups = {"smoke", "regression"}, priority = 4)
    @Description("Positive test")
    public void AddProjectBuilderTest()  {

        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        dashboardStep.addProject();
        Project ProjectBuilder = Project.builder()
                .name("Test")
                .announcement("Test")
                .build();
        System.out.println(ProjectBuilder);
        new AddProjectPage(driver).addProject(ProjectBuilder);
        addProjectStep.clickButton();
        logger.info("successful project creation");
    }
    @Test(description = "тест на удаление сущности", groups = {"smoke", "regression"}, priority = 5)
    @Description("Positive test")
    public void deleteProjectTest() throws InterruptedException {

        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.openPageByUrl();

        TableCell cell = projectsPage.getProjectsTable().getCell("Project", 1);
        cell.getDeleteLink().click();
        projectStep.deleteProject();
        logger.info("successful delete project");
    }
    @Test(description = "тест отображения диалогового окна", groups = "regression",priority = 2)
    @Description("Positive test")
    public void DisplayedDialogWindowTest() throws InterruptedException {

        loginStep.successLogin(
                ReadProperties.username(),
                ReadProperties.password()
        );
        ProjectsPage projectsPage = new ProjectsPage(driver);
        projectsPage.openPageByUrl();

        TableCell cell = projectsPage.getProjectsTable().getCell("Project", 1);
        cell.getDeleteLink().click();
        projectsPage.isDialogTitleDisplayed();
        logger.info("dialog window is displayed");
    }
    @Test(description = "тест на загрузку файла", groups = "regression", priority = 3)
    @Description("Positive test")
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
        WebElement fileUploadElement = waitService.waitForExists(By.xpath("//html/body/input[3]"));
        String pathToFile = PositiveTest.class.getClassLoader().getResource("download.jpeg").getPath();
        fileUploadElement.sendKeys(pathToFile.substring(1,pathToFile.length()));
        addTestRunPage.getButtonSubmit().click();
        Assert.assertTrue(waitService.waitForVisibility(driver.findElement(By.id("libraryDeleteAttachment"))).isDisplayed());
        logger.info("file is uploaded");
    }
}