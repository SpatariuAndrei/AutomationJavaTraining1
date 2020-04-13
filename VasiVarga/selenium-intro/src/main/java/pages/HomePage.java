package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    private By emailTextField = By.id("email");
    private By enterButton = By.id("entering");
    private By signInButton = By.id("btn1");
    private By skipSignInButton = By.id("btn2");

    public SignUpPage clickSkipButton(){
        driver.findElement(skipSignInButton).click();
        return new SignUpPage(driver);
    }

    public HomePage(WebDriver driver){
        this.driver=driver;
    }

}
