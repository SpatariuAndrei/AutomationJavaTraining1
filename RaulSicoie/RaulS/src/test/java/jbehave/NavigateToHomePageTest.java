package jbehave;

import bdd.StoryMapper;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.DemoPageSteps;
import java.util.Arrays;
import java.util.List;

public class NavigateToHomePageTest extends StoryMapper {
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new DemoPageSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return Arrays.asList("stories/openDemoPage.story");
    }
}
