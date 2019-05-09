package api.apps.sdk.inflight.endava.com.direct.pay.module.interfaces;

import api.apps.sdk.inflight.endava.com.ibs.account.module.IBSManager;
import api.apps.sdk.inflight.endava.com.payment.module.interfaces.PaymentComponentsAOS;
import api.drivers.Drivers;
import core.classic.methods.Gestures;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class DirectPayModuleAOS implements DirectPayModule {

    public DirectPayModuleAOS() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Gestures gestures = new Gestures();

    /**
     * Elements for initiate module
     */

    @iOSXCUITFindBy(accessibility = "Direct Pay")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Direct Payment Module\")")
    private MobileElement directPaymentModule;

    /**
     * Elements for Direct Pay
     */

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND name MATCHES[c] 'Card'")
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/button_direct_pay\")")
    private MobileElement directPayBtn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"de.telekom.inflight:id/button_dialog_positive\")")
    private MobileElement savePayment;


    @Override
    public void initiateModule() throws FileNotFoundException {
        clickDirectPaymentModule();
        PaymentComponentsAOS paymentComponentsAOS = new PaymentComponentsAOS();
        paymentComponentsAOS.enableLogging();
        paymentComponentsAOS.enableCfgFile();
        paymentComponentsAOS.confirmPaymentModuleSetup();
    }

    @Override
    public void fetchTariffList(String username, String password) throws FileNotFoundException {
        IBSManager ibsManager = new IBSManager();
        ibsManager.successfullLogin(username, password);
        PaymentComponentsAOS paymentComponentsAOS = new PaymentComponentsAOS();
        paymentComponentsAOS.fetchTarifWithConfigfile();
    }

    @Override
    public void fillUserData() {
        PaymentComponentsAOS paymentComponentsAOS = new PaymentComponentsAOS();
        paymentComponentsAOS.clickBuyAustrian();
    }

    @Override
    public void purchseWithCard() {
        DirectPayModuleAOS directPayModuleAOS = new DirectPayModuleAOS();
        directPayModuleAOS.clickDirectPayBtn();
    }


    public void clickDirectPaymentModule() {
        try {
            MyLogger.log.info("Try to click on direct payment module");
            gestures.clickOnMobileElement(directPaymentModule);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on direct payment module label");
        }
    }

    public void clickDirectPayBtn() {
        try {
            MyLogger.log.info("Try to click on direct pay button");
            gestures.clickOnMobileElement(directPayBtn);
            try {
                if (savePayment.isDisplayed()) {
                    gestures.clickOnMobileElement(savePayment);
                }
            } catch (WebDriverException e) {
                //do  nothing
            }
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on direct pay button");
        }
    }

}
