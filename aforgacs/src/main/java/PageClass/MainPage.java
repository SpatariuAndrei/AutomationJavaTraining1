package PageClass;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage {
    static final Logger LOG = LoggerFactory.getLogger(MainPage.class);

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id=\"masthead\"]/div/div/div[1]/a")
    private WebElement homeButton;

    @FindBy(id = "my_account")
    private WebElement myAccount;

    @FindBy(id = "searchboxTrigger")
    private WebElement searchBar;

    @FindBy(xpath = "//a[@id='my_cart' or @id='emg-mini-cart']")
    private WebElement cart;

    @FindBy(xpath = "//div[@class=\"nav-product-list-wrapper\"]")
    private WebElement cartMenu;

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getSearchBar() {
        return searchBar;
    }

    public WebElement getCart() {
        return cart;
    }

    public MainPage(WebDriver wd, WebDriverWait wdw){
        this.driver = wd;
        this.wait = wdw;
        PageFactory.initElements(driver, this);
    }

    public WebElement getMyAccount() {
        LOG.trace("returns the myAccount WebElement");
        return myAccount;
    }

    public void goToCart() {
        Actions action = new Actions(driver);

        LOG.trace("Waiting to load the cart");
        action.moveToElement(cart).perform();
        wait.until(ExpectedConditions.visibilityOf(cartMenu));

        LOG.trace("Click on cart");
        cart.click();
    }

    public void search(String s){
        LOG.trace("Search for keyword: " + s);
        searchBar.clear();
        searchBar.sendKeys(s + Keys.ENTER);
    }
}
