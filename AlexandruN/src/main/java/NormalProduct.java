import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NormalProduct {


        /**
         * All
         */
        private WebDriver driver;

        @FindBy(css = ".product-page-pricing > p:nth-child(1)")
        private WebElement price;

        @FindBy(css=".product-page-pricing > p:nth-child(2)")
        private WebElement newPrice;
        @FindBy(xpath = ".//p[@class='product-old-price']")
         private WebElement oldPrice;


         public WebElement getPrice() {
            return price;
         }

        @FindBy(xpath="//div[@class='product-highlights-wrapper']//button[contains(@class,'yeah')]")
        private WebElement adaugaInCos;
         @FindBy(xpath = ".//i[@class='em em-cart_fill gtm_680klw']")
        private WebElement adaugaInCosRedus;

    public WebElement getAdaugaInCosRedus() {
        return adaugaInCosRedus;
    }

    @FindBy(css="i.gtm_rp112818")
    private WebElement close;
    @FindBy(id = "my_cart")
    private WebElement myCart;

    public NormalProduct(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public String getProductPrice() {
        String bigPrice=price.getText().substring(0,5);
        String smallPrice=price.findElement(By.xpath(".//sup")).getText();

        String priceS=""+bigPrice+","+smallPrice;
        return  priceS;
    }
    public String getProductNewPrice() {
        String bigPrice=newPrice.getText().substring(0,5);
        String smallPrice=newPrice.findElement(By.xpath(".//sup")).getText();

        String priceS=""+bigPrice+","+smallPrice;
        return  priceS;
    }
    public WebElement getAdaugaInCos()
    {
            return adaugaInCos;
    }
    public WebElement getMyCart() {

        return myCart;
    }

    public WebElement getClose() {

        return close;
    }
    public  String getOldPrice(){
        String bigPrice=oldPrice.getText().substring(0,5);
        String smallPrice=oldPrice.findElement(By.xpath(".//sup")).getText();

        String priceS=""+bigPrice+","+smallPrice;

        return priceS;
    }



}


