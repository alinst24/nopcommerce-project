package Pages.Search;

import LoggerUtility.LoggerUtility;
import ObjectData.SearchObject;
import Pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".item-grid")
    private List<WebElement> productsTable;

    @FindBy(css = ".item-box")
    private WebElement productElement;

    @FindBy(xpath = "//h2/a[contains(text(),'5.0 Lollipop')]")           // identificare dupa textul hardcodat(lung),cautand doar 2 cuvinte din acesta, dar am coborat din <h2 pentru ca imi dadea 1/2 din cauza la recent searches
    private WebElement product1;

    @FindBy(xpath = "//h2/a[contains(text(),'Mini Blue')]")
    private WebElement product2;

    @FindBy(xpath = "//h2/a[contains(text(),'Lumia 1020')]")
    private WebElement product3;

    @FindBy(xpath = "//h1[contains(text(),'5.0 Lollipop')]")
    private WebElement product1Title;

    @FindBy(id = "main-product-img-18")
    private WebElement product1image;

    @FindBy(xpath = "//h1[contains(text(),'Mini Blue')]")
    private WebElement product2Title;

    @FindBy(id = "main-product-img-19")
    private WebElement product2image;

    @FindBy(xpath = "//h1[contains(text(),'Lumia 1020')]")
    private WebElement product3Title;

    @FindBy(id = "main-product-img-20")
    private WebElement product3image;

    public void validateSearches() {
        elementMethods.validateTable(".product-grid .item-box",3);
        LoggerUtility.info("The results of search have been validated with success.");
    }

    public void selectProduct1() {
        elementMethods.clickElement(product1);
        LoggerUtility.info("The user clicks on the first product of the results.");
    }

    public void validateProduct1(SearchObject searchObject){
        elementMethods.validateMessage(product1Title, searchObject.getProduct1Title());
        LoggerUtility.info("The product's name has been validated with success.");
        elementMethods.validatePresence(product1image);
        LoggerUtility.info("The image of this product has been validated with success.");
        elementMethods.clickBack();
        LoggerUtility.info("The user returns to previous page.");
    }

    public void selectProduct2(){
        elementMethods.clickElement(product2);
        LoggerUtility.info("The user clicks on the second product of the results.");
    }

    public void validateProduct2(SearchObject searchObject){
        elementMethods.validateMessage(product2Title, searchObject.getProduct2Title());
        LoggerUtility.info("The product's name has been validated with success.");
        elementMethods.validatePresence(product2image);
        LoggerUtility.info("The image of this product has been validated with success.");
        elementMethods.clickBack();
        LoggerUtility.info("The user returns to previous page.");
    }

    public void selectProduct3(){
        elementMethods.clickElement(product3);
        LoggerUtility.info("The user clicks on the third product of the results.");
    }

    public void validateProduct3(SearchObject searchObject){
        elementMethods.validateMessage(product3Title,searchObject.getProduct3Title());
        LoggerUtility.info("The product's name has been validated with success.");
        elementMethods.validatePresence(product3image);
        LoggerUtility.info("The image of this product has been validated with success.");
    }
}
