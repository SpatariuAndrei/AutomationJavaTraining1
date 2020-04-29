package com.test.jbehave.tests;

import com.test.jbehave.steps.SignupSteps;
import com.test.jbehave.utils.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import java.util.List;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class SignuUpStories extends StoryMapper {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new SignupSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/sign_up.story", "");

    }
}
