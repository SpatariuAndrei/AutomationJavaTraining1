package api.apps.sdk.inflight.endava.com.direct.pay.module.interfaces;

import api.apps.sdk.inflight.endava.com.ibs.account.module.IBSManager;
import api.apps.sdk.inflight.endava.com.ibs.account.module.interfaces.IBSModuleIOS;
import api.apps.sdk.inflight.endava.com.payment.module.interfaces.PaymentComponentIOS;
import api.apps.sdk.inflight.endava.com.payment.module.interfaces.PaymentComponentsAOS;

import java.io.FileNotFoundException;

public class DirectPayModuleIOS extends DirectPayModuleAOS {

    @Override
    public void initiateModule() throws FileNotFoundException {
//do nothing
    }

    @Override
    public void fetchTariffList(String username, String password) throws FileNotFoundException {
        IBSManager ibsManager = new IBSManager();
        ibsManager.startModule();
        ibsManager.successfullLogin(username, password);
        IBSModuleIOS ibsModuleIOS = new IBSModuleIOS();
        ibsModuleIOS.clickOkBtnToDismissLoginNot();
        super.clickDirectPaymentModule();
    }

    @Override
    public void fillUserData() {
        PaymentComponentsAOS paymentComponentsAOS = new PaymentComponentsAOS();
        paymentComponentsAOS.clickBuyAustrian();
        PaymentComponentIOS paymentComponentIOS = new PaymentComponentIOS();
        paymentComponentIOS.clickConfirmBuy();
    }

    @Override
    public void purchseWithCard() {
        DirectPayModuleAOS directPayModuleAOS = new DirectPayModuleAOS();
        directPayModuleAOS.clickDirectPayBtn();
    }

}
