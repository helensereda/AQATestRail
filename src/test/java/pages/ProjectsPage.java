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
    private final By checkboxLocator = By.xpath("//*[@id=\"deleteDialog\"]/div[2]/div/div");
    private final By deleteButtonLocator = By.xpath("//*[@id=\"deleteDialog\"]/div[3]/a[1]");
    // Блок инициализации
    public ProjectsPage(WebDriver driver) {
        super(driver);

    }

    @Override
    protected By getPageIdentifier() {
        return headerTitleLabelLocator;
    }

    @Override
    protected By getTitle() {
        return null;
    }

    @Override
    protected By getTitle1() {
        return null;
    }

    public void openPageByUrl() {
        super.openPageByUrl(pagePath);
    }

    // Блок атомарных методов
    public WebElement getHeaderTitle() {
        return driver.findElement(headerTitleLabelLocator);
    }
    public By getDialogTitle() {
        return dialogTitleLabelLocator;
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

    public void deleteProject() {
    getCheckbox().click();
    getDeleteButton().click();
    }
}