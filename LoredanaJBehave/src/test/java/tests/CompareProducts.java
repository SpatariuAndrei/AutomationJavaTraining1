package tests;

import bdd.BaseStory;

import org.jbehave.core.io.StoryFinder;
import steps.BaseSteps;
import steps.CompareProductsSteps;
import steps.EmagLoginSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class CompareProducts extends BaseStory {
    public CompareProducts() {
        addSteps(new BaseSteps(sharedData), new CompareProductsSteps(sharedData));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/CompareProducts.story", "");
    }
}