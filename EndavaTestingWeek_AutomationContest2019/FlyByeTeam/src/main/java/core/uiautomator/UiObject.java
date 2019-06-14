package core.uiautomator;

import api.drivers.Drivers;
import core.classic.methods.Swipe;
import core.watchers.MyLogger;
import core.watchers.Timer;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.io.IOException;

import static core.classic.methods.Swipe.swipeDown;
import static core.classic.methods.Swipe.swipeUp;


public class UiObject {

    Swipe swipe = new Swipe();

    private final String locator;

    UiObject(String locator) {
        this.locator = locator;
        MyLogger.log.debug("Created new UiObject: " + this.locator);
    }

    private boolean isXpath() {
        return !locator.contains("UiSelector");
    }

    private boolean exists() {
        try {
            WebElement element;
            if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
            else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isChecked() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("checked").equals("true");
    }

    public boolean isCheckable() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("checkable").equals("true");
    }

    public boolean isClickable() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("clickable").equals("true");
    }

    public boolean isEnabled() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("enabled").equals("true");
    }

    public boolean isFocusable() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("focusable").equals("true");
    }

    public boolean isFocused() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("focused").equals("true");
    }

    public boolean isScrollable() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("scrollable").equals("true");
    }

    public boolean isLongClickable() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("longClickable").equals("true");
    }

    public boolean isSelected() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("selected").equals("true");
    }

    public Point getLocation() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getLocation();
    }

    public String getText() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("name");
    }

    public String getResourceId() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("resourceId");
    }

    public String getClassName() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("className");
    }

    public String getContentDesc() {
        WebElement element;
        if (isXpath()) element = Drivers.androidDriver.findElementByXPath(locator);
        else element = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
        return element.getAttribute("contentDesc");
    }

    public UiObject clearText() {
        if (isXpath()) Drivers.androidDriver.findElementByXPath(locator).clear();
        else Drivers.androidDriver.findElementByAndroidUIAutomator(locator).clear();
        return this;
    }

    public UiObject typeText(String value) {
        if (isXpath()) Drivers.androidDriver.findElementByXPath(locator).sendKeys(value);
        else Drivers.androidDriver.findElementByAndroidUIAutomator(locator).sendKeys(value);
        return this;
    }

    public UiObject tap() {
        if (isXpath()) Drivers.androidDriver.findElementByXPath(locator).click();
        else Drivers.androidDriver.findElementByAndroidUIAutomator(locator).click();
        return this;
    }

    public UiObject findElementToClickOnItDownInPage() throws IOException, ParseException {
        WebElement we = null;
        int count = 0;
        while (count < 10) {
            try {
                MyLogger.log.info("Trying to see if element is visible before swiping");
                we = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
                if (we.isDisplayed()) {
                    MyLogger.log.info("Element is visible so no need to swipe");
                    break;
                }
            } catch (WebDriverException e) {
                if (e.getMessage().contains("could not be located")) {
                    MyLogger.log.info("Performing swipe up to find element down in page");
                    swipeUp();
                } else {
                    MyLogger.log.info("Verify method because element is still not visible after swiping");
                }
            }
            count++;
        }

        return this;
    }

    public UiObject findElementToClickOnItUpInPage() {
        WebElement we = null;
        int count = 0;
        while (count < 10) {
            try {
                MyLogger.log.info("Trying to see if element is visible before swiping");
                we = Drivers.androidDriver.findElementByAndroidUIAutomator(locator);
                if (we.isDisplayed()) {
                    MyLogger.log.info("Element is visible so no need to swipe");
                    break;
                }
            } catch (WebDriverException e) {
                if (e.getMessage().contains("could not be located")) {
                    MyLogger.log.info("Performing swipe down to find element up in page");
                    swipeDown();
                } else {
                    MyLogger.log.info("Verify method because element is still not visible after swiping");
                }
            }
            count++;
        }

        return this;
    }

    public UiObject waitToAppear(int seconds) {
        Timer timer = new Timer();
        timer.start();
        while (!timer.expired(seconds)) if (exists()) break;
        if (timer.expired(seconds) && !exists())
            throw new AssertionError("Element " + locator + " failed to appear within " + seconds + " seconds");
        return this;
    }

    public UiObject waitToDisappear(int seconds) {
        Timer timer = new Timer();
        timer.start();
        while (!timer.expired(seconds)) if (!exists()) break;
        if (timer.expired(seconds) && exists())
            throw new AssertionError("Element " + locator + " failed to disappear within " + seconds + " seconds");
        return this;
    }
}
