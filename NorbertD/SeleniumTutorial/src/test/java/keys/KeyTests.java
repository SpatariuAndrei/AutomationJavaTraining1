package keys;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.KeyPressesPage;

import static org.testng.Assert.*;

public class KeyTests extends BaseTests {

    @Test
    public void testBackspace(){
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterText("A"+ Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(),"You entered: BACK_SPACE");
    }

    @Test
    public void testDollarSign(){
        KeyPressesPage keyPage = homePage.clickKeyPresses();
        keyPage.enterDollarSign();
    }
}
