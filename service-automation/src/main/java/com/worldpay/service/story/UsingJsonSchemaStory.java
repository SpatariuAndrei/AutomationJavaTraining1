package com.worldpay.service.story;

import com.worldpay.service.base.BaseJBehaveStory;
import com.worldpay.service.rest.RestSubmissionSteps;
import com.worldpay.service.steps.TestDataSteps;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

public class UsingJsonSchemaStory extends BaseJBehaveStory {
    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new RestSubmissionSteps(share), new TestDataSteps(share));
    }
}
