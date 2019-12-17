package tests;

import bdd.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.UsersSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class UsersTest extends StoryMapper {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new UsersSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().
                findPaths(codeLocationFromClass(this.getClass()),
                        "**/stories/users.story", "");
    }

}
