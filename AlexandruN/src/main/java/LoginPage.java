
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage {
    /**
     *All elements are identified by @FindBy annotation
     */
    public static Logger logger= LoggerFactory.getLogger(LoginPage.class);

    private WebDriver driver;
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

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getRecaptcha() {
        return recaptcha;
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getNextButon() {
        return nextButon;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
    public void login(){
        driver.get("https://www.emag.ro/user/login?not-keep=true");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        logger.info("Enter email");
        username.sendKeys("aly98_nesan@yahoo.com");
        nextButon.click();
        password.sendKeys("Stapanul29");
        loginButton.click();


    }

}
