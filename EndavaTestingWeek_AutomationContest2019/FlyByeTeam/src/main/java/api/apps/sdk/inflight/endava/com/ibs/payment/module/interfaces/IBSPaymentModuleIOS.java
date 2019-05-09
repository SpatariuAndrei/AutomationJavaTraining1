package api.apps.sdk.inflight.endava.com.ibs.payment.module.interfaces;

import api.apps.sdk.inflight.endava.com.ibs.account.module.IBSManager;
import api.apps.sdk.inflight.endava.com.ibs.account.module.interfaces.IBSModuleIOS;
import api.apps.sdk.inflight.endava.com.payment.module.interfaces.PaymentComponentIOS;
import api.apps.sdk.inflight.endava.com.payment.module.interfaces.PaymentComponentsAOS;
import api.drivers.Drivers;
import core.classic.methods.Gestures;
import core.classic.methods.Waiters;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;
import java.io.IOException;

public class IBSPaymentModuleIOS extends IBSPaymentModuleAOS {

    public IBSPaymentModuleIOS() {
        AppiumDriver driver = Drivers.getMobileDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private final Gestures gestures = new Gestures();
    private final Waiters waiters = new Waiters();

    @Override
    public void initiateModule() {
        //do nothing for the moment
    }

    @Override
    public void fetchTariffList(String username, String password) throws FileNotFoundException {
        IBSManager ibsManager = new IBSManager();
        ibsManager.startModule();
        ibsManager.successfullLogin(username, password);
        IBSModuleIOS ibsModuleIOS = new IBSModuleIOS();
        ibsModuleIOS.clickOkBtnToDismissLoginNot();
        super.clickIbsPaymentModule();
    }

    @Override
    public void fillUserData() throws IOException, ParseException {
        PaymentComponentsAOS paymentComponentsAOS = new PaymentComponentsAOS();
        paymentComponentsAOS.clickBuyAustrian();
        PaymentComponentIOS paymentComponentIOS = new PaymentComponentIOS();
        paymentComponentIOS.clickConfirmBuy();
        paymentComponentsAOS.buyNow();
    }

    @Override
    public void purchseWithCard(String cardNumber, String csv) throws Exception {
        PaymentComponentIOS paymentComponentIOS = new PaymentComponentIOS();
        paymentComponentIOS.purchseWithCard(cardNumber, csv);
    }
}
