package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static java.lang.Thread.sleep;

public class ProductPage extends LoadableComponent {

    private WebDriver driver;
    private JavascriptExecutor js;
    @FindBy(css = "button.btn-emag:nth-child(1)")
    private WebElement addToCart;
    @FindBy(xpath = ".//button[@class='close gtm_6046yfqs']")
    private WebElement close;
    @FindBy(id = "my_cart")
    private WebElement myCart;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public void addToCart() {
        js.executeScript("window.scrollTo(0,150)");
        addToCart.click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        close.click();
    }

    public CartPage viewCart() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("window.scrollTo(0,1)");
        myCart.click();
        return new CartPage(driver);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
