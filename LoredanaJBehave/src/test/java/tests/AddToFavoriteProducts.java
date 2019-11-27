package tests;

import bdd.BaseStory;
import org.jbehave.core.io.StoryFinder;
import steps.AddToFavoriteProductsSteps;
import steps.BaseSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class AddToFavoriteProducts extends BaseStory {
    public AddToFavoriteProducts() {
        addSteps(new BaseSteps(sharedData), new AddToFavoriteProductsSteps(sharedData));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/AddToFavoriteProducts.story", "");
    }
}