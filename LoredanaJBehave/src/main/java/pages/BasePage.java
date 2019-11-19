package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    //*********Page Variables*********
    private WebDriver driver;

    //*********Constructor*********
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //*********Page Methods*********
    public void click(WebElement webElement) {
        webElement.click();
    }

    public void writeText(WebElement webElement, String text) {
        webElement.sendKeys(text);
    }

    public String readText(WebElement webElement) {
        return webElement.getText();
    }
}
