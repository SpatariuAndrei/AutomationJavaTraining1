package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.utils.WebDriverUtilities;
import utilities.constants.TimeConstants;
import utilities.scroll.Scroll;

public class ProductPage {

    @FindBy(css = "button.btn-emag:nth-child(1)")
    private WebElement addToCart;

    @FindBy(xpath = ".//button[@class='close gtm_6046yfqs']")
    private WebElement close;

    @FindBy(id = "my_cart")
    private WebElement myCart;

    @FindBy(xpath = "//*[@id='masthead']")
    private WebElement navigationBar;

    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverUtilities driverUtilities;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        driverUtilities = new WebDriverUtilities();
    }

    public void addToCart() {
        Scroll.scrollToElement(addToCart, driver);
        driverUtilities.waitForElementToBeClickable(addToCart, TimeConstants.LONG_TIMEOUT);
        addToCart.click();
        driverUtilities.waitForElementToBeClickable(close, TimeConstants.LONG_TIMEOUT);
        close.click();
    }

    public CartPage viewCart() {
        Scroll.scrollToElement(navigationBar, driver);
        driverUtilities.waitForElementToBeVisible(navigationBar, TimeConstants.LONG_TIMEOUT);
        driverUtilities.waitForElementToBeVisible(myCart, TimeConstants.LONG_TIMEOUT);
        driverUtilities.waitForElementToBeClickable(myCart, TimeConstants.LONG_TIMEOUT);
        myCart.click();
        return new CartPage(driver);
    }
}
