package emag_test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.NoSuchElementException;

public class Login {

    WebDriver driver;

    @FindBy(id="email")
    WebElement userEmail;

    @FindBy(id="password")
    WebElement userPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement userPasswordSubmit;

    public Login(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);

    }

    public void LoginUser(String strEmail,String pass) throws NoSuchElementException, InterruptedException{

        userEmail.sendKeys(strEmail);
        userEmail.sendKeys(Keys.ENTER);

        Thread.sleep(500);

        userPassword.click();
        userPassword.sendKeys(pass);
        userPasswordSubmit.click();
    }

    public boolean isLoggedIn(){
        try{
            driver.findElement(By.xpath("//i[@class='em em-user_fill navbar-icon']"));
            return false;
        }catch(Exception e){
            return true;
        }
    }

}
