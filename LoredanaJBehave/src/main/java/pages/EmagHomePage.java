package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.components.ProductResultsPage;
import utils.*;

import static org.testng.AssertJUnit.assertTrue;

public class EmagHomePage extends LoadableComponent<EmagHomePage> {

    //*********Page Variables*********
    private SharedData sharedData;
    private Helper helper;
    private DataFromPropertyFile dataFromPropertyFile;
    private WebDriverUtilities webDriverUtilities;
    //*********Web Elements*********
    @FindBy(xpath = "//span[contains(text(),'Contul meu')]")
    private WebElement myAccount;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-emag btn-sm']")
    private WebElement enterInMyAccount;
    @FindBy(xpath = "div[@class='user-avatar user-avatar-ub']//div[@class='picture']")
    private WebElement profilePic;
    @FindBy(xpath = "//p[@class='name']")
    private WebElement name;
    @FindBy(xpath = "//input[@id='searchboxTrigger']")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@class='ns-wrap-top-right']")
    private WebElement notificationFrame;


    //*********Constructor*********
    public EmagHomePage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
        helper = new Helper(sharedData);
        dataFromPropertyFile = new DataFromPropertyFile();
        webDriverUtilities = new WebDriverUtilities();
    }

    //*********Override LoadableComponent Methods*********
    @Override
    protected void load() {
        this.sharedData.driver.get(dataFromPropertyFile.getBaseURL());
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("EmagHomePage is not loaded!", sharedData.driver.getCurrentUrl().contains(dataFromPropertyFile.getBaseURL()));
    }

    //*********Methods*********
    public LoginPage navigateToLoginPage() {
        sharedData.loginPage = clickOnMyAccount();
        return sharedData.loginPage;
    }

    public LoginPage clickOnMyAccount() {
        enterInMyAccount.click();
        return new LoginPage(sharedData);
    }

    public void clickOnProfile() {
        webDriverUtilities.waitForElementToBeVisible(myAccount, Constants.TIMEOUT);
        myAccount.click();
    }

    public void moveOverProfilePicture() {
        helper.moveOverElement(profilePic);
    }

    public String getStatus() {
        return helper.getText(name);
    }

    public ProductResultsPage searchProduct(String product) {
        webDriverUtilities.waitForElementToBeClickable(searchBar, Constants.TIMEOUT);
        searchBar.clear();
        searchBar.sendKeys(product, Keys.ENTER);
        return new ProductResultsPage(sharedData);
    }

    public String getNotificationText() {
        webDriverUtilities.waitForElementToBeVisible(notificationFrame, Constants.TIMEOUT);
        return helper.getText(notificationFrame);
    }
}
