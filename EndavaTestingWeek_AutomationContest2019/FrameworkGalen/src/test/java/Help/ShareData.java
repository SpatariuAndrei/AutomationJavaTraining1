package Help;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ShareData {

    public WebDriver driver;
    public static Properties property;
    public FileInputStream file;


    public ShareData() throws Exception {
        System.setProperty("webdriver.chrome.driver", "/home/rubintp/Desktop/chromedriver");
        driver=new ChromeDriver();
        driver.get("https://www.lambdatest.com/");
        driver.manage().window().maximize();
        HelperMethods functions=new HelperMethods(driver);
        loadFileProperty();
    }

    public void loadFileProperty() throws FileNotFoundException {

        property=new Properties();
        file=new FileInputStream("src/test/resources/inputData/inputData.properties");
        try {
            property.load(file);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    //Method for receive a value from a properties file//
    public static String getValue(String key)
    {
        return property.getProperty(key);
    }
}
