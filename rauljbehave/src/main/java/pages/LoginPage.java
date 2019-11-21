package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utilities.DataFromPropertyFile;

import static org.junit.Assert.assertEquals;

public class LoginPage extends LoadableComponent {

    private WebDriver driver;
    private DataFromPropertyFile propertyFile;
    @FindBy(id = "email")
    private WebElement emailTextField;
    @FindBy(xpath = "//button[@class='gui-btn auth-btn-primary auth-submit']")
    private WebElement nextButton;
    @FindBy(id = "password")
    private WebElement passwordTextField;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        propertyFile = new DataFromPropertyFile();
        PageFactory.initElements(driver, this);
    }

    public void login() {
        emailTextField.sendKeys(propertyFile.getUserEmail());
        nextButton.click();
        passwordTextField.sendKeys(propertyFile.getUserPassword());
        nextButton.click();
    }

    @Override
    protected void load() {
        driver.get(propertyFile.getEmagLoginPage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(propertyFile.getEmagLoginPage(), driver.getCurrentUrl());
    }
}
