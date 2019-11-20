package jbehavepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.DataFromPropertyFile;

import static org.junit.Assert.assertEquals;

public class FormAuthenticationPageJBehave extends LoadableComponent {

    private WebDriver driver;
    private DataFromPropertyFile dataFromPropertyFile;
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(css = "#login button")
    private WebElement loginButton;


    public FormAuthenticationPageJBehave(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        dataFromPropertyFile = new DataFromPropertyFile();
    }

    public void goToLoginPage(){
        driver.get(dataFromPropertyFile.getGetTheInternetLoginPage());
    }

    public void setUsername() {
        usernameField.sendKeys(dataFromPropertyFile.getUserName());
    }

    public void setPassword() {
        passwordField.sendKeys(dataFromPropertyFile.getUserPassword());
    }

    public SecureAreaPageJBehave clickLoginButton() {
        loginButton.click();
        return new SecureAreaPageJBehave(driver);
    }


    @Override
    protected void load() {
        driver.get(dataFromPropertyFile.getGetTheInternetLoginPage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(dataFromPropertyFile.getGetTheInternetLoginPage(), driver.getCurrentUrl());
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }
}
