package driverprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import properties.PropertiesConfig;

import static properties.PropertiesKeys.BROWSER_TYPE_CHROME;

public class DriverInstance {
    private static WebDriver driver;
    // BROWSER_TYPE_CHROME or BROWSER_TYPE_FIREFOX
    private static final String BROWSER = PropertiesConfig.getProperty(BROWSER_TYPE_CHROME);

    private DriverInstance() {
    }

    public static WebDriver getDriver() {
        switch (BROWSER) {
            case "chrome":
                initChromeDriver();
                break;
            case "firefox":
                initFirefoxDriver();
                break;
            default:
                throw new IllegalStateException("No driver found for provided value: " + BROWSER);
        }

        return driver;
    }

    private static  void initChromeDriver(){
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");

            driver = new ChromeDriver(options);
        }
    }

    private static void initFirefoxDriver(){
        if (driver == null) {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
