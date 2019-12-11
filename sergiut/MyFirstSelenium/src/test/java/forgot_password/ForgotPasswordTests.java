package forgot_password;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertTrue;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testEmailSent() {
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        String email = "Sergiu@example.com";
        forgotPasswordPage.setEmail(email);
        EmailSentPage emailSentPage = forgotPasswordPage.retrievePasssword();
        emailSentPage.emailRetrieveConfirmation();
        assertTrue(emailSentPage.emailRetrieveConfirmation().contains("Your e-mail's been sent!"), "Email incorect!");
    }
}
