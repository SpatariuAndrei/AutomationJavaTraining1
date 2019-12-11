package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DynamicLoadingPage {

    private WebDriver driver;
    private String linkXpathFormat = ".//a[contains(text(), '%s')]";
    private By linkExample1 = By.xpath(String.format(linkXpathFormat, "Example 1"));
    private By linkExample2 = By.xpath(String.format(linkXpathFormat, "Example 2"));

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public DynamicLoadingExample1Page clickExample1() {
        driver.findElement(linkExample1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2() {
        driver.findElement(linkExample2).click();
        return new DynamicLoadingExample2Page(driver);
    }

    public DynamicLoadingExample2Page rightClickExample2() {
        driver.findElement(linkExample2).sendKeys(Keys.CONTROL, Keys.RETURN);
        return new DynamicLoadingExample2Page(driver);
    }
}
