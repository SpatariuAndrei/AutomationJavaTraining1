package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.TouchAction;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.awt.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StaticDragAndDropPage {

    private WebDriver driver;
    List<WebElement> draggableItems;
    WebElement elementsParent;

    public StaticDragAndDropPage(WebDriver driver){
        this.driver=driver;
        driver.manage().window().maximize();

        elementsParent = driver.findElement(By.id("dragarea"));
        draggableItems = elementsParent.findElements(By.tagName("img"));
    }


    public void dragAndDrop(String elementToDrag){

        WebElement source=null;
        WebElement destination = driver.findElement(By.id("droparea"));

        for(WebElement e : draggableItems)
        {
            if(e.getAttribute("id").equals(elementToDrag))
            {
                source= e;
                e.click();
            }
        }

        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);

        final Actions action = new Actions(driver);
        action.moveToElement(source);
        action.dragAndDrop(source,destination).build().perform();

    }

}
