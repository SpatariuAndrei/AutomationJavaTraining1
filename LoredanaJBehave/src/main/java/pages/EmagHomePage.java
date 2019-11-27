package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataFromPropertyFile;
import utils.Helper;

import static org.testng.AssertJUnit.assertTrue;

public class EmagHomePage extends LoadableComponent<EmagHomePage> {

    //*********Page Variables*********
    private WebDriver driver;
    private WebDriverWait wait;
    private Helper helper;
    private DataFromPropertyFile dataFromPropertyFile = new DataFromPropertyFile();

    //*********Constructor*********
    public EmagHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
        helper = new Helper(driver);
        dataFromPropertyFile = new DataFromPropertyFile();
    }

    //*********Web Elements*********
    @FindBy(xpath = "//span[contains(text(),'Contul meu')]")
    WebElement myAccount;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-emag btn-sm']")
    WebElement enterInMyAccount;
    @FindBy(xpath = "div[@class='user-avatar user-avatar-ub']//div[@class='picture']")
    WebElement profilePic;
    @FindBy(xpath = "ul[@class='user-account-menu mrg-sep-sm']//a[contains(text(),'Favorite')]")
    WebElement favorite;
    @FindBy(xpath = "//p[@class='name']")
    WebElement name;
    @FindBy(xpath = "//input[@id='emg-input-autosuggest']")
    WebElement searchBar;
    @FindBy(xpath = "//div[6]//div[2]//div[1]//div[1]//div[2]//button[2]//i[1]")
    WebElement addToFavoriteButtons;
    @FindBy(xpath = "//div[@class='ns-wrap-top-right']")
    WebElement notificationFrame;
    @FindBy(xpath = "//div[@class='clearfix pad-btm-md']//div[3]//div[1]//div[1]//div[3]//div[3]//form[1]//button[1]")
    WebElement addToCartButton;
    @FindBy(css = "body.has-minimized-navbar:nth-child(2) div.main-container-outer:nth-child(8) div.main-container-inner:nth-child(4) div.main-container section.page-section:nth-child(1) div.page-skin-outer.skin-active div.container div.page-skin-inner div.clearfix.pad-btm-md div.page-container div.js-products-container.card-collection.list-view-updated.show-me-a-grid:nth-child(5) div.card-item.js-product-data:nth-child(1) div.card div.card-section-wrapper.js-section-wrapper div.card-section-btm div.card-body:nth-child(2) > p.product-new-price")
    WebElement firstPrice;
    @FindBy(css = "body.has-minimized-navbar:nth-child(2) div.main-container-outer:nth-child(8) div.main-container-inner:nth-child(4) div.main-container section.page-section:nth-child(1) div.page-skin-outer.skin-active div.container div.page-skin-inner div.clearfix.pad-btm-md div.page-container div.js-products-container.card-collection.list-view-updated.show-me-a-grid:nth-child(5) div.card-item.js-product-data:nth-child(2) div.card div.card-section-wrapper.js-section-wrapper div.card-section-btm div.card-body:nth-child(2) > p.product-new-price")
    WebElement secondPrice;

    //*********Override LoadableComponent Methods*********
    @Override
    protected void load() {
        this.driver.get(dataFromPropertyFile.getBaseURL());
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("EmagHomePage is not loaded!", driver.getCurrentUrl().contains(dataFromPropertyFile.getBaseURL()));
    }

    //*********Methods*********
    public void moveOverMyAccount() {
       helper.moveOverElement(myAccount);
    }

    public LoginPage clickOnMyAccount() {
        enterInMyAccount.click();
        return new LoginPage(driver);
    }

    public void clickOnProfile() throws InterruptedException {
       Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//span[contains(text(),'Contul meu')]"))).click();
    }

    public void moveOverProfilePicture() {
        //new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Contul meu')]"))).click();
        helper.moveOverElement(profilePic);
    }

    public String getStatus() {
        return helper.getText(name);
    }

    public String getMessage(String name) {
         return driver.findElement(By.xpath("strong[contains(text(),'Salut, " + name + "')]")).getText();
    }

    public void clickOnFavoriteProducts() {
        favorite.click();
    }

    public void searchProduct(String product) throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchboxTrigger']"))).sendKeys(product, Keys.ENTER);
    }

    public void addToFavorite() throws InterruptedException {
        WebDriverWait wait3 = new WebDriverWait(driver, 10);
        wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='clearfix pad-btm-md']//div[3]//div[1]//div[1]//div[1]//div[2]//button[2]//i[1]"))).click();
    }

    public String getNotificationText() {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        return wait.until(ExpectedConditions.visibilityOf(notificationFrame)).getText();
    }

    public void addToCart() {
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public CartPage clickOnCartDetails() {
        WebDriverWait wait2 = new WebDriverWait(driver, 10);
        wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-primary btn-sm btn-block']"))).click();
        return new CartPage(driver);
    }

    public String getFirstPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        return wait.until(ExpectedConditions.visibilityOf(firstPrice)).getText();
    }
    public String getSecondPrice() {
        WebDriverWait wait = new WebDriverWait(driver, 120);
        return wait.until(ExpectedConditions.visibilityOf(secondPrice)).getText();
    }


}
