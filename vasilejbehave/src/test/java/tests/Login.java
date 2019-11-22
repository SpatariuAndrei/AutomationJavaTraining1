package tests;

import bdd.BaseStory;

import org.jbehave.core.io.StoryFinder;
import steps.functional.login.LoginSteps;
import steps.functional.useraccount.UserAccountSteps;
import steps.setup.BaseSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class Login extends BaseStory {
    public Login() {
        addSteps(new BaseSteps(sharedData), new LoginSteps(sharedData), new UserAccountSteps(sharedData));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/Login.story", "");
    }
}
