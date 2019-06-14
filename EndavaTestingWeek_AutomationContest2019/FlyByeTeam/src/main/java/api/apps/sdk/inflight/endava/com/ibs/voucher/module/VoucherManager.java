package api.apps.sdk.inflight.endava.com.ibs.voucher.module;

import api.apps.sdk.inflight.endava.com.ibs.voucher.module.interfaces.IBSVoucherAOS;
import api.apps.sdk.inflight.endava.com.ibs.voucher.module.interfaces.IBSVoucherIOS;
import api.apps.sdk.inflight.endava.com.ibs.voucher.module.interfaces.IBSVoucherModule;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class VoucherManager {

    private IBSVoucherModule getOS() throws FileNotFoundException {
        IBSVoucherModule ibsVoucherModule = null;
        if (runningSetup().getPlatformName().equalsIgnoreCase("android")) {
            ibsVoucherModule = new IBSVoucherAOS();
        } else if (runningSetup().getPlatformName().equalsIgnoreCase("ios")) {
            ibsVoucherModule = new IBSVoucherIOS();
        }
        return ibsVoucherModule;
    }

    public void startModule() throws FileNotFoundException {
        getOS().initiateModule();
    }

    public void useModule(String email, String password) throws FileNotFoundException {
        getOS().useVoucherModule(email, password);
    }
}
