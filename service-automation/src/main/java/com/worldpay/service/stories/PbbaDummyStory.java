package com.worldpay.service.stories;

import java.util.List;

import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.worldpay.service.base.BaseJBehaveStory;
import com.worldpay.service.rest.RestSubmissionSteps;

public class PbbaDummyStory extends BaseJBehaveStory{
    
    public PbbaDummyStory() {
        LOGGER.info(getClass().getName());
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new RestSubmissionSteps(share));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(), "**/PbbaDummyStory.story", null);
    }

    
    

}
