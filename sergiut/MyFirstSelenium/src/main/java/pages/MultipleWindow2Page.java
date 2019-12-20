package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindow2Page {
    private WebDriver driver;
    @FindBy(linkText = "Click Here")
    private WebElement clickHereLink;

    public MultipleWindow2Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickHere() {
        clickHereLink.click();
    }
}
