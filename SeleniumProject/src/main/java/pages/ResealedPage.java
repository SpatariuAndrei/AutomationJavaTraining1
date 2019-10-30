package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.LoadableComponent;

public class ResealedPage extends LoadableComponent<ResealedPage> {


    private WebDriver driver;

    public ResealedPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(className = "lozad")
    private WebElement product;

    public WebElement getProduct() {
        return product;
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {

    }
}
