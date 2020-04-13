package dynamicData;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DynamicDataPage;
import pages.NavigationBar;
import pages.RegistrationPage;

import java.util.ArrayList;
import java.util.List;

public class DynamicDataTests extends BaseTest {

    @Test
    public void testDynamicData(){
        WebDriverWait explicitWait=new WebDriverWait(driver, 10);
        String email = "123whal@email.com";
        RegistrationPage registrationPage = homePage.clickSignUp(email);
        String ExpectedRegisterTitle = "Register";
        String ActualRegisterTitle = driver.getTitle();
        Assert.assertEquals(ExpectedRegisterTitle, ActualRegisterTitle);
        NavigationBar navigationBar = new NavigationBar(driver);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
        navigationBar.hover(navigationBar.getNavBar_More());
        DynamicDataPage dynamicDataPage = navigationBar.hoverAndClickDynamicData(navigationBar.getNavBar_More_DynamicData(),
                navigationBar.getNavBar_More_DynamicData());
        List<WebElement> dynamicData =  new ArrayList<>();
        dynamicDataPage.clickButton();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loading\"]/img")));
        boolean elementisvisible =  driver.findElement(By.xpath("//*[@id=\"loading\"]/img")).isDisplayed();
        Assert.assertTrue(elementisvisible);
        System.out.println(driver.findElement(By.id("loading")).getText());
        dynamicData.add(driver.findElement(By.id("loading")));
        dynamicDataPage.clickButton();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loading\"]/img")));
        dynamicData.add(driver.findElement(By.id("loading")));
        System.out.println(dynamicData.size());






    }


}
