package com.worldpay.service.story;

import java.util.List;

import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.worldpay.service.base.BaseJBehaveStory;
import com.worldpay.service.rest.RestSubmissionSteps;
import com.worldpay.service.steps.TestDataSteps;

public class PbbaTestDataStory extends BaseJBehaveStory {

    public PbbaTestDataStory() {
        LOGGER.info(getClass().getName());
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new RestSubmissionSteps(share), new TestDataSteps(share));
    }

    @Override
    protected List<String> storyPaths() {
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromClass(this.getClass()).getFile(), "**/PbbaTestDataStory.story", null);
    }

}
