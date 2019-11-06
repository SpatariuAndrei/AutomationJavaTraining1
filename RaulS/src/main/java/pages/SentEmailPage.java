package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SentEmailPage {

    private WebDriver driver;
    private By emailStatus = By.id("content");

    public SentEmailPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        return driver.findElement(emailStatus).getText();
    }
}
