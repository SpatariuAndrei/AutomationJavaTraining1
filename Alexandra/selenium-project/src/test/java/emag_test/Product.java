package emag_test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Product {

    private static final Logger logger = LoggerFactory.getLogger(Product.class);

    WebDriver driver;
    WebDriverWait wait1;

    @FindBy(css = ".btn-emag:nth-child(1)")
    WebElement addToCart;

    @FindBy(css = ".gtm_rp112818 > .em")
    WebElement closePurchaseWindow;

    @FindBy (xpath = "//h1[@class='page-title']")
    WebElement productName;

    @FindBy (xpath = "//p[@class='product-new-price']")
    WebElement productPrice;

    @FindBy (xpath = "//p[@class='product-new-price']/sup")
    WebElement productPriceDecimals;

    @FindBy (xpath = "//p[@class='product-old-price']")
    WebElement productOldPrice;

    @FindBy (xpath = "//p[@class='product-old-price']/s/sup")
    WebElement productOldPriceDecimals;

    @FindBy (xpath = "/html/body/div[1]/div/div/button/i")
    WebElement closeVoucherFrame;


    public Product(WebDriver driver){

        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    private static String changePrice(String str){
        String strin = str.replaceAll("\\.", "");
        return strin;
    }

    public void addToCart(){
        logger.info("Add product to cart");
        wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.elementToBeClickable(addToCart));
        try{
        if (this.closeVoucherFrame.isDisplayed()) {
            this.closeVoucherFrame.click();
        }}
        catch(NoSuchElementException e){
            logger.debug("voucher button not visible");
        }
        addToCart.click();
    }

    public void closePurchaseWindow(){
        logger.info("Close purchase window");
        wait1 = new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.visibilityOf(closePurchaseWindow));
        closePurchaseWindow.click();
    }

    public String getNewPriceString(){
        String priceString = getPrice();
        priceString=priceString.concat(".");
        priceString=priceString.concat(getPriceDecimals());
        return priceString;
    }

    public String getOldPriceString(){
        String priceString = getOldPrice();
        priceString=priceString.concat(".");
        priceString=priceString.concat(getOldPriceDecimals());
        return priceString;
    }

    public String getProductName(){
        return productName.getText();
    }

    public String getPrice(){
        String path = productPrice.getText();
        //path = path.substring(0, path.length() - 6);
        path=changePrice(path);
        return path;
    }

    public String getPriceDecimals(){
        return productPriceDecimals.getText();
    }

    public String getOldPrice(){
        String path = productOldPrice.getText();
        path = path.substring(0, path.length() - 6);
        path=changePrice(path);
        return path;
    }

    public String getOldPriceDecimals(){
        return productOldPriceDecimals.getText();
    }

}
