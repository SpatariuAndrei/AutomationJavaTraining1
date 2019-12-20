package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverInitializerJBehave {

    private WebDriver driver;
    private DataFromPropertyFile dataFromPropertyFile;

    public DriverInitializerJBehave(WebDriver driver) {
        this.driver = driver;
        dataFromPropertyFile = new DataFromPropertyFile();
    }

    public WebDriver init() {
        System.setProperty("webdriver.chrome.driver", dataFromPropertyFile.getGeckoDriverLocationWin());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        return driver;
    }


}
