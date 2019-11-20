package tests;

import bdd.BaseStory;

import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.CandidateSteps;
import steps.functional.login.LoginSteps;
import steps.setup.BaseSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class Login extends BaseStory {
    public Login() {
        addSteps(new BaseSteps(share), new LoginSteps(share));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/Login.story", "");
    }
}
