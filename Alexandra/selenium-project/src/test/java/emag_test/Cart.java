package emag_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    WebDriver driver;

    @FindBy(xpath = "$x('//*[@class='line-item-title main-product-title')]/ancestor::div[@class='line-item main-product']')")
    WebElement productName1;

    @FindBy(xpath = "//*[@class='cart-widget cart-line']")
    List<WebElement> productList;

    @FindBy(xpath = "//span[@class='money-int']")
    WebElement intSum;

    @FindBy(xpath = "//sup[@class='money-decimal']")
    WebElement decimalSum;


    public Cart(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void deleteAProduct(int id){
        productList.get(id).findElement(By.xpath(".//a[@class='emg-right remove-product btn-remove-product gtm_rp080219']")).click();

    }

    public String getProductName(int id){
        return productList.get(id).findElement(By.xpath(".//a[@class='line-item-title main-product-title']")).getText();
    }

    private static String changePrice(String str){
        String strin = str.replaceAll("\\.", "");
        return strin;
    }

    public String getBill(){
        String sum=intSum.getText();
        sum=changePrice(sum);
        return sum;
    }

    public String getBillDecimal(){
        return decimalSum.getText();
    }

    public String getProductPrice(String productName){
        WebElement elem = driver.findElement(By.xpath(".//a[@class='line-item-title main-product-title' and contains(text(),'"+productName+"')]/ancestor::*[@class='cart-widget cart-line']"));
        String pret = elem.findElement(By.xpath(".//div[@class='price-main']/span[1]")).getText();
        pret=changePrice(pret);
        return pret;
    }

    public String getProductPriceDecimals(String productName){
        WebElement elem = driver.findElement(By.xpath(".//a[@class='line-item-title main-product-title' and contains(text(),'"+productName+"')]/ancestor::*[@class='cart-widget cart-line']"));
        return elem.findElement(By.xpath(".//div[@class='price-main']/sup")).getText();
    }

    public String getProductOldPrice(String productName){
        WebElement elem = driver.findElement(By.xpath(".//a[@class='line-item-title main-product-title' and contains(text(),'"+productName+"')]/ancestor::*[@class='cart-widget cart-line']"));
        String pret = elem.findElement(By.xpath(".//div[@class='price-original']/span[1]")).getText();
        pret = changePrice(pret);
        return pret;
    }

    public String getProductOldPriceDecimals(String productName){
        WebElement elem = driver.findElement(By.xpath(".//a[@class='line-item-title main-product-title' and contains(text(),'"+productName+"')]/ancestor::*[@class='cart-widget cart-line']"));
        return elem.findElement(By.xpath(".//div[@class='price-original']/sup")).getText();
    }

    public String getFinalNewPriceString(String productName){
        String priceString = getProductPrice(productName);
        priceString=priceString.concat(".");
        priceString=priceString.concat(getProductPriceDecimals(productName));
        return priceString;
    }

    public String getFinalOldPriceString(String productName){
        String priceString = getProductOldPrice(productName);
        priceString=priceString.concat(".");
        priceString=priceString.concat(getProductOldPriceDecimals(productName));
        return priceString;
    }

    public float getSumOfPrices() {
        float suma = 0;
        for (ProductInfo product : getProductList()) {
            suma = suma + Float.valueOf(product.getPrice());
        }
        return suma;
    }

    public String getCartSum(){
        String sum=getBill();
        sum=sum.concat(".");
        sum=sum.concat(getBillDecimal());
        return sum;
    }

    public ProductInfo getProduct(int id){
        ProductInfo prod = new ProductInfo();
        prod.setTitle(getProductName(id));
        prod.setPrice(getFinalNewPriceString(getProductName(id)));
        prod.setOldPrice(getFinalOldPriceString(getProductName(id)));

        return prod;
    }

    public List<ProductInfo> getProductList(){
        List<ProductInfo> products = new ArrayList<>();
        for(int i=0;i<productList.size();i++){
            products.add(getProduct(i));
        }
        return products;
    }

}
