package guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Flipkart{

    WebDriver driver ;
    final String username = "mngr232757", password = "dEqyjad";
    // This method is to navigate flipkart URL
//    Flipkart() {
//        String driverPath = System.getProperty("user.dir") +  "/src/main/resources/geckodriver.exe";
//        System.setProperty("webdriver.gecko.driver", driverPath);
//        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//        capabilities.setCapability("marionette", true);
//        driver = new FirefoxDriver(capabilities);
//    }

    @BeforeClass
    public void init() {
        String driverPath = System.getProperty("user.dir") +  "/src/main/resources/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.navigate().to("https://www.flipkart.com");
    }

    // To log in flipkart
    @Test(priority = 0)
    public void login() {
        driver.findElement(By.partialLinkText("Login")).click();
        driver.findElement(
                By.cssSelector(".fk-input.login-form-input.user-email"))
                .sendKeys(username);
        driver.findElement(
                By.cssSelector(".fk-input.login-form-input.user-pwd"))
                .sendKeys(password);
        driver.findElement(By.cssSelector(".submit-btn.login-btn.btn")).click();
    }

    // Search For product
    @Test(priority = 1)
    public void searchAndSelectProduct() {
        driver.findElement(By.id("fk-top-search-box")).sendKeys("moto g3");
        driver.findElement(
                By.cssSelector("search-bar-submit.fk-font-13.fk-font-bold"))
                .click();

        // select the first item in the search results
        String css = ".gd-row.browse-grid-row:nth-of-type(1) > div:nth-child(1)>div>div:nth-child(2)>div>a";
        driver.findElement(By.cssSelector(css)).click();
    }

    @Test(priority = 2)
    public void buyAndRemoveFromCart() {
        driver.findElement(
                By.cssSelector(".btn-express-checkout.btn-big.current"))
                .click();
        driver.findElement(By.cssSelector(".remove.fk-inline-block")).click();
        Alert a = driver.switchTo().alert();
        a.accept();
    }

    @Test(priority = 4)
    public void logout() {
        Actions s = new Actions(driver);
        WebElement user = driver.findElement(By.partialLinkText(username));
        s.moveToElement(user).build().perform();
        driver.findElement(By.linkText("Logout")).click();
    }

    @AfterClass
    public void quit() {
        driver.close();
    }
}