package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebTablePage {

    private WebDriver driver;
    private By pageHeader = By.tagName("h1");


    public WebTablePage(WebDriver driver){
        this.driver = driver;
    }

    public String getHeaderText(){
        return driver.findElement(pageHeader).getText();

    }



    public String getCurrentURL(){
        String URL = driver.getCurrentUrl();
        return URL;
    }


}
