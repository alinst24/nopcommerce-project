package ObjectData;

import java.util.HashMap;

public class SearchObject {

    private String searchBoxInput;

    private String product1Title;

    private String product2Title;

    private String product3Title;

    public String getProduct3Title() {
        return product3Title;
    }

    public void setProduct3Title(String product3Title) {
        this.product3Title = product3Title;
    }

    public String getProduct2Title() {
        return product2Title;
    }

    public void setProduct2Title(String product2Title) {
        this.product2Title = product2Title;
    }

    public String getProduct1Title() {
        return product1Title;
    }

    public void setProduct1Title(String product1Title) {
        this.product1Title = product1Title;
    }

    public String getSearchBoxInput() {
        return searchBoxInput;
    }

    public void setSearchBoxInput(String searchBoxInput) {
        this.searchBoxInput = searchBoxInput;
    }

    public SearchObject(HashMap<String,String> testData){
        populateObject(testData);
    }

    private void populateObject(HashMap<String,String> testData){
        for (String Key: testData.keySet()){
            switch (Key){
                case "searchBoxInput":
                    setSearchBoxInput(testData.get(Key));
                    break;
                case "product1Title":
                    setProduct1Title(testData.get(Key));
                    break;
                case "product2Title":
                    setProduct2Title(testData.get(Key));
                    break;
                case "product3Title":
                    setProduct3Title(testData.get(Key));
                    break;
            }
        }
    }
}
