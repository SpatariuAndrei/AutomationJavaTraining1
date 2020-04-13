package alerts;

import base.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import pages.NavigationBar;
import pages.RegistrationPage;

import java.util.List;

public class AlertTests extends BaseTest {

    @Test
    public void testAlerts(){
        WebDriverWait explicitWait=new WebDriverWait(driver, 10);
        String email = "123whal@email.com";
        RegistrationPage registrationPage = homePage.clickSignUp(email);
        String ExpectedRegisterTitle = "Register";
        String ActualRegisterTitle = driver.getTitle();
        Assert.assertEquals(ExpectedRegisterTitle, ActualRegisterTitle);
        NavigationBar navigationBar = new NavigationBar(driver);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
        navigationBar.hoverNavBar_SwitchTo();
        AlertsPage alertsPage = navigationBar.hoverAndClickAlertsPage(navigationBar.getNavBar_SwitchTo_Alerts(),
                navigationBar.getNavBar_SwitchTo_Alerts());
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")));
        Assert.assertEquals(driver.getTitle(), "Alerts");
        List<WebElement> alertMenu = driver.findElements(By.className("analystic"));
        Assert.assertEquals(alertMenu.size(), 3);
        System.out.println("Number of elements:" +alertMenu.size());
        for (int i=0; i<alertMenu.size();i++){
            System.out.println("alert menu items:" + alertMenu.get(i).getText());
        }
        alertMenu.get(0).click();
        driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"I am an alert box!");
        alert.accept();
        alertMenu.get(1).click();
        driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Press a Button !");
        alert.accept();
//        String alertEffect = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/p/text()[1]")).getText();
//        Assert.assertEquals(alertEffect, "You pressed Ok");
        driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(),"Press a Button !");
        alert.dismiss();
//        doesn't want to work
//        String alertEffect2 = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/div[2]/p/text()[1]")).getText();
//        Assert.assertEquals(alertEffect2, "You Pressed Cancel");
        alertMenu.get(2).click();
        driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
        alert = driver.switchTo().alert();
        Assert.assertEquals(alert.getText(), "Please enter your name");
        String input = "whatever String";
        alert.sendKeys(input);
        alert.accept();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"demo1\"]")).getText(), "Hello " + input + " How are you today");




    }




}
