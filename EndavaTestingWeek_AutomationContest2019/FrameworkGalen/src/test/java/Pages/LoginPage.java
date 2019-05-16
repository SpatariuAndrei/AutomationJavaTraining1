package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage<LoginPage> {

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //WebElements
    @FindBy(xpath="//input[@type='email']")
    private WebElement emailWebField;

    @FindBy(xpath="//input[@type='password']")
    private WebElement passwordWebField;

    @FindBy(xpath="//button")
    private WebElement signUpWebField;

    //Functions
    public AccountPage loginProcess(String email, String password)
    {
        emailWebField.sendKeys(email);
        passwordWebField.sendKeys(password);
        signUpWebField.click();
        return new AccountPage(driver);
    }























    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue("The element is not present", driver.getCurrentUrl().contains("lambda"));
    }

}
