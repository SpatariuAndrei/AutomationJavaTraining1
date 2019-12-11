package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private String linkXpathFormat = ".//a[contains(text(), '%s')]";
    private By link_Example1 = By.xpath(String.format(linkXpathFormat, "Example 1"));
    private By link_Example2 = By.xpath(String.format(linkXpathFormat, "Example 2"));

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    public DynamicLoadingExample1Page clickExample1Page() {
        driver.findElement(link_Example1).click();
        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2Page() {
        driver.findElement(link_Example2).click();
        return new DynamicLoadingExample2Page(driver);
    }
}
