package Tests;

import ObjectData.SearchObject;
import Pages.Search.SearchPage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class SearchTest extends Hooks {

    @Test
    public void testMethod(){

        SearchObject searchObject = new SearchObject(testData);

        SearchPage searchPage = new SearchPage(getDriver());
        searchPage.validateSeachesSuggestions(searchObject);
        searchPage.searchBox(searchObject);
        searchPage.validateSearches();
        searchPage.selectProduct1();
        searchPage.validateProduct1(searchObject);
        searchPage.selectProduct2();
        searchPage.validateProduct2(searchObject);
        searchPage.selectProduct3();
        searchPage.validateProduct3(searchObject);
        searchPage.accessURL(searchObject);
        searchPage.validateEmptySearch(searchObject);
        searchPage.validateInvalidSearch(searchObject);
        searchPage.deleteSearch(searchObject);
        searchPage.validateAdvancedSearch(searchObject);
    }
}
