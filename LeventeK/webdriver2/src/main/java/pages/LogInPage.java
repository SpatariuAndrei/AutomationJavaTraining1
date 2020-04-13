package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

    private WebDriver driver;
    private By emailField = By.xpath("/html/body/div/div/div[2]/input");
    private By passwordField = By.xpath("/html/body/div/div/div[3]/input");
    private By enterButton = By.id("enterbtn");
    private By errorMessage = By.id("errormsg");

    public LogInPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickEnterButton(){
        driver.findElement(enterButton).click();
    }

    public String getErrorMessageText(){
        return driver.findElement(errorMessage).getText();
    }


}
