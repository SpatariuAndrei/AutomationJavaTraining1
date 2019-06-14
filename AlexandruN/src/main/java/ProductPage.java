import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public WebElement getProdusNeredus() {
        return produsNeredus;
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

}
