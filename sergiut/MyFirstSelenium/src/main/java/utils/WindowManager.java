package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.Set;

public class WindowManager {
    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void goTo(String url) {
        navigate.to(url);
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public String getTabTitle() {
        return driver.getTitle();
    }

    public void switchToTab(String tabTitle) {
        Set<String> windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());

        System.out.println("Window handels:");
        windows.forEach(System.out::println);

        for (String window : windows) {
            System.out.println("Switch to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }
    }

    /**
     * First tab starts from left to right
     * @param i starts from 0
     */
    public void switchToTabNo(int i) {
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(i)); //move to tab i
//        driver.close(); //close current tab
    }

    public void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }
}
