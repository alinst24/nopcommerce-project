package ShareData.Browser;

import LoggerUtility.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;
import java.util.HashMap;

public class EdgeBrowserService extends BaseBrowserService implements BrowserService {

    private WebDriver driver;

    @Override
    public void openBrowser(Boolean cicd) {
        EdgeOptions edgeOptions = (EdgeOptions) prepareBrowserOptions(cicd);
        driver = new EdgeDriver(edgeOptions);
        driver.get(getBrowserOptions().get("url"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        LoggerUtility.info("The browser was opened with succes.");
    }

    @Override
    public void closeBrowser() {
        driver.quit();
        LoggerUtility.info("The browser was closed with succes.");
    }

    @Override
    public Object prepareBrowserOptions(Boolean cicd) {
        HashMap<String, String> testData = getBrowserOptions();
        EdgeOptions edgeOptions = new EdgeOptions();
        if (cicd) {
            edgeOptions.addArguments("--headless");
        }
        if (!testData.get("headless").isEmpty()) {
            edgeOptions.addArguments(testData.get("headless"));
        }
        edgeOptions.addArguments(testData.get("gpu"));
        edgeOptions.addArguments(testData.get("infobars"));
        edgeOptions.addArguments(testData.get("sandbox"));
        edgeOptions.addArguments(testData.get("resolution"));
        return edgeOptions;
    }

    public WebDriver getDriver() {
        return driver;
    }
}

