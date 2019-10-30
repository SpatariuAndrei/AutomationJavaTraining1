package tests;

import org.jbehave.core.io.StoryFinder;
import bdd.setup.StoryMapper;
import steps.AddTwoElementsSteps;
import steps.setup.StoryBasic;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class AddTwoElementsTest extends StoryMapper {

    public AddTwoElementsTest() {
        addSteps(new StoryBasic(share), new AddTwoElementsSteps(share));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/add_two_elements.story", "");
    }
}
