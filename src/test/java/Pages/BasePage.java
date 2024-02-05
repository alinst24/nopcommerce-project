package Pages;

import HelpMethods.ElementMethods;
import HelpMethods.PageMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    protected WebDriver driver;

    protected ElementMethods elementMethods;
    protected PageMethods pageMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        elementMethods = new ElementMethods(driver);
        pageMethods =new PageMethods(driver);
    }
}
