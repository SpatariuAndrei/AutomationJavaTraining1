package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {
    private WebDriver driver;
    @FindBy(xpath = ".//a[contains(text(),'Example 1')]")
    private WebElement link_Example1;
    @FindBy(xpath = ".//a[contains(text(),'Example 2')]")
    private WebElement link_Example2;

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public DynamicLoadingExample1Page clickExample1Page() {
        link_Example1.click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2Page() {
        link_Example2.click();
        return new DynamicLoadingExample2Page(driver);
    }

    public DynamicLoadingExample2Page openExample2InNewTab() {
        String selectLinkOpeningNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        link_Example2.sendKeys(selectLinkOpeningNewTab);
        return new DynamicLoadingExample2Page(driver);
    }
}
