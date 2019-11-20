package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;
    @FindBy(id = "username")
    WebElement usernameFd;
    @FindBy(id = "password")
    WebElement passwordFd;
    @FindBy(css = "#login button")
    WebElement loginButton;

    LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setUsername(String username) {
        usernameFd.sendKeys(username);
    }

    public void setPassword(String password) {
        passwordFd.sendKeys(password);
    }

    public SecureAreaPage clickLoginButton() {
        loginButton.click();
        return new SecureAreaPage(driver);
    }
}
