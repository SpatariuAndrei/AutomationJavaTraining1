package steps.functional.login;

import org.jbehave.core.steps.Steps;
import pages.BasePage;
import steps.setup.BaseSteps;
import utilities.SharedData;

public class LoginSteps extends Steps {
    protected SharedData share;

    public LoginSteps(SharedData share) {
        this.share = share;
    }
}
