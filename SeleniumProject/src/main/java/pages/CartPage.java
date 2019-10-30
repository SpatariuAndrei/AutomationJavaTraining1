package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.utils.Product;
import utilities.DataFromPropertyFile;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CartPage extends LoadableComponent<CartPage> {
    /**
     *All elements are identified by @FindBy annotation
     */
    private WebDriverWait wait;
    private WebDriver driver;
    private DataFromPropertyFile dataFromPropertyFile = new DataFromPropertyFile();

    public WebElement getContainer() {
        return container;
    }

    @FindBy(id="vendorsContainer")
    private WebElement container;

    @FindBy(xpath = ".//div[@class='summary-line']//span[@class='emg-right order-summary-items-price']")
    private WebElement totalPrice;

    @FindBy(xpath = ".//a[@id='emg-user-menu']")
    private WebElement myAccount;

    @FindBy(xpath = ".//a[@class='js-logout-btn']")
    private WebElement logoutButton;


    public CartPage(WebDriver driver) {
        this.driver = driver;
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
            p.setStringOldPrice("");
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

    public float totalPrice(){
       // WebElement total=container.findElement(By.xpath(".//div[@class='order-summary-text emg-col5']//span[@class='emg-right order-summary-items-price']"));
        String bigPrice=totalPrice.getText().substring(0,5);
        String smallPrice=totalPrice.findElement(By.xpath(".//sup")).getText();
        String priceS=""+bigPrice+","+smallPrice;
        String finalPrice="";
        String[] tokens=priceS.split(",");
        String[] tokensInt=tokens[0].split("\\.");
        for(String s:tokensInt){
            finalPrice=finalPrice+s;
        }
        finalPrice=finalPrice+"."+tokens[1];
        Float a=Float.parseFloat(finalPrice);
        return a;
    }

    public void logOut(){

        Actions action = new Actions(driver);
        action.moveToElement(myAccount).perform();
        //wait.until(ExpectedConditions.visibilityOf(logoutButton));
        logoutButton.click();

    }

    @Override
    protected void load() {
        driver.get(dataFromPropertyFile.getEmagCartPage());
    }

    @Override
    protected void isLoaded() throws Error {
        assertEquals(dataFromPropertyFile.getEmagCartPage(), driver.getCurrentUrl());
    }
}
