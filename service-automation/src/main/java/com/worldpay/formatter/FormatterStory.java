package com.worldpay.formatter;

import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;

import com.worldpay.service.base.BaseJBehaveStory;
import com.worldpay.service.steps.JBehaveFormatterSteps;

public class FormatterStory extends BaseJBehaveStory {

    public FormatterStory() {
        LOGGER.info("FormatterStory");
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), new JBehaveFormatterSteps());

    }

}
