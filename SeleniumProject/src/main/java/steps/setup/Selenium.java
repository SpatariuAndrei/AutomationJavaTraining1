package steps.setup;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DataFromPropertyFile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Selenium {

    private Map<Long, WebDriver> driverMap = new HashMap<>();
    private WebDriver cachedWebDriver;

    private void initDriver(){
        driverMap.put(Thread.currentThread().getId(), initFirefoxDriver());
    }

    private WebDriver getDriver() {
        initDriver();
        cachedWebDriver = driverMap.get(Thread.currentThread().getId());
        return cachedWebDriver;
    }

    private WebDriver initFirefoxDriver() {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.getWindowHandle();
        return driver;
    }

    public WebDriver getCachedWebDriver() {
        return cachedWebDriver != null ? cachedWebDriver : getDriver();
    }

    public void quitDriver(){
        if (cachedWebDriver != null) {
            cachedWebDriver.quit();
            cachedWebDriver = null;
            driverMap.clear();
        }
    }
}
