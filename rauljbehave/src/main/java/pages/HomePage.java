package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import static junit.framework.TestCase.assertTrue;

public class HomePage extends LoadableComponent {

    private WebDriver driver;
    @FindBy(id = "searchboxTrigger")
    private WebElement searchBox;


    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product) {
        searchBox.sendKeys(product);
        searchBox.click();
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        assertTrue(searchBox.isDisplayed());
    }
}
