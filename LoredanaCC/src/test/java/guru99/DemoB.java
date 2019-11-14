package guru99;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class DemoB {


    @Test
    public void run() {
        String driverPath = System.getProperty("user.dir") +  "/src/main/resources/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        WebDriver webDriver = new FirefoxDriver();
        Reporter.log("browser is opened now");
        webDriver.get("https://www.google.co.in");
        Reporter.log("google is opened now");
        webDriver.findElement(By.name("q")).sendKeys("Bye");
        Reporter.log("the data BYE is entered");
    }
}
