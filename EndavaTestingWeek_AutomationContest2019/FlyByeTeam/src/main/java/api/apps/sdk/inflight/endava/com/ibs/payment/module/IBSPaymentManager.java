package api.apps.sdk.inflight.endava.com.ibs.payment.module;

import api.apps.sdk.inflight.endava.com.ibs.payment.module.interfaces.IBSPaymentModule;
import api.apps.sdk.inflight.endava.com.ibs.payment.module.interfaces.IBSPaymentModuleAOS;
import api.apps.sdk.inflight.endava.com.ibs.payment.module.interfaces.IBSPaymentModuleIOS;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class IBSPaymentManager {

    private IBSPaymentModule getOS() throws FileNotFoundException {
        IBSPaymentModule ibsPaymentModule = null;
        if (runningSetup().getPlatformName().equalsIgnoreCase("android")) {
            ibsPaymentModule = new IBSPaymentModuleAOS();
        } else if (runningSetup().getPlatformName().equalsIgnoreCase("ios")) {
            ibsPaymentModule = new IBSPaymentModuleIOS();
        }
        return ibsPaymentModule;
    }

    public void startModule() throws FileNotFoundException {
        getOS().initiateModule();
    }

    public void fetchTariffs(String username, String password) throws FileNotFoundException {
        getOS().fetchTariffList(username, password);
    }

    public void creditCardFlow(String cardNumber, String csv) throws Exception {
        getOS().fillUserData();
        getOS().purchseWithCard(cardNumber, csv);
    }
}
