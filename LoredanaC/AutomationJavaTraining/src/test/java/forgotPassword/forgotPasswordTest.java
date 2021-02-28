package forgotPassword;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.PasswordConfirmationPage;

import java.net.PortUnreachableException;

public class forgotPasswordTest extends BaseTests {


    @Test
    public void passswordRecoveryTest(){
        ForgotPasswordPage forgotPasswordPage = homePage.clickForgotPasswordLink();
        forgotPasswordPage.inputEmail("andrei@yahoo.com");
        PasswordConfirmationPage passwordConfirmationPage = forgotPasswordPage.clickRetrievePasswordButton();
        Assert.assertEquals(passwordConfirmationPage.getPasswordConfirmationText(),"Internal Server Error", "Confirmation Text is incorrect");


    }



}
