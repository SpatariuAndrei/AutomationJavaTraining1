import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class Selenium {
    private static WebDriver driver;

    @BeforeClass
    public static void initDriver(){
        System.out.println("sel beforreClass");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void quitDriver(){

        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static File takeScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }
}
