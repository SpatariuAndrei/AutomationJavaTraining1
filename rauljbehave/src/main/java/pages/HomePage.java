package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.Select;
import utilities.DataFromPropertyFile;

public class HomePage extends LoadableComponent {

    private WebDriver driver;
    private DataFromPropertyFile propertyFile;
    @FindBy(id = "emg-input-autosuggest")
    private WebElement searchBar;
    @FindBy(id = "emg-category-menu-icon")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@id='my_account']")
    private WebElement myAccountButton;
    @FindBy(xpath = "btn btn-primary btn-emag btn-sm")
    private WebElement enterAccount;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        propertyFile = new DataFromPropertyFile();

    }

    public void searchProduct(String product) {
        searchBar.sendKeys(product);
        searchButton.click();
    }

    public void navigateToLoginPage(){
        Actions actions = new Actions(driver);
        actions.moveToElement(myAccountButton).perform();
        //TODO: not accessible
        driver.switchTo().alert();
        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div[5]/div/div[2]")));

        dropdown.selectByVisibleText("Intra in cont");
//        enterAccount.click();


    }

    @Override
    protected void load() {
        driver.get(propertyFile.getEmagPage());
    }

    @Override
    protected void isLoaded() throws Error {
      // assertTrue(searchBar.isDisplayed());
    }
}
