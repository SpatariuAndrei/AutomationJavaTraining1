package pages.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class PageFactoryUtils {

    private WebDriver driver;
    private LoginPage cachedLoginPage;

    public PageFactoryUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * to be able to reuse the same page object instance across multiple steps classes
     * @return
     */
    public LoginPage getCachedLoginPage() {
        return cachedLoginPage != null ? cachedLoginPage : newLoginPage();
    }

    public LoginPage newLoginPage() {
        return PageFactory.initElements(driver, LoginPage.class);
    }

    public HomePage newHomePage() {
        return PageFactory.initElements(driver, HomePage.class);
    }

    public CartPage newCartPage() {
        return PageFactory.initElements(driver, CartPage.class);
    }

    public ProductPage newProductPage() {
        return PageFactory.initElements(driver, ProductPage.class);
    }

    public ResealedPage newResealedPage() {
        return PageFactory.initElements(driver, ResealedPage.class);
    }

    public SearchPage newSearchPage() {
        return PageFactory.initElements(driver, SearchPage.class);
    }
}
