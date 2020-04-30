package com.test.jbehave.tests;

import com.test.jbehave.steps.AccountSteps;
import com.test.jbehave.utils.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class SignInStories extends StoryMapper {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new AccountSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/sign_in.story", "");
    }

}
