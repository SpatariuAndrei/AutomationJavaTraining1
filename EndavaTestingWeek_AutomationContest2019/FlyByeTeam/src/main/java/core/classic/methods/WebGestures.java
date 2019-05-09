package core.classic.methods;

import api.drivers.Drivers;
import core.watchers.MyLogger;
import core.watchers.Timer;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WebGestures {
    private Waiters waithelper = new Waiters();

    /**
     * Click on an element of type WebElement
     *
     * @param element - desired web element to be clicked
     */
    public void clickOnWebElement(WebElement element) {
        try {
            Waiters.waitForElementVisibilityWebElement(element);
            element.click();
        } catch (WebDriverException e) {
            MyLogger.log.info(element + " element was not visible and wait command ran out of time");
        }
    }

    /**
     * Method to check/uncheck and WebElement
     *
     * @param element
     * @param shouldBeChecked
     */
    public void checkUncheckElement(WebElement element, boolean shouldBeChecked) {
        if (shouldBeChecked) {
            if (element.getAttribute("aria-checked").contentEquals("false")) {
                element.click();
            }
        } else {
            if (element.getAttribute("aria-checked").contentEquals("true")) {
                element.click();
            }
        }
    }

    /**
     * Method to clear a WebElement
     *
     * @param element
     */
    public void clear(WebElement element) {
        try {
            element.clear();
        } catch (NoSuchElementException e) {
            System.out.println("Element not found to clear");
        }
    }

    /**
     * Method to send texy to a WebElement using clear
     *
     * @param element
     * @param inputText
     */
    public void sendText(WebElement element, String inputText) {
        try {
            Waiters.waitForElementVisibilityWebElement(element);
            element.clear();
            element.sendKeys(inputText);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("element was not found to clear or to send keys to it");
        }
    }

    /**
     * Method to send texy to a WebElement without using clear
     *
     * @param element
     * @param inputText
     */
    public void sendTextWithoutClear(WebElement element, String inputText) {
        try {
            Waiters.waitForElementVisibilityWebElement(element);
            element.sendKeys(inputText);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("element was not found to clear or to send keys to it");
        }
    }

    /**
     * Method to verify if and element is checked or not
     *
     * @param element
     * @param shouldBeChecked
     */
    public void verifyIfElementIsChecked(WebElement element, boolean shouldBeChecked) {
        if (shouldBeChecked) {
            assertTrue("Element is not checked and it should be!",
                    element.getAttribute("aria-checked").contentEquals("true"));
        } else {
            Assert.assertFalse("Element checked and it should not be!",
                    element.getAttribute("aria-checked").contentEquals("true"));
        }

    }

    /**
     * Method to verify and element exits or not
     *
     * @param element
     * @return
     */
    private boolean exists(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isChecked(WebElement element) {
        return element.getAttribute("checked").equals("true");
    }

    public boolean isCheckable(WebElement element) {

        return element.getAttribute("checkable").equals("true");
    }

    public boolean isClickable(WebElement element) {
        return element.getAttribute("clickable").equals("true");
    }

    public boolean isEnabled(WebElement element) {
        return element.getAttribute("enabled").equals("true");
    }

    public boolean isFocusable(WebElement element) {
        return element.getAttribute("focusable").equals("true");
    }

    public boolean isFocused(WebElement element) {
        return element.getAttribute("focused").equals("true");
    }

    public boolean isScrollable(WebElement element) {
        return element.getAttribute("scrollable").equals("true");
    }

    public boolean isSelected(WebElement element) {
        return element.getAttribute("selected").equals("true");
    }

    public Point getLocation(WebElement element) {
        return element.getLocation();
    }

    public String getText(WebElement element) {
        return element.getAttribute("name");
    }

    /**
     * Method for waiting an WebElement to be visible for a desired number of seconds
     *
     * @param seconds
     * @param element
     */
    public void waitToAppear(int seconds, WebElement element) {
        Timer timer = new Timer();
        timer.start();
        while (!timer.expired(seconds)) if (exists(element)) break;
        if (timer.expired(seconds) && !exists(element))
            throw new AssertionError("Element " + element + " failed to appear within " + seconds + " seconds");
    }

    /**
     * Method to wait an WebElement to disappear for a desired number of seconds
     *
     * @param seconds
     * @param element
     */
    public void waitToDisappear(int seconds, WebElement element) {
        Timer timer = new Timer();
        timer.start();
        while (!timer.expired(seconds)) if (!exists(element)) break;
        if (timer.expired(seconds) && exists(element))
            throw new AssertionError("Element " + element + " failed to disappear within " + seconds + " seconds");
    }

    /**
     * Method to verify that a certain WebElement contains desired text
     *
     * @param element
     * @param expectedValue
     * @param attribute
     * @param errorMessage
     */

    private void AssertContains(WebElement element, String expectedValue, Attribute attribute, String errorMessage) {
        assertTrue(errorMessage, element.getAttribute(attribute.toString())
                .contains(expectedValue));
    }

    /**
     * Method to verify that a certain WebElement equals desired text
     *
     * @param element
     * @param expectedValue
     * @param attribute
     * @param errorMessage
     */

    private void AssertEquals(WebElement element, String expectedValue, Attribute attribute, String errorMessage) {
        assertEquals(expectedValue, element.getAttribute(attribute.toString()));
    }

    /**
     * Method to verify if a certain WebElement does not equal a certain text
     *
     * @param element
     * @param expectedValue
     * @param attribute
     * @param errorMessage
     */
    public void AssertNotEquals(WebElement element, String expectedValue, Attribute attribute, String errorMessage) {
        junit.framework.Assert.assertNotSame(expectedValue,
                element.getAttribute(attribute.toString()));
    }

    /**
     * Method used for scrolling using coordinates
     */
    public void scrollPage() {
        JavascriptExecutor jse = (JavascriptExecutor) Drivers.getDriver();
        jse.executeScript("window.scrollBy(0,250)", "");
    }

    public enum Attribute {
        LABEL, NAME, VALUE, XPATH, TEXT, TAGNAME, VISIBLE, COLOR, CHECKED;

        /**
         * Returns the name of the enum constant, in lowercase
         */
        @Override
        public String toString() {
            String s = super.toString();
            return s.toLowerCase();
        }
    }

    /**
     * Method for handling pop-ups over the main window
     */
    public void handleWindows() {
        String winHandleBefore = Drivers.getDriver().getWindowHandle();
        for (String winHandle : Drivers.getDriver().getWindowHandles()) {
            Drivers.getDriver().switchTo().window(winHandle);
        }
        Drivers.getDriver().switchTo().window(Drivers.getDriver().getWindowHandle());

    }

    /**
     * Method for selecting an option from a dropdown list
     *
     * @param element
     * @param value
     */
    public void selectValuefromDropDown(WebElement element, String value) {
        Select droplist = new Select(element);
        droplist.selectByValue(value);
    }

    /**
     * Method for right click
     *
     * @param element
     */
    public void rightClick(WebElement element) {
        Actions actions = new Actions(Drivers.getDriver());
        Action action = actions.contextClick(element).build();
        action.perform();
    }

    /**
     * Method for double click
     *
     * @param element
     */
    public void doubleClick(WebElement element) {
        Actions action = new Actions(Drivers.getDriver());
        action.doubleClick(element);
        action.perform();
    }

    /**
     * Method for drag and drop from and element to another elementx
     *
     * @param element
     * @param target
     */
    public void dragAndDrop(WebElement element, WebElement target) {
        (new Actions(Drivers.getDriver())).dragAndDrop(element, target).perform();
    }

    /**
     * Method for moving the mouse over and WebElement and click on it
     *
     * @param mouseover
     */
    public void moveMouseOverAndClick(WebElement mouseover) {
        Actions actions = new Actions(Drivers.getDriver());
        actions.moveToElement(mouseover);
        actions.click().perform();
    }

    public void navigateToUrl(String url) {
        Drivers.getDriver().navigate().to(url);
    }

    public void pageBack() {
        Drivers.getDriver().navigate().back();
    }

    public void pageForward() {
        Drivers.getDriver().navigate().forward();
    }

    public void pageRefresh() {
        Drivers.getDriver().navigate().refresh();
    }

    public void fullScreen() {
        Drivers.getDriver().manage().window().fullscreen();
    }
}
