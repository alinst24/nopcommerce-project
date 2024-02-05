package Pages.Register.MyAccount;

import LoggerUtility.LoggerUtility;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RewardPointsPage extends BasePage{
    public RewardPointsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='current-balance' and text()='Your current balance is 0 reward points ($0.00).']")
    private WebElement currentBalanceEmpty;
    @FindBy(xpath = "//div[@class='no-data' and text()='There is no balance history yet']")
    private WebElement noBalanceHistory;

    public void validateRewardPoints(){
        elementMethods.validatePresenceElement(currentBalanceEmpty);
        LoggerUtility.info("The current balance message has been validated with success.");
        elementMethods.validatePresenceElement(noBalanceHistory);
        LoggerUtility.info("The balance history message has been validated with success.");
    }
}
