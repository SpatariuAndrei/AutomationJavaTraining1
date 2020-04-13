package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AlertsPage{

    private WebDriver driver;

    List<WebElement> tabs;

    List<WebElement> tabContent;

    public AlertsPage(WebDriver driver){
        this.driver = driver;
        tabs = driver.findElements(By.className("analystic"));
        tabContent = driver.findElements(By.cssSelector("button"));
    }

    public void clickTab(String tabToClick){
        for(WebElement e : tabs)
            if(e.getText().equals(tabToClick)){
                e.click();
                break;
            }
    }

    public void clickButton(String buttonToClick){
        for(WebElement e : tabContent)
            if(e.getText().equals(buttonToClick)){
                e.click();
                break;
            }
    }

    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

    public void typeToPromptBox(String nameToType){
        driver.switchTo().alert().sendKeys(nameToType);
    }

}
