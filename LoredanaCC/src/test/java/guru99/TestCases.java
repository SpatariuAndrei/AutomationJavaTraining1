package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(guru99.ListenerTest.class)

public class TestCases {

    WebDriver driver;

    // Test to pass as to verify listeners .
    @Test
    public void Login()
    {
        String driverPath = System.getProperty("user.dir") +  "/src/main/resources/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/V4/");
        driver.findElement(By.name("uid")).sendKeys("mngr232757");
        driver.findElement(By.name("password")).sendKeys("dEqyjad");
        driver.findElement(By.name("btnLogin")).click();
    }

    // Forcefully failed this test as to verify listener.
    @Test
    public void TestToFail()
    {
        System.out.println("This method to test fail");
        Assert.assertTrue(false);
    }
}