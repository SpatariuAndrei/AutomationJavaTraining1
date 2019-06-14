import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {
    /**
     * All
     */
    private WebDriver driver;

    @FindBy(xpath=".//div[@id='card_grid']")
    private WebElement productsContainer;

    public SearchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getItmes(){
        List<WebElement> listaProduse =productsContainer.findElements(By.xpath(".//div[@class='card-item js-product-data']"));
        return listaProduse;
    }

}
