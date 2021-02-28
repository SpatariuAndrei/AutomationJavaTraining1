package login;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

public class loginTests extends BaseTests {


    @Test
    public void testSuccesfullLogin(){

        LoginPage loginPage = homePage.clickFormAuthentificationLink();

        loginPage.setUserName("tomsmith");
        loginPage.inputPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
       Assert.assertEquals(secureAreaPage.getAlertText(),"You logged into a secure area!\n" +
               "×","Alert text is incorrect");


    }



}
