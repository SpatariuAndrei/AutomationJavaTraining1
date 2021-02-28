package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By clickEmailField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");

    public ForgotPasswordPage (WebDriver driver){this.driver = driver; }

    public void inputEmail (String email){
        driver.findElement(clickEmailField).sendKeys(email);

    }
    public PasswordConfirmationPage clickRetrievePasswordButton(){
        driver.findElement(retrievePasswordButton).click();
        return new PasswordConfirmationPage(driver);



    }




}