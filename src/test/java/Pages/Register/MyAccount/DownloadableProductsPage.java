package Pages.Register.MyAccount;

import LoggerUtility.LoggerUtility;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DownloadableProductsPage extends BasePage {
    public DownloadableProductsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='no-data' and text()='There are no downloadable products']")
    private WebElement noDownloadableProductsMessage;

    public void validateNoDownloadableProductsMessage(){
        elementMethods.validatePresenceElement(noDownloadableProductsMessage);
        LoggerUtility.info("The no downloadable products message has been validated with success.");
    }
}
