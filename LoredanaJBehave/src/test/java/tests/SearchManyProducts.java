package tests;

import bdd.BaseStory;

import org.jbehave.core.io.StoryFinder;
import steps.BaseSteps;
import steps.SearchManyProductsSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class SearchManyProducts extends BaseStory {

    public SearchManyProducts() {
        addSteps(new BaseSteps(sharedData), new SearchManyProductsSteps(sharedData));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/SearchManyProducts.story", "");
    }
}
