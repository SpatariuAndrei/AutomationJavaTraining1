package api.apps.sdk.inflight.endava.com.ibs.voucher.module.interfaces;

import api.apps.sdk.inflight.endava.com.ibs.account.module.IBSManager;
import api.apps.sdk.inflight.endava.com.ibs.account.module.interfaces.IBSModuleAOS;
import api.drivers.Drivers;
import core.classic.methods.Gestures;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class IBSVoucherAOS implements IBSVoucherModule {

    public IBSVoucherAOS() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Gestures gestures = new Gestures();

    /**
     * Elements for initiate module
     */

    @iOSXCUITFindBy(accessibility = "IBS Vouchers")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Vouchers with IBS Module\")")
    private MobileElement ibsVoucherModule;


    @Override
    public void initiateModule() throws FileNotFoundException {
        clickIbsVoucherModule();
        IBSModuleAOS ibsModuleAOS = new IBSModuleAOS();
        ibsModuleAOS.enableLogging();
        ibsModuleAOS.confirmIBSModuleSetup();
    }

    @Override
    public void useVoucherModule(String username, String password) {
        IBSManager ibsManager = new IBSManager();
        ibsManager.successfullLogin(username, password);

    }

    public void clickIbsVoucherModule() {
        try {
            MyLogger.log.info("Try to click on ibs voucher module");
            gestures.clickOnMobileElement(ibsVoucherModule);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on ibs voucher module label");
        }
    }

}
