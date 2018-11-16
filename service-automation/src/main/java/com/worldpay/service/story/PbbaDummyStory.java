package com.worldpay.service.story;

import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.worldpay.service.base.BaseJBehaveStory;
import com.worldpay.service.rest.RestSubmissionSteps;
import com.worldpay.service.steps.TestDataSteps;

public class PbbaDummyStory extends BaseJBehaveStory {

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new RestSubmissionSteps(share), new TestDataSteps(share));
    }

}
