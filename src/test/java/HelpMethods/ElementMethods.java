package HelpMethods;

import LoggerUtility.LoggerUtility;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ElementMethods {

    private WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitVisibleElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void validatePresence(WebElement element){
        waitVisibleElement(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void validateMessage(WebElement element,String value){
        waitVisibleElement(element);
        String actualMessage=element.getText();
        Assert.assertEquals(actualMessage,value);
    }

    public void scrollByPixel(Integer x, Integer y){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")","");
    }

    public void clickElement(WebElement element){
        waitVisibleElement(element);
        element.click();
    }

    public void fillElement(WebElement element, String value, Keys keyboardButton){
        waitVisibleElement(element);
        element.sendKeys(value);
        element.sendKeys(keyboardButton);
    }

    public void validateTable(String elementValue,Integer expectedResults) {
        List<WebElement> elementsList = driver.findElements(By.cssSelector(elementValue));
        Assert.assertEquals(elementsList.size(),expectedResults, "The table does not contain the exact amount of results.");
    }

    public void clickBack(){
        driver.navigate().back();
    }
}
