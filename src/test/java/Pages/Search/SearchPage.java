package Pages.Search;

import LoggerUtility.LoggerUtility;
import ObjectData.HomepageObject;
import ObjectData.SearchObject;
import Pages.BasePage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class SearchPage extends BasePage {
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".item-grid")
    private List<WebElement> productsTable;

    @FindBy(css = ".item-box")
    private WebElement productElement;

    @FindBy(xpath = "//h2/a[contains(text(),'5.0 Lollipop')]")
    // identificare dupa textul hardcodat(lung),cautand doar 2 cuvinte din acesta, dar am coborat din <h2 pentru ca imi dadea 1/2 din cauza la recent searches
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

    @FindBy(id = "small-searchterms")
    private WebElement searchBox;

    @FindBy(xpath = "//span[contains(text(),'5.0 Lollipop')]")
    private WebElement firstSearchResult;

    @FindBy(xpath = "//h1[contains(text(),'5.0 Lollipop')]")
    private WebElement firstSearchResultTitle;

    @FindBy(id = "isc")
    private WebElement checkboxAutomaticallySearchSubCategory;
    @FindBy(css = "button[type='submit']")
    private WebElement searchButton;

    @FindBy(css = "div[class='warning']")
    private WebElement warningSearch;

    @FindBy(id = "q")
    private WebElement deleteSearch;

    @FindBy(id = "advs")
    private WebElement advancedSearchBox;

    @FindBy(id = "cid")
    private WebElement categoryDropDown;

    @FindBy(xpath = "//button[contains(@class, 'search-button')]")
    private WebElement advancedSearchButton;

    @FindBy(css = "div[class='no-result']")
    private WebElement noProductFoundMessage;

    public void validateSeachesSuggestions(SearchObject searchObject) {
        elementMethods.clickElement(searchBox);
        LoggerUtility.info("The user is clicking on search box.");
        elementMethods.fillElement(searchBox, searchObject.getSearchBoxInput(), firstSearchResult);
        LoggerUtility.info("The user enters the value: " + searchObject.getSearchBoxInput() + " then clicks on the first result of the suggestions.");
        elementMethods.validateMessage(firstSearchResultTitle, searchObject.getProduct1Title());
        LoggerUtility.info("The user product's title has been validated.");
        pageElements.clickBack();
        LoggerUtility.info("The user returns to previous page.");
    }

    public void searchBox(SearchObject searchObject) {
        elementMethods.clickElement(searchBox);
        LoggerUtility.info("The user is clicking on search box.");
        elementMethods.fillElement(searchBox, searchObject.getSearchBoxInput(), Keys.ENTER);
        LoggerUtility.info("The user enters the value: " + searchObject.getSearchBoxInput() + " then presses ENTER.");
    }

    public void validateSearches() {
        elementMethods.validateTable(".product-grid .item-box", 3);
        LoggerUtility.info("The results of search have been validated with success.");
    }

    public void selectProduct1() {
        elementMethods.clickElement(product1);
        LoggerUtility.info("The user clicks on the first product of the results.");
    }

    public void validateProduct1(SearchObject searchObject) {
        elementMethods.validateMessage(product1Title, searchObject.getProduct1Title());
        LoggerUtility.info("The product's name has been validated with success.");
        elementMethods.validatePresenceElement(product1image);
        LoggerUtility.info("The image of this product has been validated with success.");
        pageElements.clickBack();
        LoggerUtility.info("The user returns to previous page.");
    }

    public void selectProduct2() {
        elementMethods.clickElement(product2);
        LoggerUtility.info("The user clicks on the second product of the results.");
    }

    public void validateProduct2(SearchObject searchObject) {
        elementMethods.validateMessage(product2Title, searchObject.getProduct2Title());
        LoggerUtility.info("The product's name has been validated with success.");
        elementMethods.validatePresenceElement(product2image);
        LoggerUtility.info("The image of this product has been validated with success.");
        pageElements.clickBack();
        LoggerUtility.info("The user returns to previous page.");
    }

    public void selectProduct3() {
        elementMethods.clickElement(product3);
        LoggerUtility.info("The user clicks on the third product of the results.");
    }

    public void validateProduct3(SearchObject searchObject) {
        elementMethods.validateMessage(product3Title, searchObject.getProduct3Title());
        LoggerUtility.info("The product's name has been validated with success.");
        elementMethods.validatePresenceElement(product3image);
        LoggerUtility.info("The image of this product has been validated with success.");
        pageElements.clickBack();
        LoggerUtility.info("The user returns to previous page.");
    }

    public void accessURL(SearchObject searchObject) {
        pageElements.accesUrl(searchObject.getUrl());
        LoggerUtility.info("The user accesses following URL: " + searchObject.getUrl() + " .");
    }

    public void validateEmptySearch(SearchObject searchObject) {
        elementMethods.clickElement(searchButton);
        LoggerUtility.info("The user is clicking on search button.");
        Alert alert = driver.switchTo().alert();
        LoggerUtility.info("The focus is changed on alert.");
        String alertTextValue = alert.getText();
        Assert.assertEquals(alertTextValue, searchObject.getSearchAlertValue());
        LoggerUtility.info("The alert text has been validated with success.");
        alert.accept();
        LoggerUtility.info("The user clicks on OK to accept alert.");
        driver.switchTo().defaultContent();
        LoggerUtility.info("The focus is changed on base context of the page.");
    }

    public void validateInvalidSearch(SearchObject searchObject) {
        elementMethods.clickElement(searchBox);
        LoggerUtility.info("The user is clicking on search box.");
        elementMethods.fillElement(searchBox, searchObject.getInvalidSearch(), Keys.ENTER);
        LoggerUtility.info("The user enters invalid search, then presses ENTER.");
        Assert.assertTrue(warningSearch.isDisplayed(), "The warning message is not displayed.");
        LoggerUtility.info("The search warning is displayed and validated with success. ");
    }

    public void deleteSearch(SearchObject searchObject) {
        elementMethods.deleteContextElement(deleteSearch);
        LoggerUtility.info("The user is deleting search input.");
    }

    public void validateAdvancedSearch(SearchObject searchObject) {
        elementMethods.fillElement(deleteSearch, searchObject.getSearchBoxInput());
        LoggerUtility.info("The user fills search field with value:" + searchObject.getSearchBoxInput() + " .");
        elementMethods.clickElement(advancedSearchBox);
        LoggerUtility.info("The user ticks the advanced search box.");
        elementMethods.dropDownInterract(categoryDropDown, 4);
        LoggerUtility.info("The user clicks on the fourth result of category dropdown.");
        elementMethods.clickElement(checkboxAutomaticallySearchSubCategory);
        LoggerUtility.info("The user ticks the automatically search subcategory box.");
        elementMethods.clickElement(advancedSearchButton);
        LoggerUtility.info("The user clicks on search button.");
        elementMethods.validatePresenceElement(noProductFoundMessage);
        LoggerUtility.info("The message shown has been validated: " + searchObject.getNoProductFoundMessage());
    }
}
