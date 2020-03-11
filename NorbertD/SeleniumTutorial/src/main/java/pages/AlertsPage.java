package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlertsPage {

    private WebDriver driver;
    private By triggerAlertButton = By.xpath("//*[@id=\"content\"]/div/ul/li[1]/button");
    private By triggerConfirmButton = By.xpath("//*[@id=\"content\"]/div/ul/li[2]/button");
    private By triggerPromptButton = By.xpath("//*[@id=\"content\"]/div/ul/li[3]/button");
    private By results = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void triggerAlert(){
        driver.findElement(triggerAlertButton).click();
    }

    public void triggerConfirm(){
        driver.findElement(triggerConfirmButton).click();
    }

    public void triggerPromptButton(){
        driver.findElement(triggerPromptButton).click();
    }

    public String getResultText(){
        return driver.findElement(results).getText();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_clickToDismiss(){
        driver.switchTo().alert().dismiss();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    public void alert_setInput(String text){
        driver.switchTo().alert().sendKeys(text);
    }
}
