package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Helper {

    //*********Variables*********
    private WebDriver driver;
    private final String path = "/src/main/resources/chromedriver.exe";

    //*********Constructor*********
    public Helper(WebDriver driver) {
        this.driver = driver;
    }

    //*********Methods*********
    public WebDriver instantiateChromeDriver() {
        String filePath = System.getProperty("user.dir") + path;
        System.setProperty("webdriver.chrome.driver", filePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    public void click(WebElement webElement) {
        webElement.click();
    }

    public void setText(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    public String getText(WebElement webElement) {
        return webElement.getText();
    }

    public void moveOverElement(WebElement webElement) {
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
    }
}
