package tests;

import bdd.StoryMapper;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.EmagAddProductToFavoritesSteps;
import steps.setup.closure.FavoritePageEndingStory;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class AddToFavoritesTest extends StoryMapper {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new FavoritePageEndingStory(share),
                new EmagAddProductToFavoritesSteps(share),
                new FavoritePageEndingStory(share));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/add_product_to_favorite.story", "");
    }
}
