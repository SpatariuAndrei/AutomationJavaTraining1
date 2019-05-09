package api.apps.sdk.inflight.endava.com.ibs.voucher.module.interfaces;

import api.apps.sdk.inflight.endava.com.ibs.account.module.IBSManager;
import api.apps.sdk.inflight.endava.com.ibs.account.module.interfaces.IBSModuleIOS;

import java.io.FileNotFoundException;

public class IBSVoucherIOS extends IBSVoucherAOS {

    @Override
    public void initiateModule() throws FileNotFoundException {
        //do nothing
    }

    @Override
    public void useVoucherModule(String username, String password) {
        IBSModuleIOS ibsModuleIOS = new IBSModuleIOS();
        ibsModuleIOS.initiateModule();
        IBSManager ibsManager = new IBSManager();
        ibsManager.successfullLogin(username, password);
        ibsModuleIOS.clickOkBtnToDismissLoginNot();
        super.clickIbsVoucherModule();
    }
}
