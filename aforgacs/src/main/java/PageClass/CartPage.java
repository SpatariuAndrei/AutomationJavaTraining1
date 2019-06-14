package PageClass;

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

public class CartPage {
    static final Logger LOG = LoggerFactory.getLogger(CartPage.class);

    private WebDriver driver;
    private WebDriverWait wait;
    private Boolean empty;

    @FindBy(xpath = "//div[@class=\"line-item main-product\"]")
    private List<WebElement> product;

    public CartPage(WebDriver wd, WebDriverWait wdw){
        driver = wd;
        wait = wdw;
        PageFactory.initElements(driver, this);
    }

    public void clearCart(){
        WebElement productToCancel;
        empty = false;

        while(!empty){
            try {
                productToCancel = driver.findElement(By.xpath("//a[contains(text(), \"Sterge\") or contains(text(), \"Delete\")]"));
                wait.until(ExpectedConditions.elementToBeClickable(productToCancel));

                LOG.trace("Cancel product");
                productToCancel.click();
            }catch (Exception e){
//                LOG.debug("Cart clear exception: " + e);
                LOG.info("No more product in the cart");
                empty = true;
            }
        }
    }

    public Float getPrice(int n){
        String first;
        String second;

        first = product.get(n).findElement(By.xpath(".//span[@class=\"money-int\"]")).getText();
        first = first.replace(".", "");

        second = product.get(n).findElement(By.xpath(".//sup[@class=\"money-decimal\"]")).getText();

        return Float.parseFloat(first + "." + second);

    }
}
