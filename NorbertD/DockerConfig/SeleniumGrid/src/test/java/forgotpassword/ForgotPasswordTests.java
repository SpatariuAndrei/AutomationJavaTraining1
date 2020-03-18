package forgotpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.EmailSentConfirmationPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertEquals;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testSuccessEmailSent(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail("test@test.com");
        EmailSentConfirmationPage confirmationPage = forgotPasswordPage.clickRetrievePassword();
        assertEquals(confirmationPage.getConfirmationMessage(),"Your e-mail's been sent!", "Password Retrieve email not sent!");
    }
}
