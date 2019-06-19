package classPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.NoSuchElementException;

public class Login {

    private WebDriver driver;
    private static Logger logger = LoggerFactory.getLogger(Login.class);
    private WebDriverWait wait1;


    @FindBy(id = "email")
    private
    WebElement userEmail;

    @FindBy(id = "password")
    private
    WebElement userPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private
    WebElement userPasswordSubmit;

    @FindBy(xpath ="//*[@id='masthead']//*[@class='navbar-branding']")
    private
    WebElement homePageButton;

    public Login(WebDriver driver) {

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    public void LoginUser(String strEmail, String pass) throws NoSuchElementException, InterruptedException {

        wait1= new WebDriverWait(driver, 10);

        logger.info("Enter email adress");
        userEmail.sendKeys(strEmail);
        userEmail.sendKeys(Keys.ENTER);

        Thread.sleep(500);
        logger.info("Enter password");
        userPassword.click();
        userPassword.sendKeys(pass);
        userPasswordSubmit.click();

        //wait1.until(ExpectedConditions.visibilityOf(homePageButton));

    }

    public boolean isLoggedIn() {
        logger.info("Check if the user is logged in");
        try {
            driver.findElement(By.xpath("//i[@class='navbar-icon navbar-thumb']"));
            return false;
        } catch (Exception e) {
            return true;
        }
    }

}
