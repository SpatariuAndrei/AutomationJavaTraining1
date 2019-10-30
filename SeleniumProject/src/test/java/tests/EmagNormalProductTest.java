package tests;

import org.jbehave.core.io.StoryFinder;
import bdd.setup.StoryMapper;
import steps.EmagNormalProductSteps;
import steps.setup.StoryBasic;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class EmagNormalProductTest extends StoryMapper {

    public EmagNormalProductTest() {
        addSteps(new StoryBasic(share), new EmagNormalProductSteps(share));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/emag_normal_product.story", "");
    }
}
