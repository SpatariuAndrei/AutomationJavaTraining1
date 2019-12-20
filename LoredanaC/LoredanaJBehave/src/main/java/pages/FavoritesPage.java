package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.Constants;
import utils.SharedData;
import utils.WebDriverUtilities;

import java.util.List;

public class FavoritesPage {

    //*********Page Variables*********
    private SharedData sharedData;
    private WebDriverUtilities webDriverUtilities;
    //*********Web Elements*********
    private By product = By.xpath(".//div[@class='product-card-account pad-sep-sm  ']");
    private  By deleteButton = By.cssSelector("button.remove-from-favorites");


    //*********Constructor*********
    public FavoritesPage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
        webDriverUtilities = new WebDriverUtilities(sharedData);
    }

    public List<WebElement> getFavorites() {
        return sharedData.driver.findElements(product);
    }

    public void deleteAllFavoriteProducts() throws InterruptedException {

        List<WebElement> allproducts = getFavorites();
        for(int i=0; i<allproducts.size();i++)
        {
            allproducts.get(i).findElement(deleteButton).click();
            webDriverUtilities.waitUntilPageIsLoaded(Constants.TIMEOUT);
        }
    }
}
