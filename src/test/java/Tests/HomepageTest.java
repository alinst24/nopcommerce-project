package Tests;

import ObjectData.HomepageObject;
import Pages.HomePage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class HomepageTest extends Hooks {

    @Test
    public void testMethod(){

        HomepageObject homepageObject = new HomepageObject(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.validateHomePage(homepageObject);
    }
}
