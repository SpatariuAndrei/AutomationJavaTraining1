package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebElementHelper {

   private WebDriver driver;

    public WebElementHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
