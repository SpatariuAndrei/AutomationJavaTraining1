package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private By formAuthenticationLink = By.linkText("Form Authentication");
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //if your action changes the page -> should return a handle of that page
    public LoginPage clickFormAuthentication() {
        driver.findElement(formAuthenticationLink).click();
        return new LoginPage(driver);
    }
}
