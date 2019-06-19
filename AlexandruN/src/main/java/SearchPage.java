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

    public WebElement getReducedProduct(){
        List<WebElement> list = productsContainer.findElements(By.xpath(".//div[@class='card-item js-product-data']"));
        WebElement produsRedus = null;
        for(WebElement element: list){
            try{
                produsRedus=element.findElement(By.xpath(".//p[@class='product-old-price']"));
                if(element.findElement(By.xpath(".//p[@class='product-stock-status text-availability-in_stock']")).getText().equals("în stoc")){
                    return element;
                }

            }catch(Exception e){

            }
        }
        return produsRedus;
    }

    public WebElement getNormalProduct() {
        List<WebElement> list = productsContainer.findElements(By.xpath(".//div[@class='card-item js-product-data']"));
        WebElement produsNormal = null;
        for(WebElement element: list){
            try{
                produsNormal=element.findElement(By.xpath(".//p[@class='product-old-price']"));

            }catch(Exception e){
                produsNormal=element.findElement(By.xpath((".//p[@class='product-new-price']")));
                return produsNormal;
            }

        }
        return produsNormal;
    }

}
