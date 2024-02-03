package Pages;

import HelpMethods.ElementMethods;
import HelpMethods.PageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    protected ElementMethods elementMethods;
    protected PageElements pageElements;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethods = new ElementMethods(driver);
        pageElements=new PageElements(driver);
    }
}
