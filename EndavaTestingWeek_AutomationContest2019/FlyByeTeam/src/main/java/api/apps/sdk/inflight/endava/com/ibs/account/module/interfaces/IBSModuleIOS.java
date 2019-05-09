package api.apps.sdk.inflight.endava.com.ibs.account.module.interfaces;

import api.drivers.Drivers;
import core.classic.methods.Gestures;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

public class IBSModuleIOS extends IBSModuleAOS {

    public IBSModuleIOS() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Gestures gestures = new Gestures();


    @iOSXCUITFindBy(accessibility = "USER ACCOUNT")
    private MobileElement userAccount;

    @iOSXCUITFindBy(accessibility = "OK")
    private MobileElement OKBtn;

    @Override
    public void initiateModule() {
        super.clickIBSModule();
    }

    @Override
    public void validateLoggedInUser(String firstname) {
        try {
            clickOkBtnToDismissLoginNot();
            super.clickIBSModule();
            clickUserAccount();
            MyLogger.log.info("Try to validate logged in user with: " + firstname);
            Assert.assertTrue("", loggedInFirstName.getText().equalsIgnoreCase(firstname));
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot validate logged in user with: " + firstname);
        }
    }

    public void clickUserAccount() {
        try {
            MyLogger.log.info("Try to click on User Account");
            gestures.clickOnMobileElement(userAccount);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on User Account");
        }
    }

    public void clickOkBtnToDismissLoginNot() {
        try {
            MyLogger.log.info("Try to click on OK btn to dismiss successful login notification");
            gestures.clickOnMobileElement(OKBtn);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on OK btn to dismiss successful login notification");
        }
    }


}
