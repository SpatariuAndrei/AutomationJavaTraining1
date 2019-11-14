package guru99;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class GeckoDriverDemo {

    String driverPath = System.getProperty("user.dir") +  "/src/main/resources/geckodriver.exe";
    public WebDriver driver;

    @Before
    public void startBrowser() {
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
    }

    @Test
    public void navigateToUrl() {
        driver.get("http://demo.guru99.com/test/tooltip.html");
    }

    @After
    public void endTest() {
        driver.quit();
    }

}