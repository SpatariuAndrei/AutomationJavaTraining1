package Pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BlogListPage extends BasePage<BlogListPage> {

    public BlogListPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //WebElements
    @FindBy(xpath="//div[@class='popover-footer']")
    private WebElement notificationsPopUp;

    @FindBy(xpath="//div[@class='popover-footer']/button")
    private List<WebElement> notifications_buttons;

    @FindBy(xpath="//div[@class='intercom-authored-container']")
    private WebElement chatBarWeb;

    @FindBy(xpath="//div[@class='intercom-authored-container']/span")
    private WebElement chatBarCancelButton;

    @FindBy(xpath="//div[@class='col-xs-12 col-md-5 blog-paddl0 thumb-img']")
    private List<WebElement> imagesBlogPosts;


    //Functions
    public BlogListPage selectBlog()
    {
        functions.clickWebElement(imagesBlogPosts.get(0),driver);
        return this;
    }

    public BlogListPage validatePage(String expected)
    {
        validate(expected);
        return this;
    }



































    public BlogListPage validate(String expected)
    {
        functions.waitExtreme();
        functions.validatePage(expected,driver);
        int size=notifications_buttons.size();
        if(size>0)
        {
            functions.hoverWebElement(notifications_buttons.get(1),driver);
            notifications_buttons.get(1).click();
        }
//        functions.waitExtreme();
//        try{
//            if(chatBarWeb.isDisplayed())
//            {
//                chatBarCancelButton.click();
//            }
//        }
//        catch(NoSuchElementException e)
//        {
//            System.out.println(e);
//        }
        return this;
    }

    public BlogListPage clickBlogNavBar()
    {
        if(navBarBlog.isDisplayed())
        {
            functions.clickWebElement(navBarBlog,driver);
        }
        return this;
    }





































    protected void load() {
        driver.navigate().refresh();
    }

    protected void isLoaded() throws Error {
        Assert.assertTrue("The element is not present", driver.getCurrentUrl().contains("lambda"));
    }
}
