package Steps;

import Help.ShareData;
import Pages.RegistrationPage;
import org.jbehave.core.annotations.When;

public class RegistrationSteps extends BaseSteps {

    public RegistrationPage registerPage=new RegistrationPage(share.driver).get();

    //Constructor
    public RegistrationSteps(ShareData share) {
        super(share);
    }


    //Steps
    @When("I create a new account")
    public void createAccount()
    {
        registerProcess();
    }



    public void registerProcess()
    {
        String companyName=ShareData.getValue("company")+System.currentTimeMillis();
        String fullName=ShareData.getValue("fullName");
        String workEmail=functions.generateEmail();
        String password=ShareData.getValue("passwordReg");
        String phone=ShareData.getValue("phone");
        registerPage.registerProcess(companyName,fullName,workEmail,password,phone);
    }
}
