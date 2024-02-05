package Tests;

import ObjectData.ProductCartObject;
import Pages.HomePage;
import Pages.ProductCart.ProductCartPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class ProductCartTest extends Hooks {

    @Test
    public void testMethod(){

        ProductCartObject productCartObject = new ProductCartObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.electronicsInterract();

        ProductCartPage productCartPage = new ProductCartPage(getDriver());
        productCartPage.addToCart();
        productCartPage.cartValidation(productCartObject);
        productCartPage.checkoutProducts(productCartObject);
    }
}
