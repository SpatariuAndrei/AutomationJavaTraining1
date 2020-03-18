package base;

import com.google.common.io.Files;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTests {

    private RemoteWebDriver driver;
    protected HomePage homePage;
    private Capabilities chromeCapabilities = DesiredCapabilities.chrome();

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        //driver = new EventFiringWebDriver(new ChromeDriver());
        //driver.register(new EventReporter());
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeCapabilities);
        goHome();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public  void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
    }

    public static void main(String args[]) throws MalformedURLException {
        BaseTests test = new BaseTests();
        test.setUp();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try{
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
