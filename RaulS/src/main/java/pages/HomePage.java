package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WebElementHelper;

public class HomePage {

    private WebDriver driver;
    private WebElementHelper helper;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        helper = new WebElementHelper(driver);
    }

    //if your action changes the page -> should return a handle of that page
    public LoginPage clickFormAuthentication() {
        helper.clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropDownPage clickDropDown() {
        helper.clickLink("Dropdown");
        return new DropDownPage(driver);
    }

    public ForgotPasswordPage clickForgotPassword() {
        helper.clickLink("Forgot Password");
        return new ForgotPasswordPage(driver);
    }

    public HoversPage clickHovers() {
        helper.clickLink("Hovers");
        return new HoversPage(driver);
    }
}
