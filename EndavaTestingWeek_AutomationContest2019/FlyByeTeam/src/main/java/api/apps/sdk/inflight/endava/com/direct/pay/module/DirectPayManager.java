package api.apps.sdk.inflight.endava.com.direct.pay.module;

import api.apps.sdk.inflight.endava.com.direct.pay.module.interfaces.DirectPayModule;
import api.apps.sdk.inflight.endava.com.direct.pay.module.interfaces.DirectPayModuleAOS;
import api.apps.sdk.inflight.endava.com.direct.pay.module.interfaces.DirectPayModuleIOS;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class DirectPayManager {

    private DirectPayModule getOS() throws FileNotFoundException {
        DirectPayModule directPayModule = null;
        if (runningSetup().getPlatformName().equalsIgnoreCase("android")) {
            directPayModule = new DirectPayModuleAOS();
        } else if (runningSetup().getPlatformName().equalsIgnoreCase("ios")) {
            directPayModule = new DirectPayModuleIOS();
        }
        return directPayModule;
    }

    public void startModule() throws FileNotFoundException {
        getOS().initiateModule();
    }

    public void fetchTariffs(String username, String password) throws FileNotFoundException {
        getOS().fetchTariffList(username, password);
    }

    public void creditCardFlow() throws FileNotFoundException {
        getOS().fillUserData();

        getOS().purchseWithCard();

    }
}
