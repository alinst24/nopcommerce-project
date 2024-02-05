package ObjectData;

import java.util.HashMap;

public class ProductCartObject {

    private String cupon;
    private String url;

    public String getCupon() {
        return cupon;
    }

    public void setCupon(String cupon) {
        this.cupon = cupon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ProductCartObject(HashMap<String, String> testData) {
        populateObject(testData);
    }

    public void populateObject(HashMap<String, String> testData){
        for (String Key : testData.keySet()) {
            switch (Key) {
                case "cupon":
                    setCupon(testData.get(Key));
                    break;
                case "url":
                    setUrl(testData.get(Key));
                    break;
            }
        }
    }
}
