package Pages;

import Help.HelperMethods;
import com.galenframework.api.Galen;
import com.galenframework.reports.model.LayoutReport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.io.IOException;
import java.util.Arrays;

public abstract class BasePage<T extends LoadableComponent<T>>extends LoadableComponent<T> {

    WebDriver driver;
    public HelperMethods functions = new HelperMethods(driver);


    //Constructor
    public BasePage(WebDriver driver) {
        {
            this.driver = driver;
            PageFactory.initElements(driver, this);

        }
    }


    //WebElements
    @FindBy(xpath="//button")
    public WebElement signUpWebField;

    @FindBy(xpath="//ul[@class='nav navbar-nav navbar-right']//a[contains(text(),'Blog')]")
    public WebElement blogListWebButton;

    @FindBy(className="menu-toggle")
    public WebElement navBarBlog;



    //Methods


}
