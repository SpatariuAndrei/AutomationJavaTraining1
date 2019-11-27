package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.constants.TimeConstants;
import pages.utils.WebDriverUtilities;

public class ProductPage {

    @FindBy(css = "button.btn-emag:nth-child(1)")
    private WebElement addToCart;

    @FindBy(xpath = ".//button[@class='close gtm_6046yfqs']")
    private WebElement close;

    @FindBy(id = "my_cart")
    private WebElement myCart;

    private WebDriver driver;
    private JavascriptExecutor js;
    private WebDriverUtilities driverUtilities;
    private TimeConstants constants;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        driverUtilities = new WebDriverUtilities();
    }

    public void addToCart() {
        js.executeScript("window.scrollTo(0,150)");
        driverUtilities.waitForElementToBeClickable(addToCart, constants.LONG_TIMEOUT);
        addToCart.click();
        driverUtilities.waitForElementToBeClickable(close, constants.LONG_TIMEOUT);
        close.click();
    }

    public CartPage viewCart() {
        js.executeScript("window.scrollTo(0,0)");
        driverUtilities.waitForElementToBeVisible(myCart, constants.LONG_TIMEOUT);
        driverUtilities.waitForElementToBeClickable(myCart, constants.LONG_TIMEOUT);
        myCart.click();
        return new CartPage(driver);
    }
}
