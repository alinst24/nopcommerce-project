package ShareData;

import LoggerUtility.LoggerUtility;
import ShareData.Browser.BrowserFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ShareData {

    private WebDriver driver;

    public void setup(){
        driver = new BrowserFactory().getBrowserDriver();
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("window.scrollBy(0,450)");
    }

    public void clear(){
        driver.quit();
        LoggerUtility.info("The browser was closed with success.");
    }

    public WebDriver getDriver() {
        return driver;
    }
}
