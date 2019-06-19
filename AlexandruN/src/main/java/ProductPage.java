import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    /**
     *All elements are identified by @FindBy annotation
     */
    private WebDriver driver;

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

    public WebElement getNewPrice() {
        return newPrice;
    }

    @FindBy(id = "my_cart")
    private WebElement myCart;

    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getNewResealedPrice() {
        return newResealedPrice;
    }

    public WebElement getOldResealedPrice() {
        return oldResealedPrice;
    }

    public WebElement getBuyResealedButton() {
        return buyResealedButton;
    }

    public WebElement getClose() {
        return close;
    }

    public WebElement getMyCart() {
        return myCart;
    }

    public WebElement getAdaugaInCos() {
        return adaugaInCos;
    }




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


    public WebElement getTitle() {
        return title;
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
}
