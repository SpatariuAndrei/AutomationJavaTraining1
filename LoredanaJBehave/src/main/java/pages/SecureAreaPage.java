package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;

public class SecureAreaPage extends LoadableComponent<FormAuthenticationPage> {

    //*********Page Variables*********
    private WebDriver driver;
    private WebDriverWait wait;
    private BasePage page;
    private LoadableComponent<FormAuthenticationPage> parent;
    private final String secureAreaURL = "http://the-internet.herokuapp.com/secure";

    //*********Constructor*********
    public SecureAreaPage(WebDriver driver, LoadableComponent<FormAuthenticationPage> parent) {
        this.driver = driver;

        PageFactory.initElements(driver,this);
        this.wait = new WebDriverWait(driver, 10);
        page = new BasePage(this.driver);
        this.parent = parent;
    }

    //*********Web Elements*********
    @FindBy(xpath = "//h4[@class='subheader']")
    private WebElement message;

    //*********Override LoadableComponent Methods*********
    @Override
    protected void load() {
        parent.get().goToSecureAreaPage();
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("SecuredAreaPage is not loaded!", driver.getCurrentUrl().contains(secureAreaURL));
    }

    //*********Page Methods*********
    public boolean verifyResponse(String msg) {
        return page.readText(message).contains(msg);
    }
}