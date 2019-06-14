package api.apps.sdk.inflight.endava.com.direct.pay.module.interfaces;

import api.apps.sdk.inflight.endava.com.InitComponents;

import java.io.FileNotFoundException;

public interface DirectPayModule extends InitComponents {

    void fetchTariffList(String username, String password) throws FileNotFoundException;

    void fillUserData();

    void purchseWithCard();

}
