package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DataFromPropertyFile;
import utils.Helper;

import static org.testng.AssertJUnit.assertTrue;

public class LoginPage extends LoadableComponent<LoginPage> {

    //*********Page Variables*********
    private WebDriver driver;
    private WebDriverWait wait;
    private Helper helper;
    private DataFromPropertyFile dataFromPropertyFile = new DataFromPropertyFile();

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, 10);
        helper = new Helper(driver);
        dataFromPropertyFile = new DataFromPropertyFile();
    }

    //*********Web Elements*********
    @FindBy(xpath = "//button[@class='gui-btn auth-btn-primary auth-submit']")
    WebElement continueButton;
    @FindBy(xpath = "//input[@id='email']")
    WebElement email;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    //*********Override LoadableComponent Methods*********
    @Override
    protected void load() {
        this.driver.get(dataFromPropertyFile.getLoginURL());
    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue("LoginPage is not loaded!", driver.getCurrentUrl().contains(dataFromPropertyFile.getLoginURL()));
    }

    //*********Methods*********
    public void enterEmail(String username) {
        email.sendKeys(username);
    }

    public void clickOnContinue() {
        continueButton.click();
    }

    public void clickOnContinue2() {

        //continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='gui-btn auth-btn-primary auth-submit']"))).click();
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.history.go(-2)");
        //EmagHomePage nextPage = driver.getPageFromURL(driver.getCurrentUrl());
       // PageFactory.initElements(driver, new EmagHomePage(driver));
        //driver.get(dataFromPropertyFile.getEmagHomePageURL());
       // Thread.sleep(3000);
        //return new EmagHomePage(driver);
    }

    public void enterPassword(String pass) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='password']"))).sendKeys(pass);
    }
}
