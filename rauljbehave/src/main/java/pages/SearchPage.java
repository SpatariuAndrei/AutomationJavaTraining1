package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.utils.WebDriverUtilities;

import java.util.List;

public class SearchPage extends LoadableComponent {

    public static final String PRODUCT = ".//div[@class='card-item js-product-data']";
    public static final String IN_STOCK = ".//p[@class='product-stock-status text-availability-in_stock']";
    public static final String DISCOUNT_BADGE = "div.product-badge-box.js-product-badge-box";
    private WebDriver driver;
    @FindBy(css = "button.btn-block")
    private WebElement favoriteButtonForProduct;
    @FindBy(xpath = ".//div[@id='card_grid']")
    private WebElement productsContainer;
    @FindBy(css = "button.btn-emag:nth-child(1)")
    private WebElement buyButton;
    @FindBy(xpath = "//a[@id='my_wishlist']")
    private WebElement favoriteButtonForPage;
    private JavascriptExecutor js;
    private WebDriverUtilities  driverUtilities;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        driverUtilities = new WebDriverUtilities();
    }

    public void addToFavorite() {
        driverUtilities.waitForElementToBeVisible(productsContainer, 10);
        List<WebElement> list = productsContainer.findElements(By.xpath(PRODUCT));
        for (WebElement webElement : list) {
            try {
                if (webElement.findElement(By.xpath(IN_STOCK)).getText().equals("în stoc")) {
                    driverUtilities.waitForElementToBeClickable(productsContainer, 10);
                    favoriteButtonForProduct.click();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Not in stock");
            }
        }
    }

    public WebElement getProductWithDiscountBadge() {
        js.executeScript("window.scrollTo(0,900)");
        List<WebElement> list = productsContainer.findElements(By.xpath(PRODUCT));
        WebElement prodWithDiscount = null;
        for (WebElement webElement : list) {
            try {
                prodWithDiscount = webElement.findElement(By.cssSelector(DISCOUNT_BADGE));
                if (prodWithDiscount != null) {
                    if (webElement.findElement(By.xpath(".//p[@class='product-stock-status text-availability-in_stock']")).getText().equals("în stoc")) {
                        return webElement;
                    }
                }
            } catch (Exception e) {
                System.out.println("Product with discount badge not found");
            }
        }
        return prodWithDiscount;
    }

    public ProductPage foundProductWithDiscountBadge() {
        return new ProductPage(driver);
    }

    public FavoritesPage goToProductFavoritesPage() {
        favoriteButtonForPage.click();
        return new FavoritesPage(driver);
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
