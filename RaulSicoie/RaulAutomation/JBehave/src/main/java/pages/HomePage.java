package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.utils.WebDriverUtilities;
import utilities.DataFromPropertyFile;
import utilities.constants.TimeConstants;

import static org.junit.Assert.assertEquals;

public class HomePage extends LoadableComponent {

    @FindBy(id = "searchboxTrigger")
    private WebElement searchBar;

    @FindBy(xpath = "//button[@class='btn btn-default searchbox-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='my_account']")
    private WebElement enterAccount;

    @FindBy(xpath = "//nav[@id='masthead']")
    private WebElement horizontalMenuContainer;

    private WebDriver driver;
    private DataFromPropertyFile propertyFile;
    private WebDriverUtilities driverUtilities;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        propertyFile = new DataFromPropertyFile();
        driverUtilities = new WebDriverUtilities();
    }

    @Override
    protected void load() {
        driver.get(propertyFile.getEmagPage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(propertyFile.getEmagPage(), driver.getCurrentUrl());
    }

    public SearchPage searchProduct(String product) {
        driverUtilities.waitForElementToBeVisible(searchBar, TimeConstants.LONG_TIMEOUT);
        searchBar.sendKeys(product);
        driverUtilities.waitForElementToBeClickable(searchButton, TimeConstants.LONG_TIMEOUT);
        searchButton.click();
        return new SearchPage(driver);
    }

    public LoginPage navigateToLoginPage() {
        driverUtilities.waitForElementToBeClickable(enterAccount, TimeConstants.LONG_TIMEOUT);
        enterAccount.click();
        return new LoginPage(driver);
    }

    public PersonalDataPage goToPersonalDataPage() {
        driverUtilities.waitForElementToBeVisible(horizontalMenuContainer, TimeConstants.LONG_TIMEOUT);
        enterAccount.click();
        return new PersonalDataPage(driver);
    }
}
