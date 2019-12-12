package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.yahoo.DownloadYahooPage;

public class WgetTests {

    private WebDriver driver;
    protected DownloadYahooPage downloadYahooPage;

    @BeforeClass
    public void setUp() {
        String filePath = System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", filePath);
        driver = new ChromeDriver();
        driver.navigate().to("http://demo.guru99.com/test/yahoo.html");
        downloadYahooPage = new DownloadYahooPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
