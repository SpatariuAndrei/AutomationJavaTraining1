package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.LoadableComponent;
import pages.utils.Product;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Thread.sleep;

public class ProductPage extends LoadableComponent<ProductPage> {

    private WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
    /**
     *All elements are identified by @FindBy annotation
     */
    @FindBy(className="product-new-price product-resealed-price")
    private WebElement newResealedPrice;

    @FindBy(className = "product-old-price")
    private WebElement oldResealedPrice;

   // @FindBy(css= "div.in:nth-child(1) > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(4) > button:nth-child(2)")
   @FindBy(css = "div.in > div:nth-child(1) > form:nth-child(1) > div:nth-child(1) > div:nth-child(4) > button:nth-child(2)")
    private WebElement buyResealedButton;

    @FindBy(xpath=".//button[@class='close gtm_rp112818']")
    private WebElement close;

    @FindBy(xpath = ".//div[@data-name='Telefon mobil Xiaomi Mi MIX 2, Dual SIM, 64GB, 6GB RAM, 4G, Black']")
    private WebElement produsNeredus;
    @FindBy(css = "button.btn-emag:nth-child(1)")
    private WebElement adaugaInCos;

    @FindBy(xpath=".//div[@id='card_grid']")
    private WebElement productsContainer;

    @FindBy(xpath=".//div[@class='product-highlight product-page-pricing']")
    private WebElement price;


    @FindBy(xpath = ".//h1")
    private WebElement title;
    @FindBy(xpath=".//p[@class='product-new-price']")
    private WebElement newPrice;

    @FindBy(id = "my_cart")
    private WebElement myCart;

    public Float getNewPrice(String s){
        String finalPrice="";
        String[] tokens=s.split(",");
        String[] tokensInt=tokens[0].split("\\.");
        for(String st:tokensInt){
            finalPrice=finalPrice+st;
        }
        finalPrice=finalPrice+"."+tokens[1];
        Float a=Float.parseFloat(finalPrice);
        return a;
    }

    public Product elementToProduct(){
        Product product=new Product();
        try{
            product.setOldPrice(price);
        }catch(Exception ex){

        }
        product.setNewPrice(price);
        product.setTitle(title.getText());
        return product;
    }
    public void addToCart(){

        js.executeScript("window.scrollTo(0,150)");
        adaugaInCos.click();
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        close.click();
    }
    public void viewCart(){
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("window.scrollTo(0,1)");//Mergem la Cart button
        myCart.click();
    }

    public void setOldPrice(WebElement e) {

        String bigPrice=e.findElement(By.xpath(".//p[@class='product-old-price']/s")).getText().substring(0,5);
        String smallPrice = e.findElement(By.xpath(".//p/s/sup")).getText();
        this.stringOldPrice = ""+bigPrice+","+smallPrice;
    }

    public String getNewPrice() {
        return stringNewPrice;
    }

    public void setNewPrice(WebElement e) {
        String bigPrice=e.findElement(By.xpath(".//p[@class='product-new-price']")).getText().substring(0,5);
        String smallPrice=e.findElement(By.xpath(".//p[@class='product-new-price']/sup")).getText();

        this.stringNewPrice =""+bigPrice+","+smallPrice;
    }

    public String getTitle() {
        return stringTitle;
    }

    public void setTitle(String title) {
        this.stringTitle = title;
    }

    private String stringOldPrice;
    private String stringNewPrice;
    private  String stringTitle;


    public void setCartOldPrice(WebElement e) {

        String bigPrice = e.findElement(By.xpath(".//span[@class='money-int']")).getText();
        String smallPrice = e.findElement(By.xpath(".//sup[@class='money-decimal']")).getText();
        this.stringOldPrice = ""+bigPrice+","+smallPrice;
    }



    public void setCartNewPrice(WebElement e) {
        String bigPrice=e.findElement(By.xpath(".//span[@class='money-int']")).getText();
        String smallPrice=e.findElement(By.xpath(".//sup[@class='money-decimal']")).getText();

        this.stringNewPrice =""+bigPrice+","+smallPrice;
    }
    public float floatNewPrice() {
        String finalPrice="";
        String[] tokens=this.stringNewPrice.split(",");
        String[] tokensInt=tokens[0].split("\\.");
        for(String s:tokensInt){
            finalPrice=finalPrice+s;
        }
        finalPrice=finalPrice+"."+tokens[1];
        float a=Float.parseFloat(finalPrice);
        return a;
    }
    public float floatOldPrice(){

        String finalPrice="";
        String[] tokens=this.stringOldPrice.split(",");
        String[] tokensInt=tokens[0].split("\\.");
        for(String s:tokensInt){
            finalPrice=finalPrice+s;
        }
        finalPrice=finalPrice+"."+tokens[1];
        float a=Float.parseFloat(finalPrice);
        return a;
    }    public String getStringOldPrice() {
        return stringOldPrice;
    }

    public void setStringOldPrice(String s){
        this.stringOldPrice =s;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
