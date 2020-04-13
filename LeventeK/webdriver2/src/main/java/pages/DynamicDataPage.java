package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DynamicDataPage {

    private WebDriver driver;
    private By pressGetDynamicDataButton = By.id("save");
    private By dynamicData = By.id("loading");

    public DynamicDataPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickButton(){
        driver.findElement(pressGetDynamicDataButton).click();
    }

    public WebElement returnWebElement(){
        clickButton();
        WebElement dynamicDataElement = driver.findElement(dynamicData);
        return dynamicDataElement;
    }

    public List<WebElement> saveWebElementToList(WebElement element){
        List<WebElement> dynamicElements = new ArrayList<>();
        dynamicElements.add(element);
        return dynamicElements;
    }


}
