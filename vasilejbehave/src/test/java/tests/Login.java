package tests;


import bdd.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import bdd.steps.functional.login.LoginSteps;
import bdd.steps.setup.BrowserBasicSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class Login extends StoryMapper {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new BrowserBasicSteps(sharedData), new LoginSteps(sharedData));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/Login.story", "");
    }
}