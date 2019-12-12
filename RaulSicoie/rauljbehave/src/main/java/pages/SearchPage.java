package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.utils.WebDriverUtilities;
import utilities.constants.TimeConstants;
import utilities.scroll.Scroll;

import java.util.List;

public class SearchPage {

    @FindBy(css = "button.btn-block")
    private WebElement favoriteButtonForProduct;

    @FindBy(xpath = ".//div[@id='card_grid']")
    private WebElement productsContainer;

    @FindBy(xpath = "//a[@id='my_wishlist']")
    private WebElement favoriteButtonForPage;

    private static final String PRODUCT = ".//div[@class='card-item js-product-data']";
    private static final String IN_STOCK = ".//p[@class='product-stock-status text-availability-in_stock']";
    private static final String DISCOUNT_BADGE = "div.product-badge-box.js-product-badge-box";

    private JavascriptExecutor js;
    private WebDriverUtilities driverUtilities;
    private WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(SearchPage.class);

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
        driverUtilities = new WebDriverUtilities();
    }

    public void addToFavorite() {
        driverUtilities.waitForElementToBeVisible(productsContainer, TimeConstants.LONG_TIMEOUT);
        List<WebElement> list = productsContainer.findElements(By.xpath(PRODUCT));
        for (WebElement webElement : list) {
            try {
                if (webElement.findElement(By.xpath(IN_STOCK)).getText().equals("în stoc")) {
                    driverUtilities.waitForElementToBeClickable(favoriteButtonForProduct, TimeConstants.LONG_TIMEOUT);
                    favoriteButtonForProduct.click();
                    break;
                }
            } catch (Exception e) {
                logger.info("Product wanted to add to favorites is not in stock!");
            }
        }
    }

    public WebElement getProductWithDiscountBadge() {
        Scroll.scrollTillElementFound(productsContainer, driver);
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
                logger.info("Product with discount badge not found!");
            }
        }
        return prodWithDiscount;
    }

    public ProductPage foundProductWithDiscountBadge() {
        getProductWithDiscountBadge().click();
        return new ProductPage(driver);
    }

    public ProductPage foundFirstProduct() {
        driverUtilities.waitForElementToBeVisible(productsContainer, TimeConstants.LONG_TIMEOUT);
        List<WebElement> list = productsContainer.findElements(By.xpath(PRODUCT));
        for (WebElement webElement : list) {
            try {
                if (webElement.findElement(By.xpath(IN_STOCK)).getText().equals("în stoc")) {
                    driverUtilities.waitForElementToBeClickable(favoriteButtonForProduct, TimeConstants.LONG_TIMEOUT);
                    webElement.click();
                    break;
                }
            } catch (Exception e) {
                logger.info("Product not in stock!");
            }
        }
        return new ProductPage(driver);
    }

    public FavoritesPage goToProductFavoritesPage() {
        favoriteButtonForPage.click();
        return new FavoritesPage(driver);
    }
}
