package ShareData.Browser;

import PropertyUtility.PropertyUtility;

import java.util.HashMap;

public class BaseBrowserService {

    public HashMap<String,String> getBrowserOptions(){
        PropertyUtility propertyUtility = new PropertyUtility("Browser");
        return propertyUtility.getAllData();
    }
}
