package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmailSentConfirmationPage {

    private WebDriver driver;
    private By confirmationMessageText = By.id("content");
    public EmailSentConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getConfirmationMessage(){
        return driver.findElement(confirmationMessageText).getText();
    }

}
