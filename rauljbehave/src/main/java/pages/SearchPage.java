package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.List;

public class SearchPage extends LoadableComponent {

    public static final String PRODUCT = ".//div[@class='card-item js-product-data']";
    public static final String IN_STOCK = ".//p[@class='product-stock-status text-availability-in_stock']";
    private WebDriver driver;
    @FindBy(css = "button.btn-block")
    private WebElement favoriteButton;
    @FindBy(xpath = ".//div[@id='card_grid']")
    private WebElement productsContainer;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addToFavorite() {
        List<WebElement> list = productsContainer.findElements(By.xpath(PRODUCT));
        for (WebElement webElement : list) {
            try {
                if (webElement.findElement(By.xpath(IN_STOCK)).getText().equals("în stoc")) {
                    favoriteButton.click();
                    break;
                }
            } catch (Exception e) {
                System.out.println("Not in stock");
            }
        }
    }

    @Override
    protected void load() {
    }

    @Override
    protected void isLoaded() throws Error {

    }
}
