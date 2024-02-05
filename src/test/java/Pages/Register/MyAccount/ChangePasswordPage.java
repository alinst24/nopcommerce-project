package Pages.Register.MyAccount;

import LoggerUtility.LoggerUtility;
import ObjectData.RegisterPageObject;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage {
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "OldPassword")
    private WebElement oldPasswordField;
    @FindBy(id = "NewPassword")
    private WebElement newPasswordField;
    @FindBy(id = "ConfirmNewPassword")
    private WebElement confirmNewPassword;
    @FindBy(xpath = "//button[contains(@class,'change-password-button')]")
    private WebElement submitButton;
    @FindBy(xpath = "//p[@class='content' and contains (text(),'Password was changed')]")
    private WebElement succesfulChangePassMessage;
    @FindBy(css = "span[class='close']")
    private WebElement closeButton;
    @FindBy(className = "ico-logout")
    private WebElement logOut;

    public void createNewPasswordMethod(RegisterPageObject registerPageObject){
        elementMethods.fillElement(oldPasswordField,registerPageObject.getPassword());
        LoggerUtility.info("The user fills old password field.");
        elementMethods.fillElement(newPasswordField,registerPageObject.getNewPassword());
        LoggerUtility.info("The user fills new password field.");
        elementMethods.fillElement(confirmNewPassword,registerPageObject.getNewPassword());
        LoggerUtility.info("The user fills confirm new password field.");
        elementMethods.clickElement(submitButton);
        LoggerUtility.info("The user clicks on submit button.");
    }

    public void validateNewPassword(){
        elementMethods.validatePresenceElement(succesfulChangePassMessage);
        LoggerUtility.info("The succesful changed password message has been validated with success.");
        elementMethods.clickJSelement(closeButton);
        LoggerUtility.info("The user clicks on close button.");
    }

    public void logoutSession(){
        elementMethods.clickJSelement(logOut);
        LoggerUtility.info("The user clicks on logout button.");
    }
}
