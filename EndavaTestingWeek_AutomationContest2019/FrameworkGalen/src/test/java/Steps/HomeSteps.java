package Steps;

import Help.ShareData;
import Pages.HomePage;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

public class HomeSteps extends BaseSteps {

    public HomePage homePage=new HomePage(share.driver).get();

    public HomeSteps(ShareData share) {
        super(share);
    }


    @Given("Home page was displayed")
    public void homePageDisplayed() throws Exception {
        String expected= ShareData.getValue("homePage");
        homePage.validateHomePage(expected);
    }

    @When("I enter on loginPage")
    public void validateLoginPage() {

        homePage.clickSignUp();
    }

    @When("I enter on blogListPage")
    public void validateBlogListPage() {

        homePage.clickBlogListButton();
    }

    @When("I enter on registrationPage")
    public void enterRegisterPage()  {
        String url= ShareData.getValue("registerURL");
        share.driver.navigate().to(url);
    }
}
