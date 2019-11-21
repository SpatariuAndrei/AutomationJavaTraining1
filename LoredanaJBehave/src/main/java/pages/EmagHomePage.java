package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
//    @FindBy(xpath = "//div[@class='page-skin-inner']//div[1]//div[2]//div[1]//div[1]//div[1]//a[1]//div[1]//img[1]")
//    WebElement firstProduct;
    @FindBy(xpath = "//div[6]//div[2]//div[1]//div[1]//div[2]//button[2]//i[1]")
    WebElement addToFavoriteButtons;
    @FindBy(xpath = " //div[@class='ns-wrap-top-right']")
    WebElement notificationFrame;
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
       // new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(myAccount)).click();
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//span[contains(text(),'Contul meu')]"))).click();
     //   myAccount.click();
    }

    public void moveOverProfilePicture() {
        //new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Contul meu')]"))).click();
        helper.moveOverElement(profilePic);
        //a[contains(text(),'Favorite')]
    }

    public String getStatus() {
       // return driver.findElement(By.xpath("strong[contains(text(),'Salut, " + name + "')]")).getText();
        //return driver.findElement(By.xpath("//strong[contains(text(),'Salut, Coroama Loredana')]")).getText();
        return helper.getText(name);
    }

    public String getMessage(String name) {
         return driver.findElement(By.xpath("strong[contains(text(),'Salut, " + name + "')]")).getText();
        //return driver.findElement(By.xpath("//strong[contains(text(),'Salut, Coroama Loredana')]")).getText();
       // return helper.getText(name);
    }

    public void clickOnFavoriteProducts() {
        favorite.click();
    }

    public void searchProduct(String product) throws InterruptedException {
        Thread.sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchboxTrigger']"))).sendKeys(product, Keys.ENTER);
    }

    public void addToFavorite() {
        addToFavoriteButtons.click();
    }

    public String getNotificationText() {
        //return driver.switchTo().frame(notificationFrame).getTitle();
        WebDriverWait wait = new WebDriverWait(driver, 120);
        return wait.until(ExpectedConditions.visibilityOf(notificationFrame)).getText();
    }
}
