import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class CartPage {
    /**
     *All elements are identified by @FindBy annotation
     */
    private WebDriver driver;
    @FindBy(id="vendorsContainer")
    private WebElement container;

    public WebElement getContainer() {
        return container;
    }

    public CartPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getItmes(){
        List<WebElement> listaProduse =container.findElements(By.xpath("//*[@class='cart-widget cart-line']"));
        return listaProduse;
    }

    public String getProductData(WebElement e){

        String pretulMare=e.findElement(By.xpath(".//div[@class='price-main']/span")).getText();
        String pretMic=e.findElement(By.xpath(".//div[@class='price-main']/sup")).getText();

        return ""+pretulMare+","+pretMic+" Lei";

    }

    public Product getProduct(int index){
        Product p=new Product();
        boolean ok=true;
        List<WebElement> listaProduse =container.findElements(By.xpath(".//div[@class='cart-widget cart-line']"));
        WebElement e=listaProduse.get(index-1);
        p.setTitle(e.findElement(By.xpath(".//a[@class='line-item-title main-product-title']")).getText());
        try{
            e.findElement(By.xpath(".//*[@class='price-original']"));
        }catch(Exception exc){
            p.setOldPrice("");
            ok=false;
        }
        if(ok){
            p.setCartOldPrice(e.findElement(By.xpath(".//*[@class='price-original']")));
        }
        p.setCartNewPrice(e.findElement(By.xpath(".//div[@class='price-main']")));
        return p;
    }

    public List<Product> getProducts(){
        List<Product> products=new ArrayList<>();
        for(int i=1;i<=2;i++){
            products.add(i-1,getProduct(i));
        }
        return products;
    }

}
