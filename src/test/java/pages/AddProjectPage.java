package pages;

import baseEntities.BasePage;
import models.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Date;

public class AddProjectPage extends BasePage {
    private final static String pagePath = "/index.php?/dashboard/";

    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.xpath("//div[contains(@class, 'content-header-title') and contains(text(), 'Add Project')]");
    private final By nameLocator = By.id("name");
    private final By announcementLocator = By.id("announcement_display");
    private final By addProjectButtonLocator = By.id("accept");
    // Блок инициализации
    public AddProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    @Override
    protected By getTestRunsPage() {
        return null;
    }

    @Override
    protected By getAddTestRunPage() {
        return null;
    }

    @Override
    protected By getDialogTitle() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleLabelLocator);
    }
    public WebElement getName() {
        return driver.findElement(nameLocator);
    }
    public WebElement getAnnouncement() {
        return driver.findElement(announcementLocator);
    }
    public WebElement getAddProjectButton() {
        return driver.findElement(addProjectButtonLocator);
    }
    public void setName(String value) {
        getName().sendKeys(value);
    }
    public void setAnnouncement(String value) {
        getAnnouncement().sendKeys(value);
    }
    public void addProject(Project project) {
        setName(project.getName());
        setAnnouncement(project.getAnnouncement());
    }
    public void clickAddProject(){
        getAddProjectButton().click();
    }
}