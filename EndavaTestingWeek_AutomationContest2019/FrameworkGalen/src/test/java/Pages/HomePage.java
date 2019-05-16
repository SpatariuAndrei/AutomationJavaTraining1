package Pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage<HomePage> {

    public HomePage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //WebElements
    @FindBy(xpath="//li[@class='sign-in']")
    private WebElement signUpWebButton;

    @FindBy(xpath="//div[@class='navbar-toggle collapsed']/img")
    private WebElement navBarWebMenu;

    @FindBy(xpath="//li[@class='login']/a")
    private WebElement dashboardWebButton;



    //Functions
    //Sign up button click
    public LoginPage clickSignUp()
    {
        clickSignUpButton();
        return new LoginPage(driver);
    }

    //Blog list button click
    public BlogListPage clickBlogListButton()
    {
        blogListButton();
        return new BlogListPage(driver);
    }

    public HomePage validateHomePage(String expected) throws Exception {
        functions.validatePage(expected,driver);
        return this;
    }

    public LoginPage clickSignUpButton()
    {
        loginButton();
        return new LoginPage(driver);
    }



















    public void loginButton()
    {
        try {
            if(signUpWebButton.isDisplayed()) {
                functions.clickWebElement(signUpWebButton,driver);
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e);
        }

        try{
            if(navBarWebMenu.isDisplayed()) {
                functions.waitExplicit(dashboardWebButton, driver);
                functions.clickWebElement(dashboardWebButton,driver);
            }
        }
        catch(NoSuchElementException e)
        {System.out.println(e);}

        try{
            if(dashboardWebButton.isDisplayed())
            {
                functions.clickWebElement(dashboardWebButton,driver);
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e);
        }
    }

    public void blogListButton()
    {
        try {
            if(blogListWebButton.isDisplayed()) {
                blogListWebButton.click();
            }
        }
        catch(NoSuchElementException e)
        {
            System.out.println(e);
        }
    }

    public HomePage clickNavBar()
    {
        if(navBarWebMenu.isDisplayed()) {
            navBarWebMenu.click();
        }
        return this;
    }







    //Enter the page desired
    public void load() {

        driver.get("https://www.lambdatest.com/");
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue("The element is not present", functions.isElementPresent(signUpWebButton));


    }


}


