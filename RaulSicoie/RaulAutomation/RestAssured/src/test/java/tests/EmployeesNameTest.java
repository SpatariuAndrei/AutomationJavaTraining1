package tests;

import bdd.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.EmployeesNameSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class EmployeesNameTest extends StoryMapper {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new EmployeesNameSteps());
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().
                findPaths(codeLocationFromClass(this.getClass()),
                        "**/stories/employees_name.story", "");
    }
}
