package tests;

import bdd.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.AddProductToCartSteps;
import steps.PlaceOrderSteps;
import steps.setup.closure.PlaceOrderBasicSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class PlaceOrderTest extends StoryMapper {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new AddProductToCartSteps(share),
                new PlaceOrderSteps(share),
                new PlaceOrderBasicSteps(share));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/place_order_story.story", "");
    }
}
