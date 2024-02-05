package Pages;

import LoggerUtility.LoggerUtility;
import ObjectData.HomepageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    @FindBy(xpath = "//div//ul[1]/li[2]//a[contains(text(),'Electronics')]")
    private WebElement electronicsCategory;

    @FindBy(xpath = "//div[contains(@class,'header-menu')]/ul[1]//li[2]//a[contains(text(),'Camera & photo')]")
    private WebElement cameraAndPhotoSubcategory;

    @FindBy(css = "a[class='ico-register']")
    private WebElement register;

    @FindBy(className = "ico-account")
    private WebElement myAccount;

    public void validateHomePage(HomepageObject homepageObject) {
        elementMethods.validatePresenceElement(logo);
        LoggerUtility.info("The logo has been identified.");
        elementMethods.validatePresenceElement(productsmenu);
        LoggerUtility.info("The products menu has been identified.");
        elementMethods.validateBannerImages(sliderElement, sliderImages);
        LoggerUtility.info("The banner slider has been validated with success.");
        elementMethods.validateMessage(welcomeMessage, homepageObject.getWelcomeMessage());
        LoggerUtility.info("The welcome message has been identified: " + homepageObject.getWelcomeMessage());
        pageMethods.scrollByPixel(0, 200);
        LoggerUtility.info("Scrolling down by 200 pixels.");
        elementMethods.validateMessage(featuredProductsMessage, homepageObject.getFeaturedProductsMessage());
        LoggerUtility.info("The welcome featured products message has been identified: " + homepageObject.getFeaturedProductsMessage());
    }

    public void electronicsInterract(){
        elementMethods.hover(electronicsCategory);
        LoggerUtility.info("The user hovers the mouse over the element :" +electronicsCategory.getText() +" .");
        elementMethods.clickElement(cameraAndPhotoSubcategory);
        LoggerUtility.info("The user clicks on the first result of subcategory.");
    }

    public void registerInterract(){
        elementMethods.clickJSelement(register);
        LoggerUtility.info("The user clicks on the register button.");
    }

    public void myAccountInterract(){
        elementMethods.clickElement(myAccount);
        LoggerUtility.info("The user clicks on my account button.");
    }
}