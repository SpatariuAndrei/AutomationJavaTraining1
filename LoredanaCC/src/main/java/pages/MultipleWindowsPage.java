package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleWindowsPage {

    private WebDriver driver;
    @FindBy(xpath = "//a[contains(text(),'Click Here')]")
    WebElement clickHereLink;

    MultipleWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickHere() {
        clickHereLink.click();
    }
}
