package Pages.Register.MyAccount;

import LoggerUtility.LoggerUtility;
import ObjectData.RegisterPageObject;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "FirstName")
    private WebElement firstNameField;
    @FindBy(id = "LastName")
    private WebElement lastNameField;
    @FindBy(id = "Email")
    private WebElement emailField;
    @FindBy(xpath = "//li[2]//a[contains(text(),'Addresses')]")
    private WebElement addresses;
    @FindBy(xpath = "//li[3]//a[contains(text(),'Orders')]")
    private WebElement orders;
    @FindBy(xpath = "//li[4]//a[contains(text(),'Downloadable products')]")
    private WebElement downloadableProducts;
    @FindBy(xpath = "//li//a[contains(text(),'Back in stock subscriptions')]")
    private WebElement backInStockSubscriptions;
    @FindBy(xpath = "//li//a[contains(text(),'Reward points')]")
    private WebElement rewardPoints;
    @FindBy(xpath = "//li//a[contains(text(),'Change password')]")
    private WebElement changePassword;
    @FindBy(xpath = "//li//a[contains(text(),'My product reviews')]")
    private WebElement myProductReviews;
    @FindBy(css = "div[class='page-title']")
    private WebElement myAccountTitle;

    public void validateCustomerInfo(RegisterPageObject registerPageObject){
        elementMethods.validateElementValue(firstNameField, registerPageObject.getFirstName());
        LoggerUtility.info("The first name value has been validated with success.");
        elementMethods.validateElementValue(lastNameField, registerPageObject.getLastName());
        LoggerUtility.info("The last name value has been validated with success.");
        elementMethods.validateElementValue(emailField, registerPageObject.getEmail());
        LoggerUtility.info("The email field value has been validated with success.");
    }

    public void addressesnterract(){
        elementMethods.clickElement(addresses);
        LoggerUtility.info("The user clicks on Addresses.");
    }

    public void ordersInterract(){
        elementMethods.clickElement(orders);
        LoggerUtility.info("The user clicks on Orders.");
    }

    public void downloadableProductsInterract(){
        elementMethods.clickElement(downloadableProducts);
        LoggerUtility.info("The user clicks on Downloadable Products.");
    }

    public void backInStockSubscriptionsInterract(){
        elementMethods.clickElement(backInStockSubscriptions);
        LoggerUtility.info("The user clicks on Back In Stock Subscriptions.");
    }

    public void rewardPointsInterract(){
        elementMethods.clickElement(rewardPoints);
        LoggerUtility.info("The user clicks on Reward Points.");
    }

    public void changePasswordInterract(){
        elementMethods.clickElement(changePassword);
        LoggerUtility.info("The user clicks on Change My Password.");
    }

    public void myProductReviewsInterract(){
        elementMethods.clickElement(myProductReviews);
        LoggerUtility.info("The user clicks on My Product Reviews.");
    }

    public void validateTitlePresent(){
        elementMethods.validatePresenceElement(myAccountTitle);
        LoggerUtility.info("The user has been logged in successfully.");
    }
}
