package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.*;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class FormAuthenticationPage extends LoadableComponent<FormAuthenticationPage> {

    //*********Page Variables*********
    private WebDriver driver;
    private WebDriverWait wait;
    private Helper page;
    private LoadableComponent<HomePage> parent;
    private DataFromPropertyFile dataFromPropertyFile = new DataFromPropertyFile();

    //*********Constructor*********
    public FormAuthenticationPage(WebDriver driver, LoadableComponent<HomePage> parent) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
        page = new Helper(this.driver);
        this.parent = parent;
        dataFromPropertyFile = new DataFromPropertyFile();
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
        try {
            parent.get().goToFormAuthenticationPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("FormAuthenticationPage is not loaded!", driver.getCurrentUrl().contains(dataFromPropertyFile.getAuthURL()));
    }

    //*********Page Methods*********
    public void login(String username, String password) {
        page.setText(usernameField, username);
        page.setText(passwordField, password);
    }

    public SecureAreaPage goToSecureAreaPage() throws IOException {
        page.click(loginButton);
        return new SecureAreaPage(this.driver, this);
    }
}