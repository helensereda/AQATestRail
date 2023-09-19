package baseEntities;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.UUID;
public class Listener extends BaseTest implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            ITestContext iTestContext = result.getTestContext();
            WebDriver driver = (WebDriver) iTestContext.getAttribute("WebDriver");
            try {
                byte[] srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                saveScreenshot(srcFile);
            } catch (NoSuchSessionException ex) {

            }
        } catch (Exception ex) {

        }
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot) {
        return screenshot;
    }
    @Attachment(value = "{0}", type = "text/plain")
    private static String saveTextLog(String message) {
        return message;
    }
}