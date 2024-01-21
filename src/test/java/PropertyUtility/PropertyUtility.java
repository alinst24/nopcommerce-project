package PropertyUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertyUtility {
    public Properties properties;
    public PropertyUtility(String fileName) {
        loadDataFile(fileName);
    }

    private void loadDataFile(String fileName) {
        properties = new Properties();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("src/test/resources/TestData/"+fileName+"Data.properties");
            properties.load(fileInputStream);
        } catch (IOException ignored) {
        }
    }

    public HashMap<String ,String> getAllData (){
        HashMap<String,String> testData = new HashMap<>();
        for (String Key:properties.stringPropertyNames()){
            testData.put(Key,properties.getProperty(Key));
        }
        return testData;
    }
}