package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityInTestNG {
    WebDriver driver;

    // Method 1: Open Browser say Firefox
    @Test (priority=1)
    public void openBrowser() {
        String driverPath = System.getProperty("user.dir") +  "/src/main/resources/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver = new FirefoxDriver();
    }

    // Method 2: Launch Google.com
    @Test (priority=2)
    public void launchGoogle() {
        driver.get("http://www.google.co.in");
    }

    // Method 3: Perform a search using "Facebook"
    @Test (priority=3)
    public void peformSeachAndClick1stLink() {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Facebook");
    }

    // Method 4: Verify Google search page title.
    @Test (priority=4)
    public void FaceBookPageTitleVerification() throws Exception {
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        Assert.assertEquals(driver.getTitle().contains("Facebook - Căutare Google"), true);
    }
}