package api.apps.sdk.inflight.endava.com.ibs.payment.module.interfaces;

import api.apps.sdk.inflight.endava.com.ibs.account.module.IBSManager;
import api.apps.sdk.inflight.endava.com.payment.module.interfaces.PaymentComponentsAOS;
import api.apps.sdk.inflight.endava.com.payment.module.interfaces.WebPaymentAOS;
import api.drivers.Drivers;
import core.classic.methods.Gestures;
import core.watchers.MyLogger;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class IBSPaymentModuleAOS implements IBSPaymentModule {

    public IBSPaymentModuleAOS() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Gestures gestures = new Gestures();

    /**
     * Elements for initiate module
     */

    @iOSXCUITFindBy(accessibility = "IBS Payment")
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Payment with IBS Module\")")
    private MobileElement ibsPaymentModule;


    @Override
    public void initiateModule() {
        clickIbsPaymentModule();
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
    public void fillUserData() throws IOException, ParseException {
        PaymentComponentsAOS paymentComponentsAOS = new PaymentComponentsAOS();
        paymentComponentsAOS.clickBuyAustrian();
        paymentComponentsAOS.buyNow();
    }

    @Override
    public void purchseWithCard(String cardNumber, String csv) throws Exception {
        WebPaymentAOS webPaymentAOS = new WebPaymentAOS();
        webPaymentAOS.purchaseWithCreditCard(cardNumber, csv);
    }

    public void clickIbsPaymentModule() {
        try {
            MyLogger.log.info("Try to click on ibs payment module");
            gestures.clickOnMobileElement(ibsPaymentModule);
        } catch (NoSuchElementException var2) {
            throw new AssertionError("Cannot click on ibs payment module label");
        }
    }

}
