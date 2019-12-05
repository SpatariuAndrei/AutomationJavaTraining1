package steps.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.DataFromPropertyFile;

public class Browser {

    private static WebDriver driver;
    private DataFromPropertyFile propertyFile;

    public WebDriver driverInitialization() {
        propertyFile = new DataFromPropertyFile();
        System.setProperty("webdriver.chrome.driver", propertyFile.getChromeDriverLocationWin());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
