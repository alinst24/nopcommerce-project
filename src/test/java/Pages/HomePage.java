package Pages;

import LoggerUtility.LoggerUtility;
import ObjectData.HomepageObject;
import ObjectData.SearchObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "img[alt='nopCommerce demo store']")
    private WebElement logo;

    @FindBy(css = "ul[class='top-menu notmobile']")
    private WebElement productsmenu;

    @FindBy(xpath = "//h2[text()='Welcome to our store']")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//strong[text()='Featured products']")
    private WebElement featuredProductsMessage;

    @FindBy(id = "nivo-slider")
    private WebElement sliderElement;

    @FindBy(xpath = ".//div[@id='nivo-slider']//img[contains(@class, 'nivo-main-image')]")
    private List<WebElement> sliderImages;

    public void validateHomePage(HomepageObject homepageObject) {
        elementMethods.validatePresence(logo);
        LoggerUtility.info("The logo has been identified.");
        elementMethods.validatePresence(productsmenu);
        LoggerUtility.info("The products menu has been identified.");
        elementMethods.validateBannerImages(sliderElement, sliderImages);
        LoggerUtility.info("The banner slider has been validated with success.");
        elementMethods.validateMessage(welcomeMessage, homepageObject.getWelcomeMessage());
        LoggerUtility.info("The welcome message has been identified: " + homepageObject.getWelcomeMessage());
        elementMethods.scrollByPixel(0, 200);
        LoggerUtility.info("Scrolling down by 200 pixels.");
        elementMethods.validateMessage(featuredProductsMessage, homepageObject.getFeaturedProductsMessage());
        LoggerUtility.info("The welcome featured products message has been identified: " + homepageObject.getFeaturedProductsMessage());
    }

}