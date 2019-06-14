package cucumber.sdk.tests;

import api.apps.sdk.inflight.endava.com.ibs.voucher.module.VoucherManager;
import cucumber.api.java.en.And;

import java.io.FileNotFoundException;

import static core.json.parsers.ConfigJasonFileReading.runningSetup;

public class IBSVoucherModuleSteps {
    @And("^User selects IBS Voucher Module$")
    public void userSelectsIBSVoucherModule() throws FileNotFoundException {
        String email = runningSetup().getUsermail();
        String pass = runningSetup().getUserpassword();
        VoucherManager voucherManager = new VoucherManager();
        voucherManager.startModule();
        voucherManager.useModule(email, pass);
    }
}
