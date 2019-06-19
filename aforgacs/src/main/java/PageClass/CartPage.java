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

    @FindBy(xpath = "//div[@class='cart-widget cart-line']")
    private List<WebElement> product;

    public CartPage(WebDriver wd, WebDriverWait wdw){
        driver = wd;
        wait = wdw;
        PageFactory.initElements(driver, this);
    }

    public void clearCart(){
        int n = product.size();
        WebElement we;
        for(int i = 0; i < n; i++){
            try {
                LOG.trace("Cancel product");
                we = driver.findElement(By.xpath(".//a[contains(text(), \"Sterge\") or contains(text(), \"Delete\")]"));
                we.click();
                wait.until(ExpectedConditions.invisibilityOf(we));
            }catch (Exception e){
                LOG.info("No more product in the cart");
            }
        }
    }

    public Float getPrice(String s){
        String first;
        String second;

        first = getProduct(s).findElement(By.xpath(".//span[@class=\"money-int\"]")).getText();
        first = first.replace(".", "");

        second = getProduct(s).findElement(By.xpath(".//sup[@class=\"money-decimal\"]")).getText();

        return Float.parseFloat(first + "." + second);
    }

    private WebElement getProduct(String s){
        for(WebElement we : product){
            if(we.getText().contains(s)){
                return we;
            }
        }
        return null;
    }
}
