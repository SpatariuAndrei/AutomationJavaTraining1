package tests;

import bdd.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.AddProductToCartSteps;
import steps.LoginSteps;
import steps.RegisterSteps;
import steps.setup.closure.RegisterBasicSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class RegisterTest extends StoryMapper {
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new LoginSteps(share),
                new AddProductToCartSteps(share),
                new RegisterSteps(share),
                new RegisterBasicSteps(share));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/register.story", "");
    }
}
