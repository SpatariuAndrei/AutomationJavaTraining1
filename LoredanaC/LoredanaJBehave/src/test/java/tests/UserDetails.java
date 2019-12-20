package tests;

import bdd.BaseStory;
import org.jbehave.core.io.StoryFinder;
import steps.BaseSteps;
import steps.UserDetailsSteps;

import java.util.List;

import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;

public class UserDetails extends BaseStory {

    public UserDetails() {
        addSteps(new BaseSteps(sharedData), new UserDetailsSteps(sharedData));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()), "**/stories/UserDetails.story", "");
    }
}