package api.apps.sdk.inflight.endava.com.ibs.account.module;

import api.apps.sdk.inflight.endava.com.ibs.account.module.interfaces.IBSModule;
import api.apps.sdk.inflight.endava.com.ibs.account.module.interfaces.IBSModuleAOS;
import api.apps.sdk.inflight.endava.com.ibs.account.module.interfaces.IBSModuleIOS;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class IBSManager {

    private IBSModule getOS() throws FileNotFoundException {
        IBSModule ibsModule = null;
        if (runningSetup().getPlatformName().equalsIgnoreCase("android")) {
            ibsModule = new IBSModuleAOS();
        } else if (runningSetup().getPlatformName().equalsIgnoreCase("ios")) {
            ibsModule = new IBSModuleIOS();
        }
        return ibsModule;
    }

    public void startModule() throws FileNotFoundException {
        getOS().initiateModule();
    }

    public void successfullLogin(String email, String password) {
        IBSModuleAOS ibsModuleAOS = new IBSModuleAOS();
        ibsModuleAOS.selectLoginCategory();
        ibsModuleAOS.sendTextEmail(email);
        ibsModuleAOS.sendTextPassword(password);
        ibsModuleAOS.clickLoginBtn();
    }

    public void validateSuccessullLogin(String firstname) throws FileNotFoundException {
        getOS().validateLoggedInUser(firstname);
    }
}
