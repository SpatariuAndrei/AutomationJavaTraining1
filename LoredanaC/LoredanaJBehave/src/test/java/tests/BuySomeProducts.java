package tests;


import bdd.BaseStory;
import org.jbehave.core.io.StoryFinder;
import steps.BaseSteps;
import steps.BuySomeProductsSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class BuySomeProducts extends BaseStory {

    public BuySomeProducts() {
        addSteps(new BaseSteps(sharedData), new BuySomeProductsSteps(sharedData));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/BuySomeProducts.story", "");
    }
}