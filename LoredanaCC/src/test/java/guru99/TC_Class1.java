package guru99;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Class1 {

    String driverPath = System.getProperty("user.dir") +  "/src/main/resources/geckodriver.exe";
    public  WebDriver webDriver ;
    String launchPageHeading = "//h2[@class='barone']";
    final String userName_element = "//input[@name='uid']", password_element = "//input[@name='password']",
            signIn_element = "//input[@name='btnLogin']";
    final String userName_value = "mngr232757", password_value = "dEqyjad";
    final String managerID = "//td[contains(text(),'Manger Id')]";
    final String newCustomer = "//a[@href='addcustomerpage.php']", fundTransfer = "//a[@href='FundTransInput.php']";

    TC_Class1() {
        System.setProperty("webdriver.gecko.driver", driverPath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        webDriver = new FirefoxDriver(capabilities);
    }
    /**
     * This test case will initialize the webDriver
     */
    @Test(groups = { "bonding", "strong_ties" })
    public void tc01LaunchURL() {

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.get("http://www.demo.guru99.com/V4/");
    }

    /**
     * Will check the presence of Heading on Login Page
     */
    @Test(groups = { "bonding" })
    public void tc02VerifyLaunchPage() {
        //webDriver.navigate().to("http://www.demo.guru99.com/V4/");
        Assert.assertTrue(webDriver.findElement(By.xpath(launchPageHeading)).isDisplayed(),
                "Home Page heading is not displayed");
        System.out.println("Home Page heading is displayed");
    }

    /**
     * This test case will enter User name, password and will then click on
     * signIn button
     */
    @Test(groups = { "bonding", "strong_ties" })
    public void tc03EnterCredentials() {
        webDriver.findElement(By.xpath(userName_element)).sendKeys(userName_value);
        webDriver.findElement(By.xpath(password_element)).sendKeys(password_value);
        webDriver.findElement(By.xpath(signIn_element)).click();
    }

    /**
     * This test case will verify manger's ID presence on DashBoard
     */
    @Test(groups = { "strong_ties" })
    public void tc04VerifyLoggedInPage() {
        Assert.assertTrue(webDriver.findElement(By.xpath(managerID)).isDisplayed(),
                "Manager ID label is not displayed");
        System.out.println("Manger Id label is displayed");
    }

    /**
     * This test case will check the presence of presence of New customer link
     * And FundTransfer link in Left pannel
     */
    @Test(groups = { "bonding" })
    public void tc05VerifyHyperlinks() {
        Assert.assertTrue(webDriver.findElement(By.xpath(newCustomer)).isEnabled(),
                "New customer hyperlink is not displayed");
        System.out.println("New customer hyperlink is displayed");

        Assert.assertTrue(webDriver.findElement(By.xpath(fundTransfer)).isEnabled(),
                "Fund Transfer hyperlink is not displayed");
        System.out.println("Fund Transfer hyperlink is displayed");
    }

}
