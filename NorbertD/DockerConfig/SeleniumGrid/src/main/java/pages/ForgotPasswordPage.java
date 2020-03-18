package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By emailField = By.id("email");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    private By retrievePasswordButton = By.cssSelector("#form_submit > i");

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public EmailSentConfirmationPage clickRetrievePassword(){
        driver.findElement(retrievePasswordButton).click();
        return new EmailSentConfirmationPage(driver);
    }
}
