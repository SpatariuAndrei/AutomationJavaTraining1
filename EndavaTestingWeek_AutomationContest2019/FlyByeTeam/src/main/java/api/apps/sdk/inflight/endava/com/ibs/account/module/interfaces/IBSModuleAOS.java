package api.apps.sdk.inflight.endava.com.ibs.account.module.interfaces;

import api.drivers.Drivers;
import core.classic.methods.Gestures;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class IBSModuleAOS implements IBSModule {

    public IBSModuleAOS() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Gestures gestures = new Gestures();

    /**
     * Elements for initiate module
     */

    @iOSXCUITFindBy(accessibility = "IBS Account")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"IBS Module\")")
    private MobileElement ibsModule;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/checkbox_logging\")")
    private MobileElement enableLogging;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/button_dialog_positive\")")
    private MobileElement confirmIbsSetup;

    /**
     * Elements for LOGIN
     */

    @iOSXCUITFindBy(accessibility = "LOGIN")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/button_login\")")
    private MobileElement loginCategory;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeTextField'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/edittext_email\")")
    private MobileElement insertEmail;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeSecureTextField'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/edittext_password\")")
    private MobileElement insertPassword;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeButton' AND name MATCHES[c] 'Login'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/button_login\")")
    private MobileElement loginBtn;

    /**
     * Elements for User Profile
     */

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name MATCHES[c] 'Mihai'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/textview_first_name\")")
    public MobileElement loggedInFirstName;


    @Override
    public void initiateModule() {
        clickIBSModule();
        enableLogging();
        confirmIBSModuleSetup();

    }

    public void clickIBSModule() {
        try {
            MyLogger.log.info("Try to click on IBS module");
            gestures.clickOnMobileElement(ibsModule);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on IBS module label");
        }
    }

    public void enableLogging() {
        try {
            MyLogger.log.info("Try to click enable Logging");
            gestures.clickOnMobileElement(enableLogging);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on enable logging");
        }
    }

    public void confirmIBSModuleSetup() {
        try {
            MyLogger.log.info("Try to click on OK to confirm IBS setup");
            gestures.clickOnMobileElement(confirmIbsSetup);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on OK to confirm IBS setup");
        }
    }

    public void selectLoginCategory() {
        try {
            MyLogger.log.info("Try to select Login category");
            gestures.clickOnMobileElement(loginCategory);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot select Login category");
        }
    }

    public void sendTextEmail(String email) {
        try {
            MyLogger.log.info("Send text to Email: " + email);
            gestures.sendText(insertEmail, email);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot text to Email: " + email);
        }
    }

    public void sendTextPassword(String password) {
        try {
            MyLogger.log.info("Send text to Password: " + password);
            gestures.sendText(insertPassword, password);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot text to Password: " + password);
        }
    }

    public void clickLoginBtn() {
        try {
            MyLogger.log.info("Try to click on Login Btn");
            gestures.clickOnMobileElement(loginBtn);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on Login Btn");
        }
    }

    @Override
    public void validateLoggedInUser(String firstname) {
        try {
            MyLogger.log.info("Try to validate logged in user with: " + firstname);
            Assert.assertTrue("", loggedInFirstName.getText().equalsIgnoreCase(firstname));
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot validate logged in user with: " + firstname);
        }
    }
}
