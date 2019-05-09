package api.apps.sdk.inflight.endava.com.ibs.payment.module.interfaces;

import api.apps.sdk.inflight.endava.com.InitComponents;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface IBSPaymentModule extends InitComponents {

    void fetchTariffList(String username, String password) throws FileNotFoundException;

    void fillUserData() throws IOException, ParseException;

    void purchseWithCard(String cardNumber, String csv) throws Exception;
}
