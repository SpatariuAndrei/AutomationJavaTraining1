package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicLoadingPage {

    private WebDriver driver;
    private By link_Example2 = By.xpath("//*[@id=\"content\"]/div/a[2]");

    public DynamicLoadingPage(WebDriver driver){
        this.driver = driver;
    }

    public DynamicLoadingExample2Page clickOnExample2Link(){
        driver.findElement(link_Example2).click();
        return new DynamicLoadingExample2Page(driver);
    }
}