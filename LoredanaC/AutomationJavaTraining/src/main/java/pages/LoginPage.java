package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private WebDriver driver;
    private By usernameField  = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.className("radius");


     public LoginPage (WebDriver driver) {
         this.driver = driver;
     }

     public void setUserName(String userName){
          driver.findElement(usernameField).sendKeys(userName);



         }

         public void inputPassword (String password){

             driver.findElement(passwordField).sendKeys(password);

     }
     public SecureAreaPage clickLoginButton () {
         driver.findElement(loginButton).click();
         return new SecureAreaPage(driver);

     }


}
