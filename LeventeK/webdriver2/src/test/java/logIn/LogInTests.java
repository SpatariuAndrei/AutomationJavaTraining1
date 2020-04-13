package logIn;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LogInPage;

public class LogInTests extends BaseTest {

    @Test
    public void testLogInInvalidProcessMessage1(){
        LogInPage logInPage = homePage.clickSignIn();
        String email = "whatever@whatever.com";
        logInPage.enterEmail(email);
        logInPage.clickEnterButton();
        Assert.assertEquals(logInPage.getErrorMessageText(), "Invalid User Name or PassWord");

    }

    @Test
    public void testLogInInvalidProcessMessage2(){
        LogInPage logInPage = homePage.clickSignIn();
        String password = "whatever";
        logInPage.enterPassword(password);
        logInPage.clickEnterButton();
        Assert.assertEquals(logInPage.getErrorMessageText(), "Invalid User Name or PassWord");

    }

    @Test
    public void testLogInInvalidProcessMessage3(){
        LogInPage logInPage = homePage.clickSignIn();
        String email = "x12";
        String password = "asd";
        logInPage.enterEmail(email);
        logInPage.enterPassword(password);
        logInPage.clickEnterButton();
        Assert.assertEquals(logInPage.getErrorMessageText(), "Invalid User Name or PassWord");

    }

    @Test
    public void testLogInInvalidProcessMessage4(){
        LogInPage logInPage = homePage.clickSignIn();
        logInPage.clickEnterButton();
        Assert.assertEquals(logInPage.getErrorMessageText(), "Invalid User Name or PassWord");

    }



}
