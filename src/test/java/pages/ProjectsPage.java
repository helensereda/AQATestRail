package pages;

import baseEntities.BasePage;
import elements.Table;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProjectsPage extends BasePage {
    private final static String pagePath = "/index.php?/admin/projects/overview";
    // Блок описания локаторов для элементов
    private final By headerTitleLabelLocator = By.className("page_title");
    private final By dialogTitleLabelLocator = By.className("ui-dialog-title");
    private final By projectsTableLocator = By.cssSelector("#content-inner table");
    private final By checkboxLocator = By.xpath("(//input[@type='checkbox'])[7]");
    private final By deleteButtonLocator = By.xpath("(//a[contains(text(),'OK')])[3]");
    // Блок инициализации
    public ProjectsPage(WebDriver driver) {
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

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public By getDialogTitle() {
        return dialogTitleLabelLocator;
    }

    @Override
    protected By getEnterPasswordTitle() {
        return null;
    }

    public WebElement getCheckbox() {
        return driver.findElement(checkboxLocator);
    }
    public WebElement getDeleteButton() {
        return driver.findElement(deleteButtonLocator);
    }
    public Table getProjectsTable() {
        return new Table(driver, projectsTableLocator);
    }

    public void deleteProject() throws InterruptedException {
    Thread.sleep(5000);
    getCheckbox().click();
    getDeleteButton().click();
    }
}