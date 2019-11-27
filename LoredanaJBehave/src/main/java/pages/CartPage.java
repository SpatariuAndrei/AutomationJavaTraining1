package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataFromPropertyFile;
import utils.Helper;

public class CartPage {

    //*********Page Variables*********
    private WebDriver driver;
    private WebDriverWait wait;
    private Helper helper;
    private DataFromPropertyFile dataFromPropertyFile = new DataFromPropertyFile();

    //*********Constructor*********
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
        helper = new Helper(driver);
        dataFromPropertyFile = new DataFromPropertyFile();
    }

    //*********Web Elements*********
    @FindBy(xpath = "//a[@class='emg-right remove-product btn-remove-product gtm_rp080219']")
    WebElement deleteProductButton;
    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    WebElement status;

    //*********Methods*********
    public void deleteProductFromCart() {
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.elementToBeClickable(deleteProductButton)).click();
    }

    public boolean isMessageDisplayed() {
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
    return  wait2.until(ExpectedConditions.visibilityOf(status)).isDisplayed();
    }
}
