package forgotPassword;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.EmailSentPage;
import pages.ForgotPasswordPage;

import static org.testng.Assert.assertTrue;

public class forgotPasswordTests extends BaseTest {

    @Test
    public void testPasswordSentToEmail(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.setEmail("whatever@wow.com");
        EmailSentPage emailSentPage = forgotPasswordPage.clickRetrievePassword();
        assertTrue(emailSentPage.getConfirmationText()
                        .contains("Your e-mail's been sent!"),
                        "Alert text is incorrect!");
    }


}
