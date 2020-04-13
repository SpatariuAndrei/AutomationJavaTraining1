package windows;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NavigationBar;
import pages.RegistrationPage;
import pages.WindowPage;

import java.util.ArrayList;

public class WindowTests extends BaseTest {

    @Test
    public void testNewTabWindow(){
        WebDriverWait explicitWait=new WebDriverWait(driver, 10);
        String email = "123whal@email.com";
        RegistrationPage registrationPage = homePage.clickSignUp(email);
        String ExpectedRegisterTitle = "Register";
        String ActualRegisterTitle = driver.getTitle();
        Assert.assertEquals(ExpectedRegisterTitle, ActualRegisterTitle);
        NavigationBar navigationBar = new NavigationBar(driver);
        explicitWait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Home")));
        navigationBar.hover(navigationBar.getNavBar_SwitchTo());
        navigationBar.hover(navigationBar.getNavBar_SwitchTo_Windows());
        WindowPage windowPage = navigationBar.hoverAndClickWidowPage(navigationBar.getNavBar_SwitchTo_Windows(),
                navigationBar.getNavBar_SwitchTo_Windows());
        Assert.assertEquals(driver.getTitle(), "Frames & windows");
        Assert.assertEquals(driver.findElement(By.id("Tabbed")).getText(),
                "If you set the target attribute to \"_blank\" , the link will open in a new browser window or a new tab\n" +
                "click");
        windowPage.clickOpenSeperateWindows();
        Assert.assertEquals(driver.findElement(By.cssSelector("#Seperate>p")).getText(),
                "click the button to open a new window with some specifications");
        windowPage.clickOpenSeperateMultipleWindows();
        Assert.assertEquals(driver.findElement(By.cssSelector("#Multiple > p")).getText(),
                "Click the button to open multiple windows");
        windowPage.clickOpenNewTab();
        //Get Current Page
        String currentPageHandle = driver.getWindowHandle();
        windowPage.clickOpenNewTabButton();
        // Get all Open Tabs
        ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

        String pageTitle = "Sakinalium | Home";

        driver.switchTo().window(tabHandles.get(1));
        Assert.assertEquals(driver.getTitle(), pageTitle);
        driver.close();
        driver.switchTo().window(currentPageHandle);
        windowPage.clickOpenSeperateWindows();
        windowPage.clickOpenNewWindowButton();
        // Get all Open Tabs
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        Assert.assertEquals(driver.getTitle(), pageTitle);
        driver.close();
        driver.switchTo().window(currentPageHandle);
        windowPage.clickOpenSeperateMultipleWindows();
        windowPage.clickOpenMultipletabsButton();
        ArrayList<String> windowHandles2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles2.get(1));
        Assert.assertEquals(driver.getTitle(),"Sakinalium | Home");
        driver.close();
        driver.switchTo().window(windowHandles2.get(2));
        Assert.assertEquals(driver.getTitle(),"Index");
        driver.close();
        driver.switchTo().window(currentPageHandle);








    }



}
