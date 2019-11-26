package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import utils.*;

import static org.testng.AssertJUnit.assertTrue;

public class EmagHomePage extends LoadableComponent<EmagHomePage> {

    //*********Page Variables*********
    private SharedData sharedData;
    private Helper helper;
    private DataFromPropertyFile dataFromPropertyFile;
    private WebDriverUtilities webDriverUtilities;
    //*********Web Elements*********
    @FindBy(xpath = "//span[contains(text(),'Contul meu')]")
    private WebElement myAccount;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-emag btn-sm']")
    private WebElement enterInMyAccount;
    @FindBy(xpath = "div[@class='user-avatar user-avatar-ub']//div[@class='picture']")
    private WebElement profilePic;
    @FindBy(xpath = "//p[@class='name']")
    private WebElement name;
    @FindBy(xpath = "//input[@id='searchboxTrigger']")
    private WebElement searchBar;
    @FindBy(xpath = "//div[@class='page-skin-inner']//div[1]//div[1]//div[1]//div[1]//div[2]//button[2]//i[1]")
    private WebElement addToFavoriteButton;
    @FindBy(xpath = "//div[@class='ns-wrap-top-right']")
    private  WebElement notificationFrame;
    @FindBy(xpath = "//div[@class='page-skin-inner']//div[1]//div[1]//div[1]//div[3]//div[3]//form[1]//button[1]")
    private WebElement addToCartButton;
    @FindBy(css = "body.has-minimized-navbar:nth-child(2) div.main-container-outer:nth-child(8) div.main-container-inner:nth-child(4) div.main-container section.page-section:nth-child(1) div.page-skin-outer.skin-active div.container div.page-skin-inner div.clearfix.pad-btm-md div.page-container div.js-products-container.card-collection.list-view-updated.show-me-a-grid:nth-child(5) div.card-item.js-product-data:nth-child(1) div.card div.card-section-wrapper.js-section-wrapper div.card-section-btm div.card-body:nth-child(2) > p.product-new-price")
    private WebElement firstPrice;
    @FindBy(css = "body.has-minimized-navbar:nth-child(2) div.main-container-outer:nth-child(8) div.main-container-inner:nth-child(4) div.main-container section.page-section:nth-child(1) div.page-skin-outer.skin-active div.container div.page-skin-inner div.clearfix.pad-btm-md div.page-container div.js-products-container.card-collection.list-view-updated.show-me-a-grid:nth-child(5) div.card-item.js-product-data:nth-child(2) div.card div.card-section-wrapper.js-section-wrapper div.card-section-btm div.card-body:nth-child(2) > p.product-new-price")
    private WebElement secondPrice;
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm btn-block']")
    private  WebElement detailsButton;

    //*********Constructor*********
    public EmagHomePage(SharedData sharedData) {
        this.sharedData = sharedData;
        PageFactory.initElements(sharedData.driver, this);
        helper = new Helper(sharedData);
        dataFromPropertyFile = new DataFromPropertyFile();
        webDriverUtilities = new WebDriverUtilities();
    }

    //*********Override LoadableComponent Methods*********
    @Override
    protected void load() {
        this.sharedData.driver.get(dataFromPropertyFile.getBaseURL());
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("EmagHomePage is not loaded!", sharedData.driver.getCurrentUrl().contains(dataFromPropertyFile.getBaseURL()));
    }

    //*********Methods*********
    public LoginPage navigateToLoginPage() {
        sharedData.loginPage = clickOnMyAccount();
        return sharedData.loginPage;
    }

    public LoginPage clickOnMyAccount() {
        enterInMyAccount.click();
        return new LoginPage(sharedData);
    }

    public void clickOnProfile() throws InterruptedException {
       Thread.sleep(Constants.SLEEP);
        webDriverUtilities.waitForElementToBeVisible(myAccount, Constants.TIMEOUT);
        myAccount.click();
    }

    public void moveOverProfilePicture() {
        helper.moveOverElement(profilePic);
    }

    public String getStatus() {
        return helper.getText(name);
    }

    public void searchProduct(String product) throws InterruptedException {
        Thread.sleep(Constants.SLEEP);
        webDriverUtilities.waitForElementToBeClickable(searchBar, Constants.TIMEOUT);
        searchBar.sendKeys(product, Keys.ENTER);
    }

    public void addToFavorite() throws InterruptedException {
        webDriverUtilities.waitForElementToBeClickable(addToFavoriteButton,Constants.TIMEOUT);
        addToFavoriteButton.click();  }

    public String getNotificationText() {
        webDriverUtilities.waitForElementToBeVisible(notificationFrame, Constants.TIMEOUT);
       return  helper.getText(notificationFrame);
    }

    public void addToCart() throws InterruptedException {
        Thread.sleep(Constants.SLEEP);
        webDriverUtilities.waitForElementToBeClickable(addToCartButton, Constants.TIMEOUT);
        addToCartButton.click();
    }

    public CartPage clickOnCartDetails() {
        webDriverUtilities.waitForElementToBeClickable(detailsButton,Constants.TIMEOUT);
        detailsButton.click();
        return new CartPage(sharedData);
    }

    public String getFirstPrice() {
        webDriverUtilities.waitForElementToBeVisible(firstPrice, Constants.TIMEOUT);
        return helper.getText(firstPrice);
    }
    public String getSecondPrice() {
        webDriverUtilities.waitForElementToBeVisible(secondPrice, Constants.TIMEOUT);
        return helper.getText(secondPrice);
    }

    public void clearSearchBar() {
        searchBar.clear();
    }
}
