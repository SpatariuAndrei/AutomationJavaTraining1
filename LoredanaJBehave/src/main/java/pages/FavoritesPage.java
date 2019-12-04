package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.SharedData;

import java.util.List;

public class FavoritesPage {

    //*********Page Variables*********
    private SharedData sharedData;
    //*********Web Elements*********
    By product = By.xpath(".//div[@class='product-card-account pad-sep-sm  ']");
    By deleteButton = By.cssSelector("button.remove-from-favorites");


    //*********Constructor*********
    public FavoritesPage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
    }

    public List<WebElement> getFavorites() {
        return sharedData.driver.findElements(product);
    }

    public void deleteAllFavoriteProducts() throws InterruptedException {
        for (int i = 0; i < getFavorites().size(); i++) {
            sharedData.driver.findElement(product).findElement(deleteButton).click();
            // TODO (optional)
            Thread.sleep(Constants.SLEEP);
        }
    }
}
