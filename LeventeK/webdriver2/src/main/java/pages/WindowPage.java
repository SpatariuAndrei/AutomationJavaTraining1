package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowPage {

    private WebDriver driver;
    private By seperateWindows = By.cssSelector("body>div.container.center>div>div>div>div.tabpane.pullleft>ul>li:nth-child(2)>a");
    private By multipleWindows = By.cssSelector("body > div.container.center > div > div > div > div.tabpane.pullleft > ul > li:nth-child(3) > a");
    private By newTab = By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a");
    private By triggerOpenNewTabButton = By.xpath("//*[@id=\"Tabbed\"]/a/button");
    private By triggerOpenNewWindowButton = By.xpath("//*[@id=\"Seperate\"]/button");
    private By triggerOpenMultipleTabsButton = By.xpath("//*[@id=\"Multiple\"]/button");

    public WindowPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOpenNewTabButton(){
        driver.findElement(triggerOpenNewTabButton).click();
    }

    public void clickOpenNewWindowButton(){
        driver.findElement(triggerOpenNewWindowButton).click();
    }

    public void clickOpenMultipletabsButton(){
        driver.findElement(triggerOpenMultipleTabsButton).click();
    }


    public void clickOpenSeperateWindows(){
        driver.findElement(seperateWindows).click();
    }

    public void clickOpenSeperateMultipleWindows(){
        driver.findElement(multipleWindows).click();
    }

    public void clickOpenNewTab(){
        driver.findElement(newTab).click();
    }

}
