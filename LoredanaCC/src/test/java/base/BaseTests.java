package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;

public class BaseTests {
    private WebDriver driver;
    protected HomePage homePage;
//    public void  setUp() {
//        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://the-internet.herokuapp.com/");
//       // driver.manage().window().maximize();
//        //  driver.manage().window().setSize(new Dimension(375,812));
//       // System.out.println(driver.getTitle());
//       List<WebElement> links = driver.findElements(By.tagName("a"));
//        System.out.println(links.size());
//        WebElement inputsLink = driver.findElement(By.linkText("Inputs"));
//        //  inputsLink.click();
//        //driver.quit();
//        WebElement contentLink = driver.findElement(By.linkText("Shifting Content"));
//         contentLink.click();
//        WebElement menuLink = driver.findElement(By.linkText("Example 1: Menu Element"));
//        menuLink.click();
//        List<WebElement> menus = driver.findElements(By.tagName("li"));
//        System.out.println(menus.size());
//    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        //driver.quit();
    }

    @AfterClass
    public void tearDown() {
       // driver.quit();
    }
//    public static void main (String args[]) {
//        BaseTests test = new BaseTests();
//        test.setUp();
//    }
}
