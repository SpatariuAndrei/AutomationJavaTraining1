package forgotpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.SentEmailPage;

import static org.testng.Assert.assertTrue;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testRecoverPassword() {

        var forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmailField("tau@example.com");
        SentEmailPage sentEmailPage = forgotPasswordPage.clickRetrievePasswordButton();
        assertTrue(sentEmailPage.getAlertText()
                        .contains("Your e-mail's been sent!"),
                "Alert recovering password failed");
    }
}
