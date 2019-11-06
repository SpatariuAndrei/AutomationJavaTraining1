package pages;

import org.openqa.selenium.WebDriver;
import utils.WebElementHelper;

public class HomePage {

    private WebDriver driver;
    private WebElementHelper helper;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        helper = new WebElementHelper(driver);
    }

    public LoginPage clickFormAuth() {
        helper.clickLink("Form Authentication");
        return new LoginPage(driver);
    }

    public DropdownPage clickDropDown() {
        helper.clickLink("Dropdown");
        return new DropdownPage(driver);
    }

    public HoversPage clickHovers() {
        helper.clickLink("Hovers");
        return new HoversPage(driver);
    }

    public KeyPressesPage clickKeyPresses() {
        helper.clickLink("Key Presses");
        return new KeyPressesPage(driver);
    }
}
