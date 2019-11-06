package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTests {

    @Test
    public void testLogin() {
        LoginPage loginPage = homePage.clickFormAuth();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        //assertEquals(secureAreaPage.getSecureText(), "You logged into a secure area! x", "Alert text is incorrect!");
        assertTrue(secureAreaPage.getSecureText().contains("You logged into a secure area!"), "Alert text is incorrect!");
    }
}
