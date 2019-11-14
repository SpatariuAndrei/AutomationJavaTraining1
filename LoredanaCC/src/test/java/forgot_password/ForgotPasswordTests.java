package forgot_password;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void forgotPassword() {
        ForgotPasswordPage forgotPassPage = homePage.clickForgotPassword();
        forgotPassPage.enterEmail("Lore@endava.com");
        EmailPage emailPage = forgotPassPage.clickRetrievePassword();
        assertEquals(emailPage.getResult(), "Your e-mail's been sent!", "Error - email can't be sent!");
    }

}
