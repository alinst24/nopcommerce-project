package Pages.Register.MyAccount;

import LoggerUtility.LoggerUtility;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BackInStockSubscriptionsPage extends BasePage {
    public BackInStockSubscriptionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='no-data' and text()='You are not currently subscribed to any Back In Stock notification lists']")
    private WebElement noSubscribedMessage;

    public void validateNoSubscribedMessage(){
        elementMethods.validatePresenceElement(noSubscribedMessage);
        LoggerUtility.info("The no subscribed message has been validated with success.");
    }
}
