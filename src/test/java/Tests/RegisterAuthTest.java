package Tests;

import ObjectData.RegisterPageObject;
import Pages.HomePage;
import Pages.Register.MyAccount.*;
import Pages.Register.RegisterPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class RegisterAuthTest extends Hooks {

    @Test
    public void testMethod() {

        RegisterPageObject registerPageObject = new RegisterPageObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.registerInterract();

        RegisterPage registerPage = new RegisterPage(getDriver());
        registerPage.fillRegisterForm(registerPageObject);
        registerPage.logInAccount(registerPageObject);
        homePage.myAccountInterract();

        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        myAccountPage.validateCustomerInfo(registerPageObject);
        myAccountPage.addressesnterract();

        AddressesPage addressesPage = new AddressesPage(getDriver());
        addressesPage.validateNoAddress(registerPageObject);
        addressesPage.addNewInterract();
        addressesPage.fillNewAddressForm(registerPageObject);
        addressesPage.validateUpdatedAddresses();
        myAccountPage.ordersInterract();

        OrderPage orderPage = new OrderPage(getDriver());
        orderPage.validateNoOrders();
        myAccountPage.downloadableProductsInterract();

        DownloadableProductsPage downloadableProductsPage = new DownloadableProductsPage(getDriver());
        downloadableProductsPage.validateNoDownloadableProductsMessage();
        myAccountPage.backInStockSubscriptionsInterract();

        BackInStockSubscriptionsPage backInStockSubscriptionsPage = new BackInStockSubscriptionsPage(getDriver());
        backInStockSubscriptionsPage.validateNoSubscribedMessage();
        myAccountPage.rewardPointsInterract();

        RewardPointsPage rewardPointsPage = new RewardPointsPage(getDriver());
        rewardPointsPage.validateRewardPoints();
        myAccountPage.myProductReviewsInterract();

        MyProductReviewsPage myProductReviewsPage = new MyProductReviewsPage(getDriver());
        myProductReviewsPage.validateNoReviewsMessage();
        myAccountPage.changePasswordInterract();

        ChangePasswordPage changePasswordPage = new ChangePasswordPage(getDriver());
        changePasswordPage.createNewPasswordMethod(registerPageObject);
        changePasswordPage.validateNewPassword();
        changePasswordPage.logoutSession();

        registerPage.logInAccountWithNewCredentials(registerPageObject);
        myAccountPage.validateTitlePresent();
    }
}
