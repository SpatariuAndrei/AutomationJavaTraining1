package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.DataFromPropertyFile;

import static org.junit.Assert.assertEquals;

public class LoginPage extends LoadableComponent<LoginPage> {

    private WebDriver driver;
    private DataFromPropertyFile dataFromPropertyFile;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        dataFromPropertyFile = new DataFromPropertyFile();
    }
    /**
     *All elements are identified by @FindBy annotation
     */
    public static Logger logger= LoggerFactory.getLogger(LoginPage.class);

    @FindBy(name="username")
    private WebElement username;
    @FindBy(xpath="/html/body/form/div[4]")
    private WebElement nextButon;
    @FindBy(name="password")
    private WebElement password;
    @FindBy(xpath="/html/body/form/div[4]/div/button")
    private WebElement loginButton;
    @FindBy(css="html body div.rc-anchor.rc-anchor-normal.rc-anchor-light div.rc-anchor-content div.rc-inline-block div.rc-anchor-center-container label#recaptcha-anchor-label.rc-anchor-center-item.rc-anchor-checkbox-label")
    private WebElement recaptcha;

    public void login(){
        logger.info("Enter email");
        username.sendKeys(dataFromPropertyFile.getUserEmail());
        nextButon.click();
        password.sendKeys(dataFromPropertyFile.getUserPassword());
        loginButton.click();
    }

    @Override
    protected void load() {
        driver.get(dataFromPropertyFile.getEmagLoginPage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(dataFromPropertyFile.getEmagLoginPage(), driver.getCurrentUrl());
    }
}
