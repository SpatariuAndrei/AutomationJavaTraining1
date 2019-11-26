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
            getDriverForOperaingSystems();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-extensions"); //-- cannot be used in Endava network due to Forcepoint Endpoint for windows extension
            options.addArguments("--disable-infobars");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");

            driver = new ChromeDriver(options);
        }
    }

    private static void initFirefoxDriver(){
        if (driver == null) {
            getDriverForOperaingSystems();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
    }

    /**
     * During internship some of us are working on windows others are working on linux
     * since different browsers drivers are necessary for different OS is necessary to instantiate drivers accordingly
     */
    private static void getDriverForOperaingSystems(){
        String operatingSystem = System.getProperty("os.name");
        if(operatingSystem.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\drivers\\geckodriver.exe");
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        }
        else if ((operatingSystem.contains("nix") || operatingSystem.contains("nux"))){
            System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        }

    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
