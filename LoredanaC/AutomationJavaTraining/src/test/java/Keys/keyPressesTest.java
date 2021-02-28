package Keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

public class keyPressesTest extends BaseTests {

    @Test
    public void testBackSpace(){
        KeyPressesPage keyPressespage = homePage.clickKeyPressesLink();
        keyPressespage.specialKeysInputField("A"  + Keys.BACK_SPACE);
        Assert.assertEquals(keyPressespage.getResult(), "You entered: BACK_SPACE");


    }

    @Test
    public void testDot (){
        KeyPressesPage keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.specialKeysInputField("A" + Keys.DECIMAL);
        Assert.assertEquals(keyPressesPage.getResult(), "You entered: DECIMAL");

    }
    @Test
    public void testHashtag(){
        KeyPressesPage keyPressesPage = homePage.clickKeyPressesLink();
        keyPressesPage.enterHashtag();
        Assert.assertEquals(keyPressesPage.getResult(), "You entered: 3");




    }


    }


