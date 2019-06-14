package PageClass;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchPage {
    static final Logger LOG = LoggerFactory.getLogger(SearchPage.class);

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//div[@class='modal-content']//div[@class='modal-header']")
    private WebElement close;

    @FindBy(xpath = "//*[@id='card_grid']/div")
    private List<WebElement> searchResults;

    public SearchPage(WebDriver wd, WebDriverWait wdw){
        driver = wd;
        wait = wdw;
        PageFactory.initElements(driver, this);
    }

    public void listResults(){
        for(WebElement we : searchResults){
            System.out.println(we.findElement(By.xpath(".//a[@data-zone=\"title\"]")).getText());
        }
    }

    public void addProd(WebElement we){
        LOG.trace("Add to cart");
        we.findElement(By.xpath(".//div[3]/form")).click();

        LOG.trace("Wait to close");
        wait.until(ExpectedConditions.elementToBeClickable(close));

        LOG.trace("Send escape key to cancel message");
        driver.switchTo().activeElement().sendKeys(Keys.ESCAPE);
    }

    public Product addToCart(String s){
        LOG.trace("Product initialized");
        Product pr = new Product();

        for(WebElement we : searchResults){
            if(we.findElement(By.xpath(".//a[@data-zone=\"title\"]")).getText().toLowerCase().contains(s.toLowerCase())){
                LOG.trace("Found: " + we.findElement(By.xpath(".//a[@data-zone=\"title\"]")).getText());
                pr.setProductName(we.findElement(By.xpath(".//a[@data-zone=\"title\"]")).getText());

                LOG.trace("NewPrice set");
                pr.setProductNewPrice(parsePrice(we.findElement(By.xpath(".//p[@class='product-new-price']")).getText()));

                if(!we.findElement(By.xpath(".//p[@class='product-old-price']")).getText().equals("")) {
                    LOG.trace("OldPrice set");
                    pr.setProductOldPrice(parsePrice(we.findElement(By.xpath(".//p[@class='product-old-price']")).getText()));

                    LOG.trace("Offer -> true");
                    pr.setSpecialOffer(true);
                }

                addProd(we);

                LOG.trace("Return product");
                return pr;
            }
        }
        return null;
    }

    public Product addToCartOffer(){
        LOG.trace("Product initialized");
        Product pr = new Product();

        for(WebElement we : searchResults){
            if(!we.findElement(By.xpath(".//p[@class='product-old-price']")).getText().equals("")){
                LOG.trace("Product name set");
                pr.setProductName(we.findElement(By.xpath(".//a[@data-zone=\"title\"]")).getText());

                LOG.trace("NewPrice set");
                pr.setProductNewPrice(parsePrice(we.findElement(By.xpath(".//p[@class='product-new-price']")).getText()));

                LOG.trace("OldPrice set");
                pr.setProductOldPrice(parsePrice(we.findElement(By.xpath(".//p[@class='product-old-price']")).getText()));

                LOG.trace("Offer -> true");
                pr.setSpecialOffer(true);

                addProd(we);

                LOG.trace("Return product");
                return pr;
            }
        }
        return null;
    }

    public Product addToCartNoOffer(){
        LOG.trace("Product initialized");
        Product pr = new Product();

        for(WebElement we : searchResults){
            if(we.findElement(By.xpath(".//p[@class='product-old-price']")).getText().equals("")){
                LOG.trace("Product name set");
                pr.setProductName(we.findElement(By.xpath(".//a[@data-zone=\"title\"]")).getText());

                LOG.trace("NewPrice set");
                pr.setProductNewPrice(parsePrice(we.findElement(By.xpath(".//p[@class='product-new-price']")).getText()));

                LOG.trace("Offer -> false");
                pr.setSpecialOffer(false);

                addProd(we);

                LOG.trace("Return product");
                return pr;
            }
        }
        return null;
    }

    public String parsePrice(String s){
        String []parser;
        parser = s.split("\\s");
        String part = parser[0].substring(parser[0].length()-2);
        String whole = parser[0].substring(0, parser[0].length()-2);
        whole = whole.replace(".", "");
        return whole + "." + part;
    }
}