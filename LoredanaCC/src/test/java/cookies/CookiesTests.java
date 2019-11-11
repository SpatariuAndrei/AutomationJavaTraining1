package cookies;

import base.BaseTests;
import org.testng.annotations.Test;
import utils.CookieManager;

import static org.testng.Assert.assertEquals;

public class CookiesTests extends BaseTests {

    @Test
    public void deleteCookie() {
        CookieManager cookieManager = homePage.getCookieManager();
        cookieManager.deleteCookie("optimizelyBuckets");
        assertEquals(cookieManager.getCookie("optimizelyBuckets"), false, "cookie not deleted");
    }
}
