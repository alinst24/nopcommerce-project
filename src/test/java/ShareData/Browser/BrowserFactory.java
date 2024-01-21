package ShareData.Browser;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class BrowserFactory {

    public WebDriver getBrowserDriver() {
        Boolean cicd = Boolean.parseBoolean(System.getProperty("cicd"));
        String browser = null;
        if (cicd) {
            browser = System.getProperty("browser");
        } else {
            HashMap<String, String> testData = new BaseBrowserService().getBrowserOptions();
            browser = testData.get("browser");
        }
        switch (browser) {
            case "chrome":
                ChromeBrowserService chromeBrowserService = new ChromeBrowserService();
                chromeBrowserService.openBrowser(cicd);
                return chromeBrowserService.getDriver();
            case "edge":
                EdgeBrowserService edgeBrowserService = new EdgeBrowserService();
                edgeBrowserService.openBrowser(cicd);
                return edgeBrowserService.getDriver();
            case "firefox":
                FirefoxBrowserService firefoxBrowserService = new FirefoxBrowserService();
                firefoxBrowserService.openBrowser(cicd);
                return firefoxBrowserService.getDriver();
        }
        return null;
    }
}
