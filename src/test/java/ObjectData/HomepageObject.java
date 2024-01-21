package ObjectData;

import java.util.HashMap;

public class HomepageObject {

    private String welcomeMessage;

    private String featuredProductsMessage;

    public String getFeaturedProductsMessage() {
        return featuredProductsMessage;
    }

    public void setFeaturedProductsMessage(String featuredProductsMessage) {
        this.featuredProductsMessage = featuredProductsMessage;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public HomepageObject(HashMap<String, String> testData) {
        populateObject(testData);
    }

    private void populateObject(HashMap<String, String> testData) {
        for (String Key : testData.keySet()) {
            switch (Key) {
                case "welcomeMessage":
                    setWelcomeMessage(testData.get(Key));
                    break;
                case "featuredProductsMessage":
                    setFeaturedProductsMessage(testData.get(Key));
                    break;
            }
        }
    }
}
