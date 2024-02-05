package Pages.Register.MyAccount;

import LoggerUtility.LoggerUtility;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderPage extends BasePage {
    public OrderPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='no-data'][text()='No orders']")
    private WebElement noOrders;

    public void validateNoOrders(){
        elementMethods.validateMessage(noOrders,"No orders");
        LoggerUtility.info("The no orders message has been validated with succes.");
    }
}
