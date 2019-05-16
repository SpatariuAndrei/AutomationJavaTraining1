package Pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage<AccountPage> {

    public AccountPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //WebElements
    @FindBy(id="userName")
    private WebElement usernameHeaderWeb;

    @FindBy(xpath="//div[@class='dropdown-menu dropdown-menu-right show']/a[5]")
    private WebElement logoutButtonWeb;

    //Functions
    public AccountPage validatePage(String expected)
    {
        functions.validatePage(expected,driver);
        return this;
    }

    public HomePage logoutProcess()
    {
        logoutFromSignUp();
        return new HomePage(driver);
    }
























    public void logoutFromSignUp()
    {
        try{
                functions.waitExplicit(logoutButtonWeb,driver);
                functions.clickWebElement(logoutButtonWeb,driver);
                driver.navigate().to("https://www.lambdatest.com/");
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e);
        }
    }

    public void clickUsername()
    {
        usernameHeaderWeb.click();
    }

    public void clickUsernameWithSignUp()
    {
        if(signUpWebField.isDisplayed()) {
            signUpWebField.click();
            functions.waitExplicit(usernameHeaderWeb, driver);
            usernameHeaderWeb.click();
        }
    }

//    public void logoutDirect()
//    {
//        try{
//            functions.waitExplicit(logoutButtonWeb,driver);
//            functions.clickWebElement(logoutButtonWeb,driver);
//            driver.navigate().to("https://www.lambdatest.com/");
//        }
//        catch(NoSuchElementException e)
//        {
//            System.out.println(e);
//        }
//    }












    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue("The element is not present", driver.getCurrentUrl().contains("lambda"));
    }
}
