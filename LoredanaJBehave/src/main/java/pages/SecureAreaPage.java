package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataFromPropertyFile;
import utils.Helper;

import java.io.IOException;

import static org.testng.AssertJUnit.assertTrue;

public class SecureAreaPage extends LoadableComponent<FormAuthenticationPage> {

    //*********Page Variables*********
    private WebDriver driver;
    private WebDriverWait wait;
    private Helper helper;
    private LoadableComponent<FormAuthenticationPage> parent;
    private DataFromPropertyFile dataFromPropertyFile = new DataFromPropertyFile();

    //*********Constructor*********
    public SecureAreaPage(WebDriver driver, LoadableComponent<FormAuthenticationPage> parent) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
        helper = new Helper(this.driver);
        this.parent = parent;
        dataFromPropertyFile = new DataFromPropertyFile();
    }

    //*********Web Elements*********
    @FindBy(xpath = "//h4[@class='subheader']")
    private WebElement message;

    //*********Override LoadableComponent Methods*********
    @Override
    protected void load() {
        try {
            parent.get().goToSecureAreaPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("SecuredAreaPage is not loaded!", driver.getCurrentUrl().contains(dataFromPropertyFile.getSecureAreaURL()));
    }

    //*********Page Methods*********
    public boolean verifyResponse(String msg) {
        return helper.getText(message).contains(msg);
    }
}