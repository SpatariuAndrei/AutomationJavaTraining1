package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.CookieManager;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;


public class BaseTests {

    protected EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", filePath);
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());
        navigateToHomePage();
    }

    @BeforeMethod
    public void navigateToHomePage() {
        driver.navigate().to("http://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailureScreenshot(ITestResult result) {
        String screenshotsPath = System.getProperty("user.dir") + "/src/test/screenshots/";

        Calendar calendar = Calendar.getInstance();
        long timeMilli2 = calendar.getTimeInMillis();

        if (ITestResult.FAILURE == result.getStatus()) {
            TakesScreenshot camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File(screenshotsPath + result.getName() + "_"+timeMilli2+ ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars"); //disabling the info bar
        return chromeOptions;
    }

    public CookieManager getCookieManager() {
        return new CookieManager(driver);
    }

}
