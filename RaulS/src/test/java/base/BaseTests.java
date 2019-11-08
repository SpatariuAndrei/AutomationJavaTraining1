package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;

public class BaseTests {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Work/cld_automation_community/RaulS/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
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

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
}
