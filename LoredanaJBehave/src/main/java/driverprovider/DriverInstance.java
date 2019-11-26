package driverprovider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.DataFromPropertyFile;

public class DriverInstance {

    private static WebDriver driver;
    private static final String BROWSER = DataFromPropertyFile.getBrowser();
    private static final String SO = DataFromPropertyFile.getSo();

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
            if (SO.equals("linux")) {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            // options.addArguments("--disable-extensions"); -- cannot be used in Endava network due to Forcepoint Endpoint for windows extension
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");

            driver = new ChromeDriver(options);
        }
    }

    private static void initFirefoxDriver(){
        if (driver == null) {
            if (SO.equals("linux")) {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            } else {
                System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
            }

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
