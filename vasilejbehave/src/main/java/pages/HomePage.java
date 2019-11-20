package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;


public class HomePage extends LoadableComponent<HomePage> {

    //*********Page Variables*********
    private String baseURL = "https://the-internet.herokuapp.com/";
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage basePage;

    //*********Constructor*********
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, 10);
        basePage = new BasePage(driver);
    }

    //*********Web Elements*********
    @FindBy(linkText = "Form Authentication")
    private WebElement authForm;

    //*********Override LoadableComponent Methods*********
    @Override
    protected void load() {
        this.driver.get(baseURL);
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("HomePage is not loaded!", driver.getCurrentUrl().contains(baseURL));
    }

    //*********Page Methods*********
    public FormAuthenticationPage goToFormAuthenticationPage() {
        basePage.click(authForm);
        return new FormAuthenticationPage(this.driver, this);
    }
}