package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WebElementHelper;

import java.security.Key;

public class DynamicLoadingPage {

    private WebDriver driver;
    private WebElementHelper helper;
    @FindBy(xpath = "//a[contains(text(),'Example 1')]")
    private WebElement link1XpathFormat;
    @FindBy(xpath = "//a[contains(text(),'Example 2')]")
    private WebElement link2XpathFormat;

    DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DynamicLoadingExample1Page clickDynamicExemple1() {
        link1XpathFormat.click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickDynamicExemple2() {
        link2XpathFormat.click();
        return new DynamicLoadingExample2Page(driver);
    }

    public DynamicLoadingExample1Page rightClickOnExample1Link() {
        link1XpathFormat.sendKeys(Keys.CONTROL, Keys.RETURN);
        return new DynamicLoadingExample1Page(driver);
    }
}
