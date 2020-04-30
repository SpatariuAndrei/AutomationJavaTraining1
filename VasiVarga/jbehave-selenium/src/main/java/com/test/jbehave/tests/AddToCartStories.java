package com.test.jbehave.tests;

import java.util.List;
import com.test.jbehave.utils.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import com.test.jbehave.steps.AddToCartSteps;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class AddToCartStories extends StoryMapper {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new AddToCartSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/add_to_cart.story", "**/excluded*.story");
    }

}