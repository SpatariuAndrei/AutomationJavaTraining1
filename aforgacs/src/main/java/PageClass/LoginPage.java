package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage{
    static final Logger LOG = LoggerFactory.getLogger(LoginPage.class);


    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath="/html/body/form/div[4]/div/button")
    private WebElement continueButton;

    @FindBy(id="email")
    private WebElement emailField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(linkText="Log out")
    private WebElement signOutButton;

    @FindBy(xpath="//*[@id=\"emg-user-menu\"]/span[2]")
    private WebElement accountMenu;

    public LoginPage(WebDriver wd, WebDriverWait wdw){
        this.driver = wd;
        this.wait = wdw;
        PageFactory.initElements(driver, this);
    }

    public WebElement getContinueButton() {
        return continueButton;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public void logIn(MainPage m){
        m.getMyAccount().click();

        LOG.trace("Enter email adress");
        emailField.sendKeys("akos1995@yahoo.com");
        LOG.trace("Press contnue");
        continueButton.click();

        wait.until(ExpectedConditions.visibilityOf(passwordField));

        LOG.trace("Enter password");
        passwordField.sendKeys("poi098");
        LOG.trace("Press contnue");
        continueButton.click();
    }

    public void logOut(){
        LOG.trace("Hover on account menu");
        Actions action = new Actions(driver);
        action.moveToElement(accountMenu).perform();

        LOG.trace("Click on SignOut");
        wait.until(ExpectedConditions.visibilityOf(signOutButton));
        signOutButton.click();

    }
}
