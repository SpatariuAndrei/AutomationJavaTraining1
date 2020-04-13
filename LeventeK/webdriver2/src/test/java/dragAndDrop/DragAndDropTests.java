package dragAndDrop;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DADDynamicPage;
import pages.DADStaticPage;
import pages.NavigationBar;
import pages.RegistrationPage;

import java.util.List;

public class DragAndDropTests extends BaseTest {

    @Test
    public void dragAndDropStaticTest(){

        WebDriverWait explicitWait=new WebDriverWait(driver, 10);
        String email = "123whal@email.com";
        RegistrationPage registrationPage = homePage.clickSignUp(email);
        String ExpectedRegisterTitle = "Register";
        String ActualRegisterTitle = driver.getTitle();
        Assert.assertEquals(ExpectedRegisterTitle, ActualRegisterTitle);
        NavigationBar navigationBar = new NavigationBar(driver);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
        navigationBar.hover(navigationBar.getNavBar_Interactions());
        navigationBar.hover(navigationBar.getNavBar_Interactions_DragAndDrop());
        DADStaticPage dadStaticPage = navigationBar.hoverAndClickDADStatic(navigationBar.getNavBar_Interactions_DragAndDrop_Static(),
                navigationBar.getNavBar_Interactions_DragAndDrop_Static());
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"angular\"]"));
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"mongo\"]"));
        WebElement element3 = driver.findElement(By.xpath("//*[@id=\"node\"]"));

        WebElement target = driver.findElement(By.xpath("//*[@id=\"droparea\"]"));

        Actions builder= new Actions(driver);

        builder.dragAndDrop(element1, target).build().perform();
        builder.dragAndDrop(element2, target).build().perform();
        builder.dragAndDrop(element3, target).build().perform();




    }

    @Test
    public void dragAndDropDynamicTest() throws InterruptedException {

        WebDriverWait explicitWait=new WebDriverWait(driver, 10);
        String email = "123whal@email.com";
        RegistrationPage registrationPage = homePage.clickSignUp(email);
        String ExpectedRegisterTitle = "Register";
        String ActualRegisterTitle = driver.getTitle();
        Assert.assertEquals(ExpectedRegisterTitle, ActualRegisterTitle);
        NavigationBar navigationBar = new NavigationBar(driver);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
        navigationBar.hover(navigationBar.getNavBar_Interactions());
        navigationBar.hover(navigationBar.getNavBar_Interactions_DragAndDrop());
        DADDynamicPage dadDynamicPage = navigationBar.hoverAndClickDADDynamic(navigationBar.getNavBar_Interactions_DragAndDrop_Dynamic(),
                navigationBar.getNavBar_Interactions_DragAndDrop_Dynamic());

        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"angular\"]")));

        List<WebElement> elementsToDrag = driver.findElements(By.className("col-xs-10 col-xs-offset-2"));
        WebElement element1 = driver.findElement(By.cssSelector("#angular"));
        WebElement element2 = driver.findElement(By.xpath("//*[@id=\"mongo\"]"));
        WebElement element3 = driver.findElement(By.xpath("//*[@id=\"node\"]"));

        WebElement target = driver.findElement(By.id("droparea"));

        Actions builder= new Actions(driver);

//        for (WebElement x: elementsToDrag){
//            Thread.sleep(5000);
//            builder.dragAndDrop(x, target).build().perform();
//            System.out.println("Element dragged and dropped: "+ x.getText());
//        }

//        builder.clickAndHold(element1).release(target).build().perform();

//        builder.clickAndHold(element1).moveToElement(target).click(target).release().build().perform();

//        builder.clickAndHold(element1).build().perform();
//        Thread.sleep(5000);
//        builder.click(target).build().perform();
//        builder.release(target).build().perform();

        builder.dragAndDrop(element1, target).build().perform();
//        builder.dragAndDrop(element2, target).build().perform();
//        builder.dragAndDrop(element3, target).build().perform();

    }

}
