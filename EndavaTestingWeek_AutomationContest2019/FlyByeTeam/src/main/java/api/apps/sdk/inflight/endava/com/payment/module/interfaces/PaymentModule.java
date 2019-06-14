package api.apps.sdk.inflight.endava.com.payment.module.interfaces;

import api.apps.sdk.inflight.endava.com.InitComponents;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public interface PaymentModule extends InitComponents {

    void fillUserData(String fname, String lname, String country, String email) throws IOException, ParseException;

    void purchseWithCard(String cardNumber, String csv) throws IOException, ParseException;


}
