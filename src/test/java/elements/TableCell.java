package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TableCell {
    private UIElement uiElement;
    private WebDriver driver;

    public TableCell(WebDriver driver, UIElement uiElement) {
        this.driver = driver;
        this.uiElement = uiElement;
    }

    public UIElement getDeleteLink() {
        return uiElement.findElement(By.xpath("//*[@id=\"content-inner\"]/table/tbody/tr[2]/td[3]/a/div"));
    }
}