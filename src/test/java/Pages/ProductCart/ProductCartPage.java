package Pages.ProductCart;

import LoggerUtility.LoggerUtility;
import ObjectData.ProductCartObject;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCartPage extends BasePage {
    public ProductCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-productid='16']//button[contains(@class,'product-box-add-to-cart-button')]")
    private WebElement addtoCartThirdProduct;
    @FindBy(css = "p[class='content']")
    private WebElement succesMessage;
    @FindBy(css = "span[class='close']")
    private WebElement close;
    @FindBy(css = "span[class='cart-label']")
    private WebElement cart;
    @FindBy(xpath = "//a[@class='product-name' and contains(text(),'Leica T Mirrorless Digital Camera')]")
    private WebElement addedtoCartProduct;
    @FindBy(xpath = "//span[@class='value-summary']/strong[text()='$530.00']")
    private WebElement updatedPrice;
    @FindBy(id = "checkout_attribute_1")
    private WebElement giftWrapping;
    @FindBy(id = "discountcouponcode")
    private WebElement enterCoupon;
    @FindBy(id = "applydiscountcouponcode")
    private WebElement applyCoupon;
    @FindBy(xpath = "//div[@class='message-failure' and contains(text(), 'The coupon code cannot be found')]")
    private WebElement failureCouponMessage;
    @FindBy(xpath = "//span[@class='value-summary']/strong[text()='$540.00']")
    private WebElement updatedPriceGiftWrap;
    @FindBy(id = "termsofservice")
    private WebElement termsofservice;
    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public void addToCart(){
        elementMethods.clickElement(addtoCartThirdProduct);
        LoggerUtility.info("The user adds to cart third product on the page.");
        elementMethods.validatePresenceElement(succesMessage);
        LoggerUtility.info("The item has been added to cart and successful message has been displayed.");
        elementMethods.clickElement(close);
        LoggerUtility.info("The user closes the displayed message.");
    }

    public void cartValidation(ProductCartObject productCartObject){
        elementMethods.clickJSelement(cart);
        LoggerUtility.info("The user clicks on shopping cart.");
        elementMethods.validatePresenceElement(addedtoCartProduct);
        LoggerUtility.info("The item added to cart has been validated with success.");
        elementMethods.validatePresenceElement(updatedPrice);
        LoggerUtility.info("The updated total price has been validated with success.");
        elementMethods.dropDownInterract(giftWrapping,1);
        LoggerUtility.info("The user selects gift wrapping option(YES).");
        elementMethods.fillElement(enterCoupon,productCartObject.getCupon());
        LoggerUtility.info("The user enters the coupon code : " +productCartObject.getCupon()+" .");
        elementMethods.clickElement(applyCoupon);
        LoggerUtility.info("The user clicks on APPLY COUPON.");
        elementMethods.validatePresenceElement(failureCouponMessage);
        LoggerUtility.info("The failure message for coupons is displayed: "+failureCouponMessage.getText()+" .");
        elementMethods.validatePresenceElement(updatedPriceGiftWrap);
        LoggerUtility.info("The updated total price with gift wrap option has been validated with success.");
    }

    public void checkoutProducts(ProductCartObject productCartObject){
        elementMethods.clickElement(termsofservice);
        LoggerUtility.info("The user ticks the box of terms and conditions.");
        elementMethods.clickElement(checkoutButton);
        LoggerUtility.info("The user clicks on Checkout Button.");
        pageMethods.validatePage(productCartObject.getUrl());
        LoggerUtility.info("The redirection URL has been validated: "+productCartObject.getUrl());
    }
}
