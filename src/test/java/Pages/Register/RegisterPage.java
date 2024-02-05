package Pages.Register;

import LoggerUtility.LoggerUtility;
import ObjectData.RegisterPageObject;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "gender-male")
    private WebElement gender;
    @FindBy(id = "FirstName")
    private WebElement firstName;
    @FindBy(id = "LastName")
    private WebElement lastName;
    @FindBy(id = "Email")
    private WebElement email;
    @FindBy(id = "Password")
    private WebElement password;
    @FindBy(id = "ConfirmPassword")
    private WebElement confirmpassword;
    @FindBy(id = "register-button")
    private WebElement registerButton;
    @FindBy(xpath = "//div[@class='result' and contains(text(), 'Your registration completed')]")
    private WebElement successRegisterMessage;
    @FindBy(xpath = "//a[contains(@class, 'button-1')]")
    private WebElement continueButton;
    @FindBy(className = "ico-login")
    private WebElement logInButtonHomepage;
    @FindBy(xpath = "//button[contains(@class, 'login-button')]")
    private WebElement loginButton;
    @FindBy(className = "ico-logout")
    private WebElement logoutButton;


    public void fillRegisterForm(RegisterPageObject registerPageObject){
        elementMethods.clickElement(gender);
        LoggerUtility.info("The user ticks the male gender box.");
        elementMethods.fillElement(firstName,registerPageObject.getFirstName());
        LoggerUtility.info("The user fills first name field with value : "+registerPageObject.getFirstName());
        elementMethods.fillElement(lastName,registerPageObject.getLastName());
        LoggerUtility.info("The user fills last name field with value : "+registerPageObject.getLastName());
        elementMethods.fillElement(email,registerPageObject.getEmail());
        LoggerUtility.info("The user fills email field with value :"+registerPageObject.getEmail());
        pageMethods.scrollByPixel(0,200);
        LoggerUtility.info("The user scrolls down the page.");
        elementMethods.fillElement(password,registerPageObject.getPassword());
        LoggerUtility.info("The user fills password field with value :"+registerPageObject.getPassword()+" .");
        elementMethods.fillElement(confirmpassword, registerPageObject.getPassword());
        LoggerUtility.info("The user fills confirm password field with value :"+registerPageObject.getPassword()+" .");
        elementMethods.clickElement(registerButton);
        LoggerUtility.info("The user clicks on Register button.");
        elementMethods.validatePresenceElement(successRegisterMessage);
        LoggerUtility.info("The succesful register message has been validated with success.");
        elementMethods.clickElement(continueButton);
        LoggerUtility.info("The user clicks on Continue button.");
    }

    public void logInAccount(RegisterPageObject registerPageObject){
        elementMethods.clickElement(logInButtonHomepage);
        LoggerUtility.info("The user clicks on login button.");
        elementMethods.fillElement(email,registerPageObject.getEmail());
        LoggerUtility.info("The user fills email field with value :"+registerPageObject.getEmail());
        elementMethods.fillElement(password,registerPageObject.getPassword());
        LoggerUtility.info("The user fills password field with value :"+registerPageObject.getPassword()+" .");
        elementMethods.clickElement(loginButton);
        LoggerUtility.info("The user clicks on Log In button.");
    }

    public void logInAccountWithNewCredentials(RegisterPageObject registerPageObject){
        elementMethods.clickJSelement(logInButtonHomepage);
        LoggerUtility.info("The user clicks on login button.");
        elementMethods.fillElement(email,registerPageObject.getNewEmail());
        LoggerUtility.info("The user fills email field with new value.");
        elementMethods.fillElement(password,registerPageObject.getNewPassword());
        LoggerUtility.info("The user fills password field with new value.");
        elementMethods.clickElement(loginButton);
        LoggerUtility.info("The user clicks on Log In button.");
    }
}
