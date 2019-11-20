package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class FormAuthenticationPage extends LoadableComponent<FormAuthenticationPage> {

    //*********Page Variables*********
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage page;
    private LoadableComponent<HomePage> parent;
    private final String authURL = "http://the-internet.herokuapp.com/login";

    //*********Constructor*********
    public FormAuthenticationPage(WebDriver driver, LoadableComponent<HomePage> parent) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, 10);
        page = new BasePage(this.driver);
        this.parent = parent;
    }

    //*********Web Elements*********
    @FindBy(id = "username")
    private WebElement usernameField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(xpath = "//button[@class='radius']")
    private WebElement loginButton;

    //*********Override LoadableComponent Methods*********
    @Override
    protected void load() {
        parent.get().goToFormAuthenticationPage();
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("FormAuthenticationPage is not loaded!", driver.getCurrentUrl().contains(authURL));
    }

    //*********Page Methods*********
    public void login(String username, String password) {
        page.writeText(usernameField, username);
        page.writeText(passwordField, password);
    }

    public SecureAreaPage goToSecureAreaPage() {
        page.click(loginButton);
        return new SecureAreaPage(this.driver, this);
    }
}