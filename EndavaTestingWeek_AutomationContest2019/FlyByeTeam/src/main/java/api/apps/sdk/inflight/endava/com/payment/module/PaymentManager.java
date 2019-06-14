package api.apps.sdk.inflight.endava.com.payment.module;

import api.apps.sdk.inflight.endava.com.payment.module.interfaces.M3handlerPayment;
import api.apps.sdk.inflight.endava.com.payment.module.interfaces.PaymentComponentIOS;
import api.apps.sdk.inflight.endava.com.payment.module.interfaces.PaymentComponentsAOS;
import api.apps.sdk.inflight.endava.com.payment.module.interfaces.PaymentModule;

import java.io.FileNotFoundException;
import java.io.IOException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class PaymentManager {

    private PaymentModule getOS() throws FileNotFoundException {
        PaymentModule paymentModule = null;
        if (runningSetup().getPlatformName().equalsIgnoreCase("android")) {
            paymentModule = new PaymentComponentsAOS();
        } else if (runningSetup().getPlatformName().equalsIgnoreCase("ios")) {
            paymentModule = new PaymentComponentIOS();
        }
        return paymentModule;
    }

    public void creditCardFlow(String fname, String lname, String country, String email, String cardNumber, String csv) throws Exception {
        getOS().fillUserData(fname, lname, country, email);
        getOS().purchseWithCard(cardNumber, csv);
    }

    public void startModule() throws FileNotFoundException {
        getOS().initiateModule();
    }

    public void fetchTariffs() throws FileNotFoundException {
        PaymentComponentsAOS paymentComponentsAOS = new PaymentComponentsAOS();
        paymentComponentsAOS.fetchTariffList();
    }

    public void validateM3LoginWithReceivedCredentials(String paymentType) throws IOException {
        M3handlerPayment m3handler = new M3handlerPayment();
        m3handler.validateM3SuccessLogin(paymentType);
    }

}
