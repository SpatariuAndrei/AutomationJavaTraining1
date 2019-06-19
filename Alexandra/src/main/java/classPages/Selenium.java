package classPages;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

//set up class
public class Selenium {

    private static WebDriver driver;
    private static LogUtilities logUtilities;

    @BeforeClass
    public static void initTest(){
        logUtilities=new LogUtilities();
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("unexpectedAlertBehaviour", "ignore");

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

    }

    @AfterClass
    public static void quitTest() throws IOException {
        logUtilities.takeScreenshot();
        driver.quit();
    }

    protected WebDriver getDriver(){
        return driver;
    }

    static File takeScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

}
