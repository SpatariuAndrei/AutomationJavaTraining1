package steps.setup.closure;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pages.CartPage;
import pages.HomePage;
import utilities.DataFromPropertyFile;
import utilities.SharedData;

public class AddProductToCartBrowserBasicSteps extends StoryBase {

    private DataFromPropertyFile propertyFile;
    private SharedData sharedData;

    public AddProductToCartBrowserBasicSteps(SharedData sharedData) {
        super(sharedData);
        propertyFile = new DataFromPropertyFile();
        this.sharedData = sharedData;
    }

    @Given("I open eMag home page")
    public void givenIOpenEmagHomePage() {
        sharedData.homePage = new HomePage(sharedData.driver);
        sharedData.homePage.get();
    }

    @Given("I log in")
    public void givenILogIn() {
        sharedData.loginPage = sharedData.homePage.navigateToLoginPage();
        sharedData.loginPage.enterUserEmail();
        sharedData.loginPage.clickNext();
        sharedData.loginPage.enterUserPassword();
        sharedData.loginPage.clickNextValidPassword();
    }

    @AfterScenario
    public void afterScenario() {
        CartPage cartPage = PageFactory.initElements(sharedData.driver, CartPage.class);
        if (!(sharedData.driver.getCurrentUrl().equals(propertyFile.getEmagCartPage()))) {
            sharedData.driver.navigate().to(propertyFile.getEmagCartPage());
        }

        try {
            cartPage.getContainer();
            for (WebElement item : cartPage.getItems()) {
                item.findElement(By.xpath("//a[@class='emg-right remove-product btn-remove-product gtm_rp080219']")).click();
            }
        } catch (Exception e) {

        }
        cartPage.logOut();
    }
}
