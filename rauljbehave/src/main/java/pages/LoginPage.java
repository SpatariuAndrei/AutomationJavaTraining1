package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.utils.WebDriverUtilities;
import utilities.DataFromPropertyFile;

import static org.junit.Assert.assertEquals;

public class LoginPage extends LoadableComponent {

    private WebDriver driver;
    private WebDriverUtilities driverUtilities;
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
        driverUtilities = new WebDriverUtilities();
    }

    public void login() {
        emailTextField.sendKeys(propertyFile.getUserEmail());
        nextButton.click();
        passwordTextField.sendKeys(propertyFile.getUserPassword());
        nextButton.click();
    }

    public void enterUserEmail() {
        driverUtilities.waitForElementToBeClickable(emailTextField, 10);
        emailTextField.clear();
        emailTextField.click();
        emailTextField.sendKeys(propertyFile.getUserEmail());
        driverUtilities.meetExpectation(emailTextField, propertyFile.getUserEmail());

    }

    public void enterUserPassword() {
        driverUtilities.waitForElementToBeClickable(passwordTextField, 10);
        passwordTextField.clear();
        passwordTextField.click();
        passwordTextField.sendKeys(propertyFile.getUserPassword());
        driverUtilities.meetExpectation(passwordTextField, propertyFile.getUserPassword());
    }

    public void clickNext() {
        nextButton.click();
    }

    public UserHomePage clickNextValidPassword() {
        nextButton.click();
        return new UserHomePage(driver);
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
