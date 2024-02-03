package Tests;

import Pages.HomePage;
import Pages.ProductCart.ProductCartPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class ProductCartTest extends Hooks {

    @Test
    public void testMethod(){

        HomePage homePage = new HomePage(getDriver());
        homePage.electronicsInterract();

        ProductCartPage productCartPage = new ProductCartPage(getDriver());
        productCartPage.addToCart();
        productCartPage.cartValidation();
        productCartPage.checkoutProducts();
    }
}
