package tests;

import bdd.StoryMapper;
import bdd.steps.functional.product.ProductSteps;
import bdd.steps.functional.wishlist.WishlistSteps;
import bdd.steps.setup.StoryBasicsSteps;
import net.bytebuddy.asm.MemberSubstitution;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import bdd.steps.functional.login.LoginSteps;
import bdd.steps.setup.BrowserBasicSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class AddProductsToFavorites extends StoryMapper {
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(),
                new StoryBasicsSteps(sharedData),
                new ProductSteps(sharedData),
                new WishlistSteps(sharedData));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/AddProductsToFavorites.story", "");
    }
}
