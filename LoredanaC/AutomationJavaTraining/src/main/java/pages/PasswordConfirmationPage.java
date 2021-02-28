package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordConfirmationPage {
    private WebDriver driver;
    private By confirmationMessage = By.xpath("/html/body/h1");

    public PasswordConfirmationPage (WebDriver driver){
        this.driver = driver;
    }
    public String getPasswordConfirmationText(){
        return driver.findElement(confirmationMessage).getText();


    }
}
