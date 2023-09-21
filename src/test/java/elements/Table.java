package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private UIElement uiElement;
    private WebDriver driver;
    private List<String> columns;

    /**
     * Данный элемент идентифицируется по тэгу <table></table>
     * @param driver
     * @param by
     */
    public Table(WebDriver driver, By by) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, by);
        this.columns = new ArrayList<>();

        for (UIElement element : uiElement.findUIElements(By.tagName("th"))) {
            columns.add(element.getText());
        }
    }

    public Table(WebDriver driver, WebElement webElement) {
        this.driver = driver;
        this.uiElement = new UIElement(driver, webElement);
    }

    public TableCell getCell(int columnIndex, int rowIndex) {
        TableRow tableRow = getRow(rowIndex);
        return tableRow.getCell(columnIndex);
    }

    public TableCell getCell(String columnName, int rowIndex) {
        int columnIndex = columns.indexOf(columnName);
        return getCell(columnIndex, rowIndex);
    }

    /**
     * Данный метод получает все строки включая Header строку. Поэтому индекс будет считаться с четом этой строки
     * @param index
     * @return
     */
    public TableRow getRow(int index) {
        ArrayList<UIElement> list = (ArrayList<UIElement>) uiElement.findUIElements(By.tagName("tr"));
        return new TableRow(driver, list.get(index));
    }

    public TableCell getCell(String targetColumnName, String uniqueValue, String expectedColumnName) {
        int columnIndex = columns.indexOf(targetColumnName);

        return null;
    }
}