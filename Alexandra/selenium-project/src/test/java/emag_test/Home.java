package emag_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Home {

    WebDriver driver;

    private static final Logger logger = LoggerFactory.getLogger(Home.class);
    WebDriverWait wait1;

    @FindBy(xpath="//*[@id='main-container']/section[5]/div/div/div[1]/div/div[1]")
    WebElement firstPhone;

    @FindBy(xpath="//*[@class='card-item js-card-item ph-card']")
    List<WebElement> firstListOfProducts;

    @FindBy(xpath = "//*[@id='main-container']/section[5]/div/div/div[1]/div/div[1]/a/div[5]/span")
    WebElement firstPhoneDetails;

    @FindBy(xpath = "//span[@class='visible-lg-inline' and contains(text(),'Cosul')]")
    WebElement cartInfo;


    public Home(WebDriver driver) {
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

    public void firstProductClick(){
        logger.info("Click on a product");
        firstPhoneDetails.click();
    }

    public void cartClick() throws InterruptedException {
        logger.info("Click on cart info");
        wait1= new WebDriverWait(driver, 10);
        wait1.until(ExpectedConditions.visibilityOf(cartInfo));
        wait1.until(ExpectedConditions.elementToBeClickable(cartInfo));
        Thread.sleep(500);
        cartInfo.click();
    }

    private static String changePrice(String str){
        String strin = str.replaceAll("\\.", "");
        return strin;
    }

    public String getFirstProductName() {
        return firstPhone.findElement(By.xpath(".//div[@class='product-title']")).getText();
    }


    public String getPrice(String productName) {
        WebElement elem = driver.findElement(By.xpath(".//div[@class='product-title' and contains(text(),'"+productName+"')]/ancestor::*[@class='card-item js-card-item ph-card']"));
        String path = elem.findElement(By.xpath(".//p[@class='product-new-price']")).getText();
        path = path.substring(0, path.length() - 6);
        path=changePrice(path);
        return path;
    }

    public String getPriceDecimals(String productName) {
        WebElement elem = driver.findElement(By.xpath(".//div[@class='product-title' and contains(text(),'"+productName+"')]/ancestor::*[@class='card-item js-card-item ph-card']"));
        String path = elem.findElement(By.xpath(".//p[@class='product-new-price']/sup")).getText();
        return path;
    }

    public String getOldPrice(String productName) {
        WebElement elem = driver.findElement(By.xpath(".//div[@class='product-title' and contains(text(),'"+productName+"')]/ancestor::*[@class='card-item js-card-item ph-card']"));
        String path = elem.findElement(By.xpath(".//p[@class='product-old-price']/s")).getText();
        path = path.substring(0, path.length() - 6);
        path=changePrice(path);
        return path;
    }

    public String getOldPriceDecimals(String productName) {
        WebElement elem = driver.findElement(By.xpath(".//div[@class='product-title' and contains(text(),'"+productName+"')]/ancestor::*[@class='card-item js-card-item ph-card']"));
        String path = elem.findElement(By.xpath(".//p[@class='product-old-price']/s/sup")).getText();
        return path;
    }

    public String getNewPriceFinal(String productTitle){
        String priceString = getPrice(productTitle);
        priceString=priceString.concat(".");
        priceString=priceString.concat(getPriceDecimals(productTitle));
        return priceString;
    }

    public String getOldPriceFinal(String productTitle){
        String priceString = getOldPrice(productTitle);
        priceString=priceString.concat(".");
        priceString=priceString.concat(getOldPriceDecimals(productTitle));
        return priceString;
    }
}
