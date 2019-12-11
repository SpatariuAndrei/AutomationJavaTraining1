package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentPage {
    private WebDriver driver;
    By confirm = By.id("content");

    public EmailSentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String emailRetrieveConfirmation() {
        return driver.findElement(confirm).getText();
    }
}
