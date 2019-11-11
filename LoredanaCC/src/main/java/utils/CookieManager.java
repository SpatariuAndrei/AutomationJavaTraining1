package utils;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CookieManager {

    WebDriver driver;

    public CookieManager(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void setCookie() {
        Cookie cookie = new Cookie.Builder("tau", "123").domain("the-internet.herokuapp.com").build();
        driver.manage().addCookie(cookie);
    }

    public void deleteCookie(String cookieName) {
        driver.manage().deleteCookieNamed(cookieName);
    }

    public boolean getCookie(String cookieName) {
       return  driver.manage().getCookieNamed(cookieName) != null;
    }

}
