import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class Selenium {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static LogUtil logger;

    @BeforeClass
    public static void initDriver(){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 15);
    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static File takeScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
}
