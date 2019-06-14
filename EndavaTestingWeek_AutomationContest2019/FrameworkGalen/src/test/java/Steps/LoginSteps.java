package Steps;

import Help.ShareData;
import Pages.LoginPage;
import org.jbehave.core.annotations.When;

public class LoginSteps extends BaseSteps {

    public LoginPage loginPage=new LoginPage(share.driver).get();

    //Constructor
    public LoginSteps(ShareData share) {
        super(share);
    }


    //Steps
    @When("I login with valid values")
    public void loginValidProcess()  {
        String email= ShareData.getValue("email");
        String password= ShareData.getValue("password");
        loginPage.loginProcess(email,password);

    }



}
