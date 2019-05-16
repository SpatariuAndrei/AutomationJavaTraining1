package Steps;

import Help.ShareData;
import Pages.AccountPage;
import org.jbehave.core.annotations.Then;

public class AccountSteps extends BaseSteps {

    public AccountPage accountPage=new AccountPage(share.driver).get();

    //Constructor
    public AccountSteps(ShareData share) {
        super(share);
    }


    //Steps
    @Then("AccountPage is displayed")
    public void homePageDisplayed() {
        String expected= ShareData.getValue("accountPage");
        accountPage.validatePage(expected);
    }


    @Then("I logout from site")
    public void logout()
    {
        accountPage.logoutProcess();
    }



}
