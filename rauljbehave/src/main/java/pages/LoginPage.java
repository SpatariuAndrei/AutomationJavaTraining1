package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.constants.TimeConstants;
import pages.utils.WebDriverUtilities;
import utilities.DataFromPropertyFile;

import static org.junit.Assert.assertEquals;

public class LoginPage extends LoadableComponent {

    @FindBy(id = "email")
    private WebElement emailTextField;

    @FindBy(xpath = "//button[@class='gui-btn auth-btn-primary auth-submit']")
    private WebElement nextButton;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    private TimeConstants constants;
    private WebDriver driver;
    private WebDriverUtilities driverUtilities;
    private DataFromPropertyFile propertyFile;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        propertyFile = new DataFromPropertyFile();
        PageFactory.initElements(driver, this);
        driverUtilities = new WebDriverUtilities();
    }

    @Override
    protected void load() {
        driver.get(propertyFile.getEmagLoginPage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(propertyFile.getEmagLoginPage(), driver.getCurrentUrl());
    }

    public UserHomePage login() {
        emailTextField.sendKeys(propertyFile.getUserEmail());
        nextButton.click();
        passwordTextField.sendKeys(propertyFile.getUserPassword());
        nextButton.click();
        return new UserHomePage(driver);
    }

    public void enterUserEmail() {
        driverUtilities.waitForElementToBeClickable(emailTextField, constants.LONG_TIMEOUT);
        emailTextField.clear();
        emailTextField.click();
        emailTextField.sendKeys(propertyFile.getUserEmail());
        driverUtilities.waitForElementAttributeToContainValue(emailTextField, "value", propertyFile.getUserEmail(), constants.SHORT_TIMEOUT);
    }

    public void enterUserPassword() {
        driverUtilities.waitForElementToBeClickable(passwordTextField, constants.LONG_TIMEOUT);
        passwordTextField.clear();
        passwordTextField.click();
        passwordTextField.sendKeys(propertyFile.getUserPassword());
        driverUtilities.waitForElementAttributeToContainValue(passwordTextField, "value", propertyFile.getUserPassword(), constants.SHORT_TIMEOUT);
    }

    public void clickNext() {
        nextButton.click();
    }

    public UserHomePage clickNextValidPassword() {
        nextButton.click();
        return new UserHomePage(driver);
    }
}
