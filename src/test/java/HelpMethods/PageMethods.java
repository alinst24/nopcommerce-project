package HelpMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PageMethods {

    private WebDriver driver;

    public PageMethods(WebDriver driver){
        this.driver=driver;
    }

    public void validatePage(String url){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(url));
        String currentUrl=driver.getCurrentUrl();
        Assert.assertEquals(currentUrl,url,"Redirection did not occur to the correct URL.");
    }

    public void scrollByPixel(Integer x, Integer y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(" + x + "," + y + ")", "");
    }

    public void clickBack() {
        driver.navigate().back();
    }

    public void accesUrl(String urlValue) {
        driver.navigate().to(urlValue);
    }
}
