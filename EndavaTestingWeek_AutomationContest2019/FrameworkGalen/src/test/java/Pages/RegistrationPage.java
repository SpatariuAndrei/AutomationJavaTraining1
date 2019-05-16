package Pages;

import Help.HelperMethods;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage<RegistrationPage> {

    public HelperMethods functions=new HelperMethods(driver);

    public RegistrationPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //WebElements
    @FindBy(xpath="//p[@class='terms-cond']//input")
    private WebElement termsConditionsWeb;

    @FindBy(xpath="//input[@name='organization_name']")
    private WebElement organizationName;

    @FindBy(xpath="//input[@name='name']")
    private WebElement fullName;

    @FindBy(xpath="//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath="//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath="//input[@name='phone']")
    private WebElement phoneField;

    @FindBy(xpath="//button[@type='submit']")
    private WebElement submitButton;

    //Functions
    public AccountPage registerProcess(String organization,String name,String email,String password,String phone)
    {
        registrationProcess(organization,name,email,password,phone);
        return new AccountPage(driver);
    }


    public RegistrationPage registrationProcess(String organization,String name,String email,String password,String phone)
    {
        functions.fillWebElement(organizationName,driver,organization);
        functions.fillWebElement(fullName,driver,name);
        functions.fillWebElement(emailField,driver,email);
        functions.fillWebElement(passwordField,driver,password);
        functions.fillWebElement(phoneField,driver,phone);
        functions.clickWebElement(termsConditionsWeb,driver);
        functions.clickWebElement(submitButton,driver);
        return this;
    }








    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue("The element is not present", driver.getCurrentUrl().contains("lambda"));
    }
}
