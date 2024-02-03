package HelpMethods;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ElementMethods {

    private WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitVisibleElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));                         //Un element poate fi vizibil dar nu si clickable
    }

    public void waitVisibleAndClickableElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element),ExpectedConditions.elementToBeClickable(element)));      // metoda folosita pentru a astepta vizibilitatea si capacitatea de a da click pe un element
    }

    public void clickJSelement(WebElement element){
        waitVisibleElement(element);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    public void validatePresenceElement(WebElement element) {
        waitVisibleElement(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void validateMessage(WebElement element, String value) {
        waitVisibleElement(element);
        String actualMessage = element.getText();
        Assert.assertEquals(actualMessage, value);
    }

    public void clickElement(WebElement element) {
        waitVisibleElement(element);
        element.click();
    }

    public void fillElement(WebElement element, String value, Keys keyboardButton) {
        waitVisibleElement(element);
        element.sendKeys(value);
        element.sendKeys(keyboardButton);
    }

    public void fillElement(WebElement element, String value, WebElement element2) {
        waitVisibleElement(element);
        element.sendKeys(value);
        element2.click();
    }

    public void fillElement(WebElement element, String value) {
        waitVisibleElement(element);
        element.sendKeys(value);
    }

    public void validateTable(String elementValue, Integer expectedResults) {
        List<WebElement> elementsList = driver.findElements(By.cssSelector(elementValue));
        Assert.assertEquals(elementsList.size(), expectedResults, "The table does not contain the exact amount of results.");
    }

    public void validateBannerImages(WebElement sliderElement, List<WebElement> sliderImages) {
        Assert.assertTrue(sliderImages.size() >= 1, "Banner slider doesn't contain at least an image.");

        for (WebElement image : sliderImages) {
            String srcAttribute = image.getAttribute("src");
            if (srcAttribute.contains("banner_01")) {
                return; // Ieșim din metoda în cazul găsirii "banner_01"
            }
        }
        // Dacă nu găsim "banner_01", continuăm căutarea pentru "banner_02"
        for (WebElement image : sliderImages) {
            String srcAttribute = image.getAttribute("src");
            if (srcAttribute.contains("banner_02")) {
                return; // Ieșim din metoda în cazul găsirii "banner_02"
            }
        }
        // Dacă ajungem aici, înseamnă că nu am găsit nicio imagine așteptată
        Assert.fail("No image named: banner_01 or banner_02 has been found in slider");
    }

    public void deleteContextElement(WebElement element) {
        waitVisibleElement(element);
        element.clear();
    }

    public void dropDownInterract(WebElement element, Integer index) {
        waitVisibleElement(element);
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
    }

    public void hover(WebElement element){
        waitVisibleElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }
}

