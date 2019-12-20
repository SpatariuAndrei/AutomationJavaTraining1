package jbehave;

import bdd.StoryMapper;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.FormAuthenticationPageSteps;

import java.util.Arrays;
import java.util.List;

public class AuthenticationTest extends StoryMapper {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new FormAuthenticationPageSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("stories/openFormAuthentication.story");
    }

}
